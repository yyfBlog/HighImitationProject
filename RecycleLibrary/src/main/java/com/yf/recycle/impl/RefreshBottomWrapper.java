package com.yf.recycle.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.yf.recycle.api.RefreshFooter;
import com.yf.recycle.api.RefreshKernel;
import com.yf.recycle.api.RefreshLayout;
import com.yf.recycle.constant.RefreshState;
import com.yf.recycle.constant.SpinnerStyle;


/**
 * 刷新底部包装
 * Created by SCWANG on 2017/5/26.
 */

public class RefreshBottomWrapper implements RefreshFooter {
    private View mWrapperView;
    private SpinnerStyle mSpinnerStyle;

    public RefreshBottomWrapper(View wrapper) {
        this.mWrapperView = wrapper;
    }

    @NonNull
    public View getView() {
        return mWrapperView;
    }

    @Override
    public void onFinish(RefreshLayout layout) {

    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        if (mSpinnerStyle != null) {
            return mSpinnerStyle;
        }
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params != null) {
            if (params.height == 0) {
                return mSpinnerStyle = SpinnerStyle.Scale;
            }
        }
        return mSpinnerStyle = SpinnerStyle.Translate;
    }

    @Override
    public void onInitialized(RefreshKernel layout, int height, int extendHeight) {

    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }
}
