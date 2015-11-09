package com.crushead;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.crushead.dialog.DifficultyDialog;
import com.crushead.fragment.FragmentListCategory;
import com.crushead.utils.Constant;
import com.crushead.utils.Preference;

public class Category extends FragmentActivity implements FragmentListCategory.Callbacks{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
		getActionBar().setTitle("Categoria");		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		switch (id) {
		case R.id.action_resultados:
			Intent intent1 = new Intent(this, Resultados.class);
			startActivity(intent1);	
	        reproducirSonido(R.raw.pagination, this);		
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);			
			break;		
		case R.id.action_settings:
			Intent intent = new Intent(this, Container.class);
			intent.putExtra(Constant.ID_SELECT_FRAGMENT, Constant.FRAGMENT_SETTING);
			startActivity(intent);	
	        reproducirSonido(R.raw.pagination, this);		
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);			
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(String id) {
		// TODO Auto-generated method stub
		if(id == Constant.ANIMALES){	
			getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.indigo));
			Preference.putInt("CATEGORIA", 1, this);
			new DifficultyDialog(this).show();					
		}else{
			if(id == Constant.FRUTAS){					
				getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.light_green));
				Preference.putInt("CATEGORIA", 2, this);
				new DifficultyDialog(this).show();						
			}else{
				if(id == Constant.FIGURAS){							
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.pink));
					Preference.putInt("CATEGORIA", 3, this);							
					new DifficultyDialog(this).show();						
				}else{
					if(id == Constant.ARTICULOS){
						getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.purple));
						Preference.putInt("CATEGORIA", 4, this);								
						new DifficultyDialog(this).show();							
					}else{
						if(id == Constant.PAISES){
							getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.cyan));
							Preference.putInt("CATEGORIA", 5, this);								
							new DifficultyDialog(this).show();								
						}
					}						
				}
			}
		}
	}

    public static void reproducirSonido(int idSonido, Activity activity) {
        Boolean sonidoActivo;
        try {
            sonidoActivo = Preference.getBoolean(Constant.KEY_SONIDO, activity);
        } catch (Exception e) {
            Log.e("PreferenceManager",e.toString());
            Preference.putBoolean(Constant.KEY_SONIDO,true,activity);
            sonidoActivo = true;
        }

        if( !sonidoActivo ) {
            try {
                MediaPlayer mediaPlayer = MediaPlayer.create(activity.getApplicationContext(), idSonido);
                mediaPlayer.start();
            } catch (Exception e) {}
        }
    }
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
		getActionBar().setTitle(getResources().getString(R.string.title_activity_category));
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
		getActionBar().setTitle(getResources().getString(R.string.title_activity_category));		
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
		getActionBar().setTitle(getResources().getString(R.string.title_activity_category));		
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = MotionEventCompat.getActionMasked(event);	
		switch (action) {
		case (MotionEvent.ACTION_DOWN):
			getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
			getActionBar().setTitle("Categoria");				
			break;
		case (MotionEvent.ACTION_MOVE):
			getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
			getActionBar().setTitle("Categoria");				
			break;
		case (MotionEvent.ACTION_UP):
			getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
			getActionBar().setTitle("Categoria");			
			break;
		case (MotionEvent.ACTION_CANCEL):
			getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
			getActionBar().setTitle("Categoria");				
			break;
		case (MotionEvent.ACTION_OUTSIDE):
			getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
			getActionBar().setTitle("Categoria");				
			break;				
		default:
			break;
		}
		return super.onTouchEvent(event);
	}
	
}//end class
