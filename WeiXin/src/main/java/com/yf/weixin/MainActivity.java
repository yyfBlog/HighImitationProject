package com.yf.weixin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yf.run.baselibrary.BaseActivity;
import com.yf.run.baselibrary.circulars.NumberTextView;
import com.yf.weixin.adapter.PagerAdapter;
import com.yf.weixin.fragments.FoundFragment;
import com.yf.weixin.fragments.MailListFragment;
import com.yf.weixin.fragments.MeFragment;
import com.yf.weixin.fragments.WeChatFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.iv_weChat)
    ImageView ivWeChat;
    @BindView(R.id.tv_weChat)
    TextView tvWeChat;
    @BindView(R.id.iv_mailList)
    ImageView ivMailList;
    @BindView(R.id.tv_mailList)
    TextView tvMilList;
    @BindView(R.id.iv_found)
    ImageView ivFound;
    @BindView(R.id.tv_found)
    TextView tvFound;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.fl_weChat)
    FrameLayout flWeChat;
    @BindView(R.id.fl_mailList)
    FrameLayout flMailList;
    @BindView(R.id.fl_found)
    FrameLayout flFound;
    @BindView(R.id.fl_me)
    FrameLayout flMe;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private int colors[] = {R.color.c_8c8c8c, R.color.c_09bb07};
    private int icons[] = {R.mipmap.ic_wechat, R.mipmap.ic_wechat_click,
            R.mipmap.ic_mail_list, R.mipmap.ic_mail_list_click,
            R.mipmap.ic_found, R.mipmap.ic_found_click,
            R.mipmap.ic_me, R.mipmap.ic_me_click};
    private List<Fragment> mList;
    private List<FrameLayout> mViews;

    @Override
    public void initView(View view) {
        ButterKnife.bind(this);
        mList = new ArrayList<Fragment>();
        mList.add(new WeChatFragment());
        mList.add(new MailListFragment());
        mList.add(new FoundFragment());
        mList.add(new MeFragment());

        mViews = new ArrayList<>();
        mViews.add(flWeChat);
        mViews.add(flMailList);
        mViews.add(flFound);
        mViews.add(flMe);

        checkItem(0);
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), mList));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: ");
                checkItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void checkItem(int index) {
        if (index > mList.size()) {
            return;
        }
        for (int i = 0; i < mList.size(); i++) {
            FrameLayout rootView = mViews.get(i);
            for (int j = 0; j < rootView.getChildCount(); j++) {
                if (rootView.getChildAt(j) instanceof LinearLayout) {
                    LinearLayout childView = (LinearLayout) rootView.getChildAt(j);
                    for (int k = 0; k < childView.getChildCount(); k++) {
                        if (childView.getChildAt(k) instanceof ImageView) {
                            ImageView mTargetImageView = (ImageView) childView.getChildAt(k);
                            if (index==i){
                                mTargetImageView.setImageResource(icons[index * 2 + 1]);
                            }else {
                                mTargetImageView.setImageResource(icons[i * 2]);
                            }
                        }
                        if (childView.getChildAt(k) instanceof TextView) {
                            TextView mTargetTextView = (TextView) childView.getChildAt(k);
                            if (index==i){
                                mTargetTextView.setTextColor(getResources().getColor(colors[1]));
                            }else {
                                mTargetTextView.setTextColor(getResources().getColor(colors[0]));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.fl_weChat)
    void clickWeChat() {
        mViewPager.setCurrentItem(0);
    }

    @OnClick(R.id.fl_mailList)
    void clickMail() {
        mViewPager.setCurrentItem(1);
    }

    @OnClick(R.id.fl_found)
    void clickFound() {
        mViewPager.setCurrentItem(2);
    }

    @OnClick(R.id.fl_me)
    void clickMe() {
        mViewPager.setCurrentItem(3);
    }
}
