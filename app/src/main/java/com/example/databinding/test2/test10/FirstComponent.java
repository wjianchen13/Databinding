package com.example.databinding.test2.test10;

import androidx.databinding.DataBindingComponent;

/**
 * 需要注释掉BindingUtils8
 * @BindingAdapter ("android:text")方法
 * 否则会报错：
 * 方法不会覆盖或实现超类型的方法
 * 这个类需要注释掉，否则点其他页面全部都会报错：
 * java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.databinding/com.example.databinding.test2.test7.TestDatabindingActivity7}: java.lang.IllegalStateException: Required DataBindingComponent is null in class ViewIncludeTest7BindingImpl. A BindingAdapter in com.example.databinding.test2.test10.AbstractAdapter is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static
 */
//public class FirstComponent implements DataBindingComponent {
//    @Override
//    public AbstractAdapter getAbstractAdapter() {
//        return new FirstAdapter();
//    }
//}
public class FirstComponent {

}