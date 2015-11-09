package com.crushead.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.crushead.R;

public class ClearDialog extends Dialog {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public ClearDialog(Context context) {
        super(context, R.style.CustomDialogStyle);
    }

    public ClearDialog(Context context, boolean cancelable) {
        super(context, R.style.CustomDialogStyle);
        this.setCancelable(cancelable);
    }
}//end class
