package com.example.databinding;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.databinding.ActivityDialogfragmentBinding;
import com.example.databinding.dialogfragment.LoginDialogFragment;

/**
 * 1. 在默认的布局文件的最外层嵌套一对标签
 * 2. 把xmlns:android="http://schemas.android.com/apk/res/android"
 *      xmlns:app="http://schemas.android.com/apk/res-auto"移到layout标签中
 * 3. 在对应的activity中使用DataBindingUtil类的setContentView()方法替 换原有的setContentView()方法
 */
public class DialogFragmentActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityDialogfragmentBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_dialogfragment);
        mBinding.setMtx(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_show) {
            LoginDialogFragment mWarningDialog = new LoginDialogFragment();
            mWarningDialog.show(getSupportFragmentManager(), "LoginDialogFragment");
        }
    }
}
