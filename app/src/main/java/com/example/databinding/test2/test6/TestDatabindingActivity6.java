package com.example.databinding.test2.test6;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.ViewStub;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding6Binding;
import com.example.databinding.test2.test5.Student5;

/**
 * ViewStub
 */
public class TestDatabindingActivity6 extends AppCompatActivity {

    private Student6 mStudent;
    private ViewStub vsTest;
    private ActivityTestDatabinding6Binding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding6);
        vsTest = binding.viewStub.getViewStub();
        mStudent = new Student6();
        mStudent.setName("ViewStub Test");

        mStudent.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TestDatabindingActivity6.this, "onPropertyChanged name: " + mStudent.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onTest(View v) {
        vsTest.inflate();
        binding.setStudent(mStudent);
    }

}
