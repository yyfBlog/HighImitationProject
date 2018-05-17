package com.yf.weixin.fragments;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yf.recycle.SmartRefreshLayout;
import com.yf.run.baselibrary.BaseFragment;
import com.yf.weixin.R;
import com.yf.weixin.adapter.WeChatAdapter;
import com.yf.weixin.widget.RecycleLine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yyf on 2018/5/9.
 * Function: 聊天界面
 */

public class WeChatFragment extends BaseFragment {
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.recycleView)
    RecyclerView mRecyclerView;
    private WeChatAdapter mAdapter;
    private List mList;

    @Override
    public int layoutId() {
        return R.layout.fragment_we_chat;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        mList=new ArrayList();
        for (int i = 0; i < 5; i++) {
            mList.add(i);
        }
        mAdapter=new WeChatAdapter(getActivity(),mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new RecycleLine(getActivity(),RecycleLine.LINEAR_LAYOUT_ORIENTATION_HORIZONTAL));
//        mRecyclerView.addItemDecoration(new RecycleLine(getActivity(),RecycleLine.LINEAR_LAYOUT_ORIENTATION_VERTICAL));
    }
}
