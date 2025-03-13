package com.example.databinding.test2.test10;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.databinding.BR;

public class Student10 extends BaseObservable {

    // 如果是 public 则在成员变量上方加上 @Bindable 注解
    @Bindable
    public String sex;

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    /*************************** 我是分割线 ***************************/
    // 如果是 private 则在成员变量的 get 方法中添加 @Bindable 注解
    private String name;
    @Bindable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setSexName(String name, String sex){
        this.name = name;
        this.sex = sex;
        notifyChange();
    }
}
