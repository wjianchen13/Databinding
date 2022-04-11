package com.example.databinding.dialogfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * name: DobyDialogFragment
 * desc: extends DialogFragment
 * author:
 * date: 2018-4-8 11:00
 * remark:
 */
public class DobyDialogFragment extends DialogFragment {

    protected Activity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        if (isNotFocusable())
            setNotFocusable();
    }

    protected boolean isNotFocusable() {
        return true;
    }

    private void setNotFocusable() {
        getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

    @Override
    public void onStart() {
        try {
            super.onStart();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Nullable
    public Activity getmContext() {
        super.getContext();
        mContext = getActivity();
        return mContext;
    }

    protected Activity getActivityV2(){
        return getmContext();
    }

    /**
     * Fragment本身正在销毁视图，回收资源
     */
    @Override
    public void onDestroyView() {
        try {
            super.onDestroyView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (Exception e) {
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
    public void showNow(FragmentManager manager, String tag) {
        try {
            super.showNow(manager, tag);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onBackPressed() {
        if(isVisible()){
            dismiss();
            return true;
        }
        return false;
    }

}
