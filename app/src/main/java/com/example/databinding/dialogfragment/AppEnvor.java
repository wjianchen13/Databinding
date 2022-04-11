package com.example.databinding.dialogfragment;

import android.text.TextUtils;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public class AppEnvor {

    public static boolean isShow() {
        return true;
    }
    public static boolean isShow2() {
        return true;
    }

    public static String fix(AppCompatActivity context, @StringRes int stringId) {
        String str = "你好";
        if(context != null) {
            str = context.getResources().getString(stringId);
        }
        return str;
    }

    public static String fix(String content) {
        try {
            // 暂时测试
            if(!TextUtils.isEmpty(content) && content.contains("秀币")) {
                return content.replace("秀币", "秀豆");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
