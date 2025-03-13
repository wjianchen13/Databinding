package com.example.databinding.test2.test4;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class Student4 extends BaseObservable {

    public ObservableField<String> name = new ObservableField<>();

    private ObservableInt age = new ObservableInt();
    public void setAge(int age) {
        this.age.set(age);
    }
    public int getAge() {
        return age.get();
    }
}
