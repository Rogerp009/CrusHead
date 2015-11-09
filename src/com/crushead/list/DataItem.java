package com.crushead.list;

import android.graphics.drawable.Drawable;

public class DataItem {

    private String label;
    private Drawable drawable;
    private int navigationInfo;
    public String id;
    
    public DataItem(String label, Drawable drawable, int navigationInfo, String id) {
        this.label = label;
        this.drawable = drawable;
        this.navigationInfo = navigationInfo;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public int getNavigationInfo() {
        return navigationInfo;
    }
    
    public String getId() {
        return id;
    }    
}
