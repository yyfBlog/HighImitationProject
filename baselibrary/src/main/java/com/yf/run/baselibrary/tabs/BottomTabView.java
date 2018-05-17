package com.yf.run.baselibrary.tabs;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yyf on 2018/5/9.
 * Function:底部选项卡
 */

public class BottomTabView extends LinearLayout {
    private Context mContext;
    public BottomTabView(Context context) {
        super(context);
    }

    public BottomTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void buildView(){
        int count=3;
        for (int i = 0; i <count ; i++) {
            TabItemView itemView=new TabItemView(mContext);
        }
    }


    /**
     * 构建底部的组件
     */
    private class TabItemView extends LinearLayout{
        private TextView textView;

        public TabItemView(Context context) {
            this(context,null);
        }

        public TabItemView(Context context, @Nullable AttributeSet attrs) {
            this(context, attrs,0);
        }

        public TabItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            setOrientation(LinearLayout.HORIZONTAL); //竖排
            textView=new TextView(context);
            textView.setGravity(17);
            addView(textView);
        }
    }
}
