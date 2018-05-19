package com.yf.weixin.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.yf.run.baselibrary.BaseFragment;
import com.yf.weixin.ContactBean;
import com.yf.weixin.R;
import com.yf.weixin.adapter.MailListAdapter;
import com.yf.weixin.widget.ContactComparator;
import com.yf.weixin.widget.PinyinUtils;
import com.yf.weixin.widget.RecycleLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yyf on 2018/5/9.
 * Function: 联系人界面
 */

public class MailListFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView mRecyclerView;
    private MailListAdapter mAdapter;
    private List mList;
    private List mContactList;
    private List<ContactBean> resultList;
    private List characterList;

    @Override
    public int layoutId() {
        return R.layout.fragment_mail_list;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this,view);

        mList = new ArrayList();
        mList.add("张某");
        mList.add("李某");
        mList.add("韩某");
        mList.add("左某");
        mList.add("汉某");
        mList.add("顾某");
        mList.add("焦某");
        mList.add("孔某");
        mList.add("商某");
        mList.add("沈某");
        mList.add("夏某");
        mList.add("赵四");
        mList.add("钱某");
        mList.add("孙丽");
        mList.add("李四");
        mList.add("吴三桂");
        mList.add("王某");
        mList.add("冯某");
        mList.add("陈某");
        mList.add("诸某");

        handleContact();
        mAdapter=new MailListAdapter(getActivity(),resultList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.addItemDecoration(new RecycleLine(getActivity(),RecycleLine.LINEAR_LAYOUT_ORIENTATION_HORIZONTAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void handleContact() {
        mContactList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < mList.size(); i++) {
            String pinyin = PinyinUtils.getPingYin(mList.get(i).toString());
            map.put(pinyin, mList.get(i).toString());
            mContactList.add(pinyin);
        }
        Collections.sort(mContactList, new ContactComparator());

        resultList = new ArrayList<>();
        characterList = new ArrayList<>();


        resultList.add(new ContactBean("新的朋友",MailListAdapter.ITEM_TYPE.ITEM_TYPE_CONTACT.ordinal()));
        resultList.add(new ContactBean("群聊",MailListAdapter.ITEM_TYPE.ITEM_TYPE_CONTACT.ordinal()));
        resultList.add(new ContactBean("标签",MailListAdapter.ITEM_TYPE.ITEM_TYPE_CONTACT.ordinal()));
        resultList.add(new ContactBean("公众号",MailListAdapter.ITEM_TYPE.ITEM_TYPE_CONTACT.ordinal()));


        for (int i = 0; i < mContactList.size(); i++) {
            String name = mContactList.get(i).toString();
            String character = (name.charAt(0) + "").toUpperCase(Locale.ENGLISH);
            if (!characterList.contains(character)) {
                if (character.hashCode() >= "A".hashCode() && character.hashCode() <= "Z".hashCode()) { // 是字母
                    characterList.add(character);
                    resultList.add(new ContactBean(character, MailListAdapter.ITEM_TYPE.ITEM_TYPE_CHARACTER.ordinal()));
                } else {
                    if (!characterList.contains("#")) {
                        characterList.add("#");
                        resultList.add(new ContactBean("#", MailListAdapter.ITEM_TYPE.ITEM_TYPE_CHARACTER.ordinal()));
                    }
                }
            }

            resultList.add(new ContactBean(map.get(name), MailListAdapter.ITEM_TYPE.ITEM_TYPE_CONTACT.ordinal()));
        }
    }
}
