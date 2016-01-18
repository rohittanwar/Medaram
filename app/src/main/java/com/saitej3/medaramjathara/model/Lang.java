package com.saitej3.medaramjathara.model;

import android.widget.ImageView;

/**
 * Created by Rohts on 1/11/2016.
 */
public class Lang {
    public int mimg;
    public String mText2;

    public Lang(int img, String text2){
        mimg = img;
        mText2 = text2;
    }

    public int getimg() {
        return mimg;
    }

    public void setImg(int img) {
        this.mimg = img;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }
}