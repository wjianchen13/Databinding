package com.example.databinding.test2.test10;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding10Binding;
import com.example.databinding.databinding.ActivityTestDatabinding9Binding;
import com.example.databinding.test2.test9.Student9;

/**
 * DataBindingComponent
 */
public class TestDatabindingActivity10 extends AppCompatActivity {

    private Student10 mStudent;
    private ActivityTestDatabinding10Binding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding10/*, new FirstComponent()*/);
//        DataBindingUtil.setDefaultComponent(new FirstComponent());
        mStudent = new Student10();
        mStudent.setName("BindingAdapter Test");
        mStudent.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TestDatabindingActivity10.this, "onPropertyChanged name: " + mStudent.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onTest(View v) {
        binding.setStudent(mStudent);
    }

    /**
     * 测试覆盖原生的元素设置属性
     * @param v
     */
    public void onTest1(View v) {
        mStudent.setName("设置内容");
        binding.setStudent(mStudent);
    }

}
