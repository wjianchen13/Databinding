package com.example.databinding.viewmodel;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTagBinding;
import com.example.databinding.databinding.ActivityViewModelBinding;

/**
 * ViewModel数据改变，UI也改变
 * 注意：DataBinding需调用setLifecycleOwner(LifecycleOwner lifecycleOwner)之后，绑定了LiveData数据源的xml控件才会随着数据变化而改变。
 */
public class ViewModelActivity extends AppCompatActivity {

    private DataViewModel vm;
    private ActivityViewModelBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_model);
        mBinding.setLifecycleOwner(this);
        vm = new ViewModelProvider(this).get(DataViewModel.class);
        mBinding.setViewModel(vm);
    }

    int i = 0;
    public void onTest(View v) {
        vm.pageIdx.postValue(++i);
    }

}
