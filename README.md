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











































