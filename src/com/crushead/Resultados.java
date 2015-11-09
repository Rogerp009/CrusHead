package com.crushead;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crushead.utils.Constant;
import com.crushead.utils.Preference;
import com.crushead.utils.TypeFaceProvider;

public class Resultados extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados);
		getActionBar().setDisplayHomeAsUpEnabled(true);//show up	
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.resultado));
        int ganadasPet, perdidasPet, ganadasFirst, perdidasFirst, ganadasAdvanced, perdidasAdvanced;
        int porcentajePet, porcentajeFirst, porcentajeAdvance;
        String fontName = "Roboto-Regular.ttf";
        Typeface tf = TypeFaceProvider.getTypeFace(this,fontName);
        
        final TextView tv_pet = (TextView) findViewById(R.id.tv_pet_result);
        final TextView tv_first = (TextView) findViewById(R.id.tv_first_result);
        final TextView tv_advanced = (TextView) findViewById(R.id.tv_advanced_result);

        ((TextView)findViewById(R.id.tv_tittle_statistics)).setTypeface(tf);
        ((TextView)findViewById(R.id.tv_pet)).setTypeface(tf);
        ((TextView)findViewById(R.id.tv_first)).setTypeface(tf);
        ((TextView)findViewById(R.id.tv_advanced)).setTypeface(tf);
        tv_pet.setTypeface(tf);
        tv_first.setTypeface(tf);
        tv_advanced.setTypeface(tf);
        ((Button)findViewById(R.id.btn_delete_results)).setTypeface(tf);
        
        // OnClick para resetear los resultados
        ((Button)findViewById(R.id.btn_delete_results)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preference.putInt(Constant.KEY_PET+Constant.KEY_WON, 0, Resultados.this);
                Preference.putInt(Constant.KEY_PET+Constant.KEY_LOST, 0, Resultados.this);
                Preference.putInt(Constant.KEY_FIRST+Constant.KEY_WON, 0, Resultados.this);
                Preference.putInt(Constant.KEY_FIRST+Constant.KEY_LOST, 0, Resultados.this);
                Preference.putInt(Constant.KEY_ADVANCED+Constant.KEY_WON, 0, Resultados.this);
                Preference.putInt(Constant.KEY_ADVANCED + Constant.KEY_LOST, 0, Resultados.this);

                tv_pet.setText("Ganadas: "+0+"\nPerdidas: "+0);
                tv_first.setText("Ganadas: "+0+"\nPerdidas: "+0);
                tv_advanced.setText("Ganadas: "+0+"\nPerdidas: "+0);
            }
        });
        
        try { // Cogemos el numero de partidas ganadas del PET
            ganadasPet = Preference.getInt(Constant.KEY_PET+Constant.KEY_WON, this);
        } catch (Exception e) {
            ganadasPet = 0;
        }
        try { // Cogemos el numero de partidas perdidas del PET
            perdidasPet = Preference.getInt(Constant.KEY_PET+Constant.KEY_LOST, this);
        } catch (Exception e) {
           perdidasPet = 0;
        }

        try { // Cogemos el numero de partidas ganadas del FIRST
            ganadasFirst = Preference.getInt(Constant.KEY_FIRST+Constant.KEY_WON, this);
        } catch (Exception e) {
            ganadasFirst = 0;
        }
        try { // Cogemos el numero de partidas perdidas del FIRST
            perdidasFirst = Preference.getInt(Constant.KEY_FIRST+Constant.KEY_LOST, this);
        } catch (Exception e) {
            perdidasFirst = 0;
        }

        try { // Cogemos el numero de partidas ganadas del ADVANCED
            ganadasAdvanced = Preference.getInt(Constant.KEY_ADVANCED+Constant.KEY_WON, this);
        } catch (Exception e) {
            ganadasAdvanced = 0;
        }
        try { // Cogemos el numero de partidas perdidas del ADVANCED
            perdidasAdvanced = Preference.getInt(Constant.KEY_ADVANCED+Constant.KEY_LOST, this);
        } catch (Exception e) {
            perdidasAdvanced = 0;
        }

        try {
            porcentajePet = (int) (ganadasPet*100.0f / (ganadasPet + perdidasPet));
        } catch (Exception e) {
            porcentajePet = 0;
        }
        try {
            porcentajeFirst = (int) (ganadasFirst*100.0f / (ganadasFirst + perdidasFirst));
        } catch (Exception e) {
            porcentajeFirst = 0;
        }
        try {
            porcentajeAdvance = (int) (ganadasAdvanced*100.0f / (ganadasAdvanced + perdidasAdvanced));
        } catch (Exception e) {
            porcentajeAdvance = 0;
        }

        tv_pet.setText("Ganadas: "+ganadasPet+"\nPerdidas: "+perdidasPet+"\nPorcentaje de aciertos: "+ porcentajePet +"%");
        tv_first.setText("Ganadas: "+ganadasFirst+"\nPerdidas: "+perdidasFirst+"\nPorcentaje de aciertos: "+ porcentajeFirst +"%");
        tv_advanced.setText("Ganadas: "+ganadasAdvanced+"\nPerdidas: "+perdidasAdvanced+"\nPorcentaje de aciertos: "+ porcentajeAdvance +"%");        
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
