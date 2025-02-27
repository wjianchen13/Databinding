package com.example.databinding.test1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityBaseBinding;
import com.example.databinding.databinding.ActivityTest1Binding;

/**
 * DataBinding源码阅读
 * DataBinding实现原理探析
 * https://juejin.cn/post/6844903494831308814
 */
public class TestActivity1 extends AppCompatActivity {

    private ActivityTest1Binding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test1);
        NewsViewModel viewModel = new NewsViewModel("name1", "value1");
        mBinding.setVariable(BR.viewModel, viewModel);
    }



}
