package com.example.day3.P;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(indata());
        inpoll();
        inlast();
    }
    protected abstract int indata();
    protected abstract void inpoll();
    protected abstract void inlast();
}
