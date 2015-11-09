package com.crushead.utils;

import android.content.Context;
import android.graphics.Typeface;

public class Letters {
	
	/** letter */
	public static Typeface ROBOTOLIGHT(Context ctx){
		Typeface ROBOTOLIGHT = Typeface.createFromAsset(ctx.getAssets(),"fonts/Roboto-Light.ttf");	
		return ROBOTOLIGHT;	
	}

	public static Typeface ROBOTOREGULAR(Context ctx){
		Typeface ROBOTOREGULAR = Typeface.createFromAsset(ctx.getAssets(),"fonts/Roboto-Regular.ttf");	
		return ROBOTOREGULAR;	
	}	
	
	
}//end class
