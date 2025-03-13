package com.example.databinding.test2.test8;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

/**
 * 当xml文件中同时使用res和那么属性时
 *         <ImageView
 *             android:layout_width="100dp"
 *             android:layout_height="100dp"
 *             bind:res="@{student.image}"
 *             bind:name="@{student.name}"/>
 * 调用的是下面的方法：
 *     @BindingAdapter({"res", "name"})
 *
 * 当xml使用单个属性时，
 *         <ImageView
 *             android:layout_width="100dp"
 *             android:layout_height="100dp"
 *             bind:res="@{student.image}"/>
 *  调用的是下面的方法
 *  @BindingAdapter({"res"})
 */
public class BindingUtils8 {

//    @BindingAdapter({"res"})
//    public static void loadImageView(ImageView view, int res) {
//        if(view != null) {
//            view.setImageResource(res);
//        }
//    }

//    @BindingAdapter(value = {"res", "name"}, requireAll = true)
//    public static void loadImageView(ImageView view, int res, String name) {
//        if(view != null) {
//            view.setImageResource(res);
//        }
//    }

    @BindingAdapter({"res", "name"})
    public static void loadImageView(ImageView view, int res, String name) {
        if(view != null) {
            view.setImageResource(res);
        }
    }

//    @BindingAdapter(value = {"imageUrl", "placeDrawableId", "errorDrawableId"}, requireAll = true)//requireAll表示所有参数都必须有
//    public static void setImageUrl(ImageView imageView, String imageUrl, int placeDrawableId, int errorDrawableId) {
//
//    }

//    @BindingAdapter ("android:text")
//    public static void setText(TextView view, String text) {
//        view.setText(text + " 添加");
//    }

}
