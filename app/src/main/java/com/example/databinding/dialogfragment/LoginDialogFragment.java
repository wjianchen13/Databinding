package com.example.databinding.dialogfragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.ViewLoginBar2Binding;

public class LoginDialogFragment extends BaseBottomFullDialogFragment implements View.OnClickListener{

    public static final String PARAMS_IS_CANCELABLE = "is_canceled_on_touch_out_side";
    public static final String PARAMS_TITLE = "title";
    public static final String PARAMS_DIM_AMOUNT = "dim_amount";

    Activity mActivity;

    private RelativeLayout rlLogin;

    /**
     * qq登录
     */
    private TextView mqqLoginView;

    /**
     * facebook登录
     */
    private TextView rl_facebookLogin;

    /**
     * 账户密码登录
     */
    private TextView mAccountLoginView;

    LoginListener mListener;

    private View view = null;

    boolean isCanceledOnTouchOutside;

    float dimAoumt;

    /**
     * 初始化界面
     * @param
     * @return
     */
    @Override
    public void initView(LinearLayout parent) {
//        view = LayoutInflater.from(mContext).inflate(R.layout.view_login_bar_2, null);
        ViewLoginBar2Binding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.view_login_bar_2, parent, true);
        view = binding.getRoot();
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);
//        parent.addView(view, params);
        mActivity = getActivityV2();
        rlLogin = view.findViewById(R.id.rl_login);
        mqqLoginView = view.findViewById(R.id.rl_qqLogin);
        rl_facebookLogin = view.findViewById(R.id.rl_facebookLogin);
        mAccountLoginView = view.findViewById(R.id.ll_accountLogin);
        mqqLoginView.setVisibility(View.VISIBLE);
        rl_facebookLogin.setVisibility(View.GONE);
        mAccountLoginView.setVisibility(View.VISIBLE);
        rlLogin.setOnClickListener(this);
        mqqLoginView.setOnClickListener(this);
        mAccountLoginView.setOnClickListener(this);
        rl_facebookLogin.setOnClickListener(this);
    }

    @Override
    protected boolean isCanceledOnTouchOutside() {
        return true;
    }

    @Override
    protected float getDimAmount() {
        return 0.5f;
    }

    public void setListener(LoginListener listener){
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.rl_qqLogin) {
            onQQLoginClick(v);
            handleClickLogin(v);
        } else if (i == R.id.rl_facebookLogin) {
            onFacebookLoginClick(v);
            handleClickLogin(v);
        } else if (i == R.id.ll_accountLogin) {
            onAccountLoginClick(v);
            handleClickLogin(v);
        }
    }

    private void handleClickLogin(View v) {
        if(mListener != null)
            mListener.onClick(v);
        dismiss();
    }

    /**
     * QQ登录
     * @param:
     * @return:void
     */
    public void onQQLoginClick(View v) {

    }

    /**
     * facebook登录
     * @param v
     */
    public void onFacebookLoginClick(View v) {
        onQQLoginClick(v);
    }

    /**
     * 账户登录
     * @param:
     * @return:void
     */
    public void onAccountLoginClick(View v) {

    }

    public interface LoginListener{
        void onClick(View v);
    }

}
