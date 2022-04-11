package com.example.databinding.dialogfragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

/**
 * Created by Administrator on 2017/7/11 0011.
 * 原来直播间相关的，保持
 */
public abstract class BaseDialogFragment extends CommonDialogFragment {

    public abstract void initView();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
//        hideNavgationBar();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams params = window.getAttributes();

            int[] sp = getScreenParams(getActivity());
            if(sp != null && sp.length >= 2) {
                params.width = sp[0];
                params.height = sp[1]/* - ScreenUtils.getStatusBarHeight(getActivity())*/;
            } else {
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.MATCH_PARENT;
            }
            window.setAttributes(params);
        }
    }

//    protected void hideNavgationBar (){
//        if(getContext() instanceof LiveActivity)
//            ApplicationUtil.hideNavgationBar(this);
//    }

    public static int[] getScreenParams(Activity activity) {
        int[] params = new int[2];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(dm);
            params[0] = dm.widthPixels;
            params[1] = dm.heightPixels;
        } else {
            DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
            params[0] = metrics.widthPixels;
            params[1] = metrics.heightPixels;
        }
        return params;
    }

}
