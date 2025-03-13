package com.example.databinding.test2.test7;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding6Binding;
import com.example.databinding.databinding.ActivityTestDatabinding7Binding;
import com.example.databinding.test2.test6.Student6;

/**
 * include
 */
public class TestDatabindingActivity7 extends AppCompatActivity {

    private Student7 mStudent;
    private ActivityTestDatabinding7Binding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding7);
        mStudent = new Student7();
        mStudent.setName("include Test");

        mStudent.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TestDatabindingActivity7.this, "onPropertyChanged name: " + mStudent.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onTest(View v) {
        binding.setStudent(mStudent);
    }

    /**
     * 改变现实内容
     */
    public void onTest1(View v) {
        mStudent.setName("new Test");
        binding.setStudent(mStudent);
    }

}
