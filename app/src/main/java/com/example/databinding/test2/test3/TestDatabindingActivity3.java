package com.example.databinding.test2.test3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding2Binding;
import com.example.databinding.databinding.ActivityTestDatabinding3Binding;
import com.example.databinding.test2.test2.Student2;

/**
 * 双向绑定
 * 双向绑定有2种方法
 * 第一种继承BaseObservable：
 * 第二种：使用ObservableField
 */
public class TestDatabindingActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestDatabinding3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding3);
        Student3 student = new Student3();
        binding.setStudent(student);
        student.name.set("双向绑定,使用ObservableField方式");
        String name = student.name.get();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

}
