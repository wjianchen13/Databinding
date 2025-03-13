package com.example.databinding.test2.test2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding1Binding;
import com.example.databinding.databinding.ActivityTestDatabinding2Binding;
import com.example.databinding.test2.test1.Student;

/**
 * 双向绑定
 * 双向绑定有2种方法
 * 第一种继承BaseObservable：
 * 第二种：使用ObservableField
 */
public class TestDatabindingActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestDatabinding2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding2);
        Student2 student = new Student2();
        binding.setStudent(student);
        student.setName("双向绑定,继承BaseObservable方式");
    }

}
