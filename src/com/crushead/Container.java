package com.crushead;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.crushead.fragment.FragmentSettings;
import com.crushead.utils.Constant;
import com.crushead.utils.Preference;

public class Container extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.container);
				
		getActionBar().setDisplayHomeAsUpEnabled(true);//show up
		
		if (savedInstanceState == null) {	
			if(getIntent().getExtras() != null){
				if(getIntent().getExtras().getInt(Constant.ID_SELECT_FRAGMENT) == Constant.FRAGMENT_SETTING){
					FragmentSettings fragment = new FragmentSettings();
					getFragmentManager().beginTransaction().add(R.id.container_fragment, fragment).commit();
					getActionBar().setTitle("Configuración");	
					getActionBar().setIcon(R.drawable.ic_settings_white_48dp);
				}
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
        reproducirSonido(R.raw.pagination, this);		
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
		finish();
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            reproducirSonido(R.raw.pagination, this);			        	
	            finish();
	            overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
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
}//end class
