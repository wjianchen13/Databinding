package com.example.databinding.dialogfragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.DialogBottomFullBinding;


/**
 * Created by Administrator on 2019/3/27 0011.
 *
 */
public abstract class BaseBottomFullDialogFragment extends BaseDialogFragment implements View.OnClickListener{

    protected View mView = null;
    private RelativeLayout llytFrame;
    private LinearLayout llytContent;

    public abstract void initView(LinearLayout parent);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedEInstanceState) {
//        mView = inflater.inflate(R.layout.dialog_bottom_full, container, false);
         DialogBottomFullBinding binding = DataBindingUtil.inflate(inflater, R.layout.dialog_bottom_full, container, false);
        return mView = binding.getRoot();
    }

    public void initView() {
        if(mView == null)
            return ;
        llytFrame = mView.findViewById(R.id.llyt_bottom_full);
        llytFrame.setOnClickListener(this);
        llytContent = mView.findViewById(R.id.llyt_bottom_content);
        llytContent.setOnClickListener(this);
        boolean cancelable = isCanceledOnTouchOutside();
        if (cancelable) {
            llytFrame.setEnabled(true);
            llytFrame.setOnClickListener(this);
        } else {
            llytFrame.setEnabled(false);
            llytFrame.setOnClickListener(null);
        }

        if(llytContent instanceof LinearLayout) {
            initView(llytContent);
        }
    }

    protected boolean isCanceledOnTouchOutside() {
        return true;
    }

    protected float getDimAmount() {
        return 0.5f;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.dimAmount = getDimAmount();
            params.windowAnimations = R.style.DownDialogStyle;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            // 使用MATCH_PARENT弹出后会导致状态栏字体变色，但使用确定的值不会
            // 使用WRAP_CONTENT主要是适配VIVO，因为VIVO没有开启全面屏，和屏幕高度一样会导致对话框下移，
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setGravity(Gravity.BOTTOM);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setAttributes(params);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.llyt_bottom_full){
            dismiss();
        }
    }

}
