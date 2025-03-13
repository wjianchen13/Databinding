package com.example.databinding.test2.test9;

import android.graphics.drawable.ColorDrawable;

import androidx.databinding.BindingConversion;

/**
 * @BindingConversion 支持对数据的转换，或者是类型的转换
 */
public class BindingUtils9 {

    /**
     * 这个时候会将项目中所有以@{String}方式用到的String后缀全部加上xiaweizi
     * 这个会叠加BindingUtils8 @BindingAdapter ("android:text")的效果
     * @param text
     * @return
     */
    @BindingConversion
    public static String addString(String text){
        return text + "xiaweizi";
    }

    /**
     * 将int类型的color值，转换成了ColorDrawable类型
     * @param color
     * @return
     */
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color){
        return new ColorDrawable(color);
    }

}
