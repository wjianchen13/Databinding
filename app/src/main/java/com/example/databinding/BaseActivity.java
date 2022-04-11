package com.example.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.databinding.ActivityBaseBinding;

/**
 * 1. 在默认的布局文件的最外层嵌套一对标签
 * 2. 把xmlns:android="http://schemas.android.com/apk/res/android"
 *      xmlns:app="http://schemas.android.com/apk/res-auto"移到layout标签中
 * 3. 在对应的activity中使用DataBindingUtil类的setContentView()方法替 换原有的setContentView()方法
 */
public class BaseActivity extends AppCompatActivity {

    private ActivityBaseBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        mBinding.textView.setText("DataBinding的基本使用");
    }



}
