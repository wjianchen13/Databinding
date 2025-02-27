package com.example.databinding.test1;

import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.example.databinding.BR;

public class NewsViewModel extends BaseObservable {
    private String name;
    private String value1;

    public void setName(String name) {
        this.name = name;
        //提示该属性刷新了
        notifyPropertyChanged(BR.name);
        //提示所有的属性都刷新
        //notifyAll();
    }

    //注解来提示Binding生成这个字段
    @Bindable
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
        notifyPropertyChanged(BR.value1);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public NewsViewModel(String name, String value1) {
        this.name = name;
        this.value1 = value1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", value1='" + value1 + '}';
    }

    @BindingAdapter({"onText"})
    public static void onText(TextView tv, String str) {
        tv.setText(str);
    }
}