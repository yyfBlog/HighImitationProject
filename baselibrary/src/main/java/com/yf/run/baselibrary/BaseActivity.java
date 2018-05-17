package com.yf.run.baselibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Created by yyf on 2018/5/5.
 * Function: activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    public final String TAG=getClass().getName().toString();
    public abstract void initView(View view);
    public abstract int layoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=getLayoutInflater().inflate(layoutId(),null);
        setContentView(view);
        initView(view);
    }
}
