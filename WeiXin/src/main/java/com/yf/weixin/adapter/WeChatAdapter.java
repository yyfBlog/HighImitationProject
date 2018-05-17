package com.yf.weixin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yf.weixin.R;

import java.util.List;

/**
 * Created by yyf on 2018/5/16.
 * Function:
 */

public class WeChatAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List mList;

    public WeChatAdapter(Context mContext,List mList){
        this.mContext=mContext;
        this.mList=mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_we_chat,parent,false);
        return new WeChatHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private static class WeChatHolder extends RecyclerView.ViewHolder{

        public WeChatHolder(View itemView) {
            super(itemView);
        }
    }
}
