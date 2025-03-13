package com.example.databinding.test2.test11;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityTestDatabinding11Binding;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView使用
 */
public class TestDatabindingActivity11 extends AppCompatActivity {

    private ActivityTestDatabinding11Binding binding;
    private RecyclerView rvTest;
    private List<Person> datas = new ArrayList<>();
    private MyAdapter adapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding11);
        initData();
        initVertical();
    }

    private void initData() {
        for(int i = 0; i < 30; i ++) {
            datas.add(new Person("姓名: " + i, i));
        }
    }

    public void initVertical(){
        rvTest = binding.rvTest;
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTest.setLayoutManager(mLayoutManager);
        adapter = new MyAdapter(datas);
        rvTest.setAdapter(adapter);

    }

}
