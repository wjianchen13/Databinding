# Databinding基础使用





# 参考文档
https://bbs.huaweicloud.com/blogs/270048
https://juejin.cn/post/6844903549223059463#heading-12
https://www.imooc.com/learn/719

Mvvm模式: Databinding 与 ViewModel+LiveData+Repository（下篇）
https://sq.sf.163.com/blog/article/178636899999080448

android databinding限制有哪些
https://www.yisu.com/ask/50285507.html

Android dataBinding和viewBinding的区别
https://blog.csdn.net/datian1234/article/details/135889342

Android Jetpack
https://juejin.cn/column/6968784078325678117

DataBinding实现原理探析
https://juejin.cn/post/6844903494831308814

MVVM之DataBinding入门
https://www.jianshu.com/p/dd247d6a562d



# 原理
layout会根据<layout/>表现，重新编译成另外一个特殊的layout
例如一个layout的名称是activity_test1.xml,则编译之后变成activity_test1-layout.xml
位于\build\intermediates\data_binding_layout_info_type_merge\debug\目录下
然后会添加上一个tag,根布局会添加tag="layout/activity_test1_0"


开始
DataBindingUtil.setContentView(this, R.layout.activity_test1);
最后会调用到
DataBindingUtil的下面方法
static <T extends ViewDataBinding> T bind(DataBindingComponent bindingComponent, View root,
int layoutId) {
    return (T) sMapper.getDataBinder(bindingComponent, root, layoutId);
}
接着调用DataBinderMapper
public abstract ViewDataBinding getDataBinder(DataBindingComponent bindingComponent,
View[] view, int layoutId);
实现类是这个：DataBinderMapperImpl第58行 位于build/generated/ap_generated_sources/debug/out/com/databinding/目录下
@Override
public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
}
在这个方法里面，会根据条件实例化一个ActivityTest1BindingImpl的对象，ActivityTest1BindingImpl的父类是
ActivityTest1Binding，位于目录\build\generated\data_binding_base_class_source_out\debug\out\com\example\databinding\databinding下

VM与V交互
当调用下面的代码时
mBinding.setVariable(BR.viewModel, viewModel);
最终会调用到ActivityTest1BindingImpl的setVariable()方法，
setVariable(int variableId, @Nullable Object variable)
然后会调用到setViewModel()方法
public void setViewModel(@Nullable com.example.databinding.test1.NewsViewModel ViewModel) {
    updateRegistration(0, ViewModel);
    this.mViewModel = ViewModel;
    synchronized(this) {
        mDirtyFlags |= 0x1L;
    }
    notifyPropertyChanged(BR.viewModel);
    super.requestRebind();
}
先看updateRegistration(0, ViewModel)方法，这个方法最终会调到下面的方法：
updateRegistration(localFieldId, observable, CREATE_PROPERTY_LISTENER)
CREATE_PROPERTY_LISTENER是CreateWeakListener类型的静态变量，调用create()方法会返回WeakPropertyListener类型的实例。
private static final CreateWeakListener CREATE_PROPERTY_LISTENER = new CreateWeakListener() {
    @Override
    public WeakListener create(
        ViewDataBinding viewDataBinding,
        int localFieldId,
        ReferenceQueue<ViewDataBinding> referenceQueue
        ) {
            return new WeakPropertyListener(viewDataBinding, localFieldId, referenceQueue)
            .getListener();
    }
};
observable就是上面传入进来的ViewModel
然后会调用到ViewDataBinding的updateRegistration()方法
protected boolean updateRegistration(int localFieldId, Object observable,
    CreateWeakListener listenerCreator) {
    if (observable == null) {
        return unregisterFrom(localFieldId);
    }
    WeakListener listener = mLocalFieldObservers[localFieldId];
    if (listener == null) {
        registerTo(localFieldId, observable, listenerCreator);
        return true;
    }
    if (listener.getTarget() == observable) {
        return false;//nothing to do, same object
    }
    unregisterFrom(localFieldId);
    registerTo(localFieldId, observable, listenerCreator);
    return true;
}
registerTo就是注册监听器，unregisterFrom就是删除监听器。
主要处理三种情况 1.observable传进来为null，删除监听器 
2.mLocalFieldObservers[localFieldId]为空，也就是第一次注册，那么就注册监听器    
3.mLocalFieldObservers[localFieldId]不为空并且里面的监听器和传进来监听器不一致，先删除监听器，再重新注册新的监听器

接下来看看ViewDatabinding 的registerTo()方法
protected void registerTo(int localFieldId, Object observable,
    CreateWeakListener listenerCreator) {
    if (observable == null) {
        return;
    }
    WeakListener listener = mLocalFieldObservers[localFieldId];
    if (listener == null) {
        listener = listenerCreator.create(this, localFieldId, sReferenceQueue);
        mLocalFieldObservers[localFieldId] = listener;
        if (mLifecycleOwner != null) {
            listener.setLifecycleOwner(mLifecycleOwner);
        }
    }
    listener.setTarget(observable);
}
listenerCreator.create(this, localFieldId, sReferenceQueue);会调用CREATE_PROPERTY_LISTENER的create()方法
上面的代码最后会调用setTarget()设置observable
所以mLocalFieldObservers会以localFieldId为索引，保存一个WeakListener类型的实例，这个实例中保存了ViewDataBinding的引用，
也持有VM的引用，还持有WeakPropertyListener的引用。
WeakPropertyListener是ViewDataBinding的一个静态内部类，会在调用updateRegistration()方法的时候，第三个参数
CREATE_PROPERTY_LISTENER会实例化要一个WeakPropertyListener，然后通过这个实例获取WeakListener，这个WeakListener
会保存WeakPropertyListener的引用。
registerTo最后调用了listener.setTarget(observable)方法， 这个方法就是调用WeakPropertyListener 的addListener方法， 
也就是调用VM的addOnPropertyChangedCallback(this)，我们看看VM的父类BaseObservable的addOnPropertyChangedCallback方法
@Override
public void addOnPropertyChangedCallback(@NonNull OnPropertyChangedCallback callback) {
    synchronized (this) {
        if (mCallbacks == null) {
            mCallbacks = new PropertyChangeRegistry();
        }
    }
    mCallbacks.add(callback);
}
这样BaseObservable的mCallbacks就持有了ViewBinding内部类WeakPropertyListener的引用。

ViewDatabinding 的unregisterFrom()方法
protected boolean unregisterFrom(int localFieldId) {
    WeakListener listener = mLocalFieldObservers[localFieldId];
    if (listener != null) {
        return listener.unregister();
    }
    return false;
}

listener.unregister()会调用WeakLister中的unregister()方法
public boolean unregister() {
    boolean unregistered = false;
    if (mTarget != null) {
        mObservable.removeListener(mTarget);
        unregistered = true;
    }
    mTarget = null;
    return unregistered;
}
mObservable.removeListener(mTarget);会调用到WeakPropertyListener的removeListener()方法
然后调用到BaseObservable中的removeOnPropertyChangedCallback()方法
@Override
public void removeOnPropertyChangedCallback(@NonNull OnPropertyChangedCallback callback) {
    synchronized (this) {
        if (mCallbacks == null) {
            return;
        }
    }
    mCallbacks.remove(callback);
}

vm通知view更新
当调用下面代码时：
mBinding.setVariable(BR.viewModel, viewModel);
会最终调用到ActivityTest1BindingImpl中第79行的setViewModel()方法，最后调用下面的方法
super.requestRebind();
经过下面的调用流程，最终调用到ActivityTest1BindingImpl的ecuteBindings()方法。
ViewDataBinding -> mChoreographer.postFrameCallback(mFrameCallback); 627
ViewDataBinding -> mRebindRunnable.run(); 320
ViewDataBinding -> executePendingBindings(); 218
ViewDataBinding -> executeBindingsInternal(); 484
ViewDataBinding -> ecuteBindings(); 512
ActivityTest1BindingImpl -> ecuteBindings(); 120

在上面的步骤中，ActivityTest1BindingImpl中的setViewModel()方法会设置mDirtyFlags的值
mDirtyFlags |= 0x1L;
在executeBindings()方法中，会缓存这个mDirtyFlags的值，并把mDirtyFlags重新设置成0










































