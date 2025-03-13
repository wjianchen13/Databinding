package com.example.databinding.test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.databinding.R;
import com.example.databinding.test2.test1.TestDatabindingActivity1;
import com.example.databinding.test2.test10.TestDatabindingActivity10;
import com.example.databinding.test2.test11.TestDatabindingActivity11;
import com.example.databinding.test2.test2.TestDatabindingActivity2;
import com.example.databinding.test2.test3.TestDatabindingActivity3;
import com.example.databinding.test2.test4.TestDatabindingActivity4;
import com.example.databinding.test2.test5.TestDatabindingActivity5;
import com.example.databinding.test2.test6.TestDatabindingActivity6;
import com.example.databinding.test2.test7.TestDatabindingActivity7;
import com.example.databinding.test2.test8.TestDatabindingActivity8;
import com.example.databinding.test2.test9.TestDatabindingActivity9;

/**
 * DataBinding入门
 * https://www.jianshu.com/p/dd247d6a562d#2-viewstub%E5%92%8Cinclude
 */
public class TestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
    }

    /**
     * 单向绑定
     * @param v
     */
    public void onTest1(View v) {
        startActivity(new Intent(this, TestDatabindingActivity1.class));
    }

    /**
     * 双向绑定,继承BaseObservable方式
     */
    public void onTest2(View v) {
        startActivity(new Intent(this, TestDatabindingActivity2.class));
    }

    /**
     * 双向绑定,使用ObservableField
     */
    public void onTest3(View v) {
        startActivity(new Intent(this, TestDatabindingActivity3.class));
    }

    /**
     * 事件处理
     */
    public void onTest4(View v) {
        startActivity(new Intent(this, TestDatabindingActivity4.class));
    }

    /**
     * 数据监听方法
     */
    public void onTest5(View v) {
        startActivity(new Intent(this, TestDatabindingActivity5.class));
    }

    /**
     * ViewStub
     */
    public void onTest6(View v) {
        startActivity(new Intent(this, TestDatabindingActivity6.class));
    }

    /**
     * include
     */
    public void onTest7(View v) {
        startActivity(new Intent(this, TestDatabindingActivity7.class));
    }

    /**
     * BindingAdapter
     */
    public void onTest8(View v) {
        startActivity(new Intent(this, TestDatabindingActivity8.class));
    }

    /**
     * BindingConversion
     */
    public void onTest9(View v) {
        startActivity(new Intent(this, TestDatabindingActivity9.class));
    }

    /**
     * DataBindingComponent
     */
    public void onTest10(View v) {
        startActivity(new Intent(this, TestDatabindingActivity10.class));
    }

    /**
     * RecyclerView使用
     */
    public void onTest11(View v) {
        startActivity(new Intent(this, TestDatabindingActivity11.class));
    }




}
