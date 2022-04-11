package com.example.databinding.dialogfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by Administrator on 2017/7/11 0011.
 *
 */
public abstract class CommonDialogFragment extends DobyDialogFragment {

    protected DialogInterface.OnCancelListener onCancelListener;

    protected SimpleDialogCallBackListener dialogClickListener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try{
            Context context = getDialog().getContext();
            int divierId = context.getResources().getIdentifier("android:id/titleDivider", null, null);
            if(divierId != 0) {
                View divider = getDialog().findViewById(divierId);
                if(divider != null)
                    divider.setBackgroundColor(Color.TRANSPARENT);
            }
        } catch (Exception e){
            //上面的代码，是用来去除Holo主题的蓝色线条
            e.printStackTrace();
        }
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            //在每个add事务前增加一个remove事务，防止连续的add
            manager.beginTransaction().remove(this).commit();
            super.show(manager, tag);
        } catch (Exception e) {
            //同一实例使用不同的tag会异常,这里捕获一下
            e.printStackTrace();
        }
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        try {
            return super.show(transaction, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if(onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener listener) {
        // TODO Auto-generated method stub
        this.onCancelListener = listener;
    }

    public void setDialogClickListener(SimpleDialogCallBackListener dialogClickListener) {
        this.dialogClickListener = dialogClickListener;
    }

    public static class SimpleDialogCallBackListener implements OnDialogCallBackListener {
        @Override
        public void onSureClick(View v) {

        }

        @Override
        public void onCancelClick(View v) {

        }

        @Override
        public void onFinishInitView() {

        }

        @Override
        public void onResult(boolean isSuccess) {

        }

        @Override
        public void onResult(boolean isSuccess, String msg) {

        }
    }

    public interface OnDialogCallBackListener{
        void onSureClick(View v);
        void onCancelClick(View v);
        void onFinishInitView();
        void onResult(boolean isSuccess);
        void onResult(boolean isSuccess, String msg);
    }

}
