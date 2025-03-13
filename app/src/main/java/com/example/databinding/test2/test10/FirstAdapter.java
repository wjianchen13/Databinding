package com.example.databinding.test2.test10;

import android.widget.TextView;

/**
 * 这里会和其他地方的@BindingAdapter效果一起叠加，需要注释掉其他地方的@BindingAdapter进行测试
 */
public class FirstAdapter extends AbstractAdapter{
    @Override
    public void setText(TextView textView, String text) {
        textView.setText(text+"first");
    }
}
