package com.crushead;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.crushead.utils.Constant;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
	    //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		goToMain();
	}

	private void goToMain() {//ir a login o account user
		// TODO Auto-generated method stub
		TimerTask task = new TimerTask() {//instances timer
			
			@Override
			public void run() {
				// TODO Auto-generated method stub				
				startActivity(new Intent(SplashScreen.this, Category.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));//call fragmentActivity				
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				finish();
				
			}//end run
		};//end TimerTask
				
		Timer timer = new Timer();//process 2 seconds		
		timer.schedule(task, Constant.SPLASH_SCREEN_DELAY);		
	}	
}//end class
