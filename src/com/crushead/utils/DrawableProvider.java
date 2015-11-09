package com.crushead.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import com.amulyakhare.textdrawable.TextDrawable;

public class DrawableProvider {

    public static final int SAMPLE_RECT = 1;
    private final Context mContext;

    public DrawableProvider(Context context) {
        mContext = context;
    }
    
    public TextDrawable getRect(String text, int color) {
        return TextDrawable.builder()
        		.beginConfig()
        		.useFont(Letters.ROBOTOREGULAR(mContext))        	
        		.endConfig()
                .buildRect(text, color);
    }    
    public int toPx(int dp) {
        Resources resources = mContext.getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }
}
