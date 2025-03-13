package com.example.databinding.test2.test5;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding5Binding;
import com.example.databinding.test2.test4.Student4;

/**
 * 数据监听方法
 * 必须使用@Bindable作为双向绑定为条件，当数据变化，便会出发onPropertyChanged方法
 */
public class TestDatabindingActivity5 extends AppCompatActivity {

    private Student5 mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestDatabinding5Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding5);
        mStudent = new Student5();
        binding.setStudent(mStudent);
        binding.setPresenter(new Presenter());

        mStudent.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TestDatabindingActivity5.this, "onPropertyChanged name: " + mStudent.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class Presenter {
        public void onClickExample(View view) {
            Toast.makeText(TestDatabindingActivity5.this, "点到了", Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(Student5 student) {
            Toast.makeText(TestDatabindingActivity5.this, student.getName(),Toast.LENGTH_SHORT).show();
        }
    }

}
