package com.example.databinding.test2.test10;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

/**
 * 这里会和其他地方的@BindingAdapter效果一起叠加，需要注释掉其他地方的@BindingAdapter进行测试
 */
public abstract class AbstractAdapter {
//    @BindingAdapter ("android:text")
    public abstract void setText(TextView textView, String text);
}
