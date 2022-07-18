package com.example.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.databinding.viewmodel.ViewModelActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBase(View v) {
        Intent it = new Intent();
        it.setClass(this, BaseActivity.class);
        startActivity(it);
//        String a = "";
//        String b = null;
//        System.out.println("a == null: " + (a == null));
//        System.out.println("b == null: " + (b == null));
//        System.out.println("a == b: " + (a == b));
//        System.out.println("equals(a): " + "".equals(a));
//        System.out.println("equals(b): " + "".equals(b));
    }

    public void onVariable(View v) {
        Intent it = new Intent();
        it.setClass(this, VariableActivity.class);
        startActivity(it);
    }

    public void onTag(View v) {
        Intent it = new Intent();
        it.setClass(this, TagActivity.class);
        startActivity(it);
    }

    public void onDialogFragment(View v) {
        Intent it = new Intent();
        it.setClass(this, DialogFragmentActivity.class);
        startActivity(it);
    }

    public void onViewModel(View v) {
        Intent it = new Intent();
        it.setClass(this, ViewModelActivity.class);
        startActivity(it);
    }

}
