package com.example.databinding.test2.test4;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding3Binding;
import com.example.databinding.databinding.ActivityTestDatabinding4Binding;
import com.example.databinding.test2.test3.Student3;

/**
 * 事件处理
 */
public class TestDatabindingActivity4 extends AppCompatActivity {

    private Student4 mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestDatabinding4Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding4);
        mStudent = new Student4();
        binding.setStudent(mStudent);
        mStudent.name.set("事件处理");
        String name = mStudent.name.get();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onClickExample(View view) {
            Toast.makeText(TestDatabindingActivity4.this, "点到了", Toast.LENGTH_SHORT).show();
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mStudent.name.set(s.toString());
        }

        public void onClickListenerBinding(Student4 student) {
            Toast.makeText(TestDatabindingActivity4.this, student.name.get(),Toast.LENGTH_SHORT).show();
        }
    }

}
