package com.example.databinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.databinding.ActivityVariableBinding;

public class VariableActivity extends AppCompatActivity {

    Student mStudent = new Student("guo","chengqian");
    private ActivityVariableBinding mBinding;
    Boolean visiblity = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_variable);
        //绑定变量
        mBinding.setStudent(mStudent);
        mBinding.setPresenter(new Presenter());
        mBinding.setVisibility(visiblity);
    }


    //事件绑定 方法类
    public class Presenter{
        public void onTextChanged(CharSequence s, int start, int before, int count){
            mStudent.setFirstName(s.toString());
            //如果已经为该类继承了BaseObservable 就不需要再赋值了；
            //mBinding.setStudent(mStudent);
        }

        public void onClick(View view){
            Toast.makeText(VariableActivity.this,"onClick!", Toast.LENGTH_SHORT).show();
            visiblity = !visiblity;
            mBinding.setVisibility(visiblity);
            //mBinding.viewStub.getBinding().setVariable(BR.visibility,!visibility);
        }

        public void onClickListenerBinding(Student student){
            Toast.makeText(VariableActivity.this, student.getLastName(), Toast.LENGTH_SHORT).show();
        }
    }
}
