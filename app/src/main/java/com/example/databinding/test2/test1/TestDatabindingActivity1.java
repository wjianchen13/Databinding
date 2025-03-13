package com.example.databinding.test2.test1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding1Binding;

/**
 * 单向绑定
 */
public class TestDatabindingActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestDatabinding1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding1);
        Student student = new Student("xiaweizi", 12);
        binding.setStudent(student);
    }

}
