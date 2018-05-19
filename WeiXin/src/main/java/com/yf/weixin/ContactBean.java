package com.yf.weixin;

import java.io.Serializable;

/**
 * Created by yyf on 2018/5/18.
 * Function:
 */

public class ContactBean implements Serializable {
    private String mName;
    private int mType;

    public ContactBean(String name, int type) {
        mName = name;
        mType = type;
    }

    public String getmName() {
        return mName;
    }

    public int getmType() {
        return mType;
    }
}
