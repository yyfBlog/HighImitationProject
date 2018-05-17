package com.yf.run.baselibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yyf on 2018/5/9.
 * Function:
 */

public abstract class BaseFragment extends Fragment {
    public abstract int layoutId();
    public abstract void initView(View view,Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(layoutId(),container,false);
        initView(view,savedInstanceState);
        return view;
    }
}
