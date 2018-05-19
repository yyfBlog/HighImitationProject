package com.yf.weixin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yf.weixin.ContactBean;
import com.yf.weixin.R;
import com.yf.weixin.widget.ContactComparator;
import com.yf.weixin.widget.PinyinUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yyf on 2018/5/17.
 * Function:
 */

public class MailListAdapter extends RecyclerView.Adapter {
    private List<ContactBean> mList;
    private Context mContext;


    public enum ITEM_TYPE {
        ITEM_TYPE_CHARACTER,
        ITEM_TYPE_CONTACT
    }

    public MailListAdapter(Context mContext, List<ContactBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_CHARACTER.ordinal()) {
            View mView=LayoutInflater.from(mContext).inflate(R.layout.item_mail_list_title,parent,false);
            return new TitleHolder(mView);
        }
        View mView = LayoutInflater.from(mContext).inflate(R.layout.item_mail_list, parent, false);
        return new MailListHolder(mView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MailListHolder) {
            MailListHolder mHolder = (MailListHolder) holder;
            ContactBean bean = mList.get(position);
            mHolder.tvUserName.setText(bean.getmName());
        }else if (holder instanceof TitleHolder){
            TitleHolder mHolder= (TitleHolder) holder;
            mHolder.tvTitle.setText(mList.get(position).getmName());
        }
    }




    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MailListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_userName)
        TextView tvUserName;

        public MailListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getmType();
    }


    public class TitleHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_title)
        TextView tvTitle;
        public TitleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
