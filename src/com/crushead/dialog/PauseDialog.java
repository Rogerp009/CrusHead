package com.crushead.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.crushead.Category;
import com.crushead.Games;
import com.crushead.R;
import com.crushead.utils.Constant;
import com.crushead.utils.Preference;
import com.crushead.utils.TypeFaceProvider;

public class PauseDialog extends ClearDialog {
    Activity activity;

    public PauseDialog(Activity context) {
        super(context, false);
        activity = context;
    }
    Button btn_continue  = null;
    Button btn_otra_partida  = null;
    Button categoria  = null;
	private int id;
    
    @SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pause);

        String fontName = "Roboto-Regular.ttf";
        Typeface tf = TypeFaceProvider.getTypeFace(activity,fontName);

        TextView tv_pause = (TextView) findViewById(R.id.tv_pause);
        btn_continue = (Button) findViewById(R.id.btn_continue);
        btn_otra_partida = (Button) findViewById(R.id.btn_again);
        categoria = (Button) findViewById(R.id.btn_category);
        
        tv_pause.setTypeface(tf);
        btn_continue.setTypeface(tf);
        btn_otra_partida.setTypeface(tf);
        categoria.setTypeface(tf);
    	int sdk = android.os.Build.VERSION.SDK_INT;
        try {
			id = Preference.getInt("CATEGORIA", activity);
        	if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        		switch (id) {
				case Constant.ID_ANIMALES:
					btn_continue.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
					btn_otra_partida.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
					categoria.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));  					
					break;
				case Constant.ID_FRUTAS:
					btn_continue.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
					btn_otra_partida.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
					categoria.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));  						
					break;
				case Constant.ID_FIGURAS:
					btn_continue.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
					btn_otra_partida.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
					categoria.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));  						
					break;
				case Constant.ID_ARTICULOS:
					btn_continue.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
					btn_otra_partida.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
					categoria.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));  						
					break;
				case Constant.ID_PAISES:
					btn_continue.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
					btn_otra_partida.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
					categoria.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));  						
					break;						
				default:
					break;
				}
        	} else {
        		switch (id) {
				case Constant.ID_ANIMALES:
					btn_continue.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
					btn_otra_partida.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
					categoria.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));  					
					break;
				case Constant.ID_FRUTAS:
					btn_continue.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
					btn_otra_partida.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
					categoria.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));  						
					break;
				case Constant.ID_FIGURAS:
					btn_continue.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
					btn_otra_partida.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
					categoria.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));  						
					break;
				case Constant.ID_ARTICULOS:
					btn_continue.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
					btn_otra_partida.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
					categoria.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));  						
					break;		
				case Constant.ID_PAISES:
					btn_continue.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
					btn_otra_partida.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
					categoria.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));  						
					break;								
				default:
					break;
				}        		
        	}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	activity.sendBroadcast(new Intent(Games.CONTINUAR));
                PauseDialog.this.dismiss();
            }
        });

        btn_otra_partida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PauseDialog.this.dismiss();
                Intent intent = new Intent(getContext(), Games.class);
                intent.putExtra(Constant.KEY_NIVEL, ((Games) activity).getNivelSeleccionado());
                intent.putExtra(Constant.CATEGORIA, ((Games) activity).getCategoria());
                intent.putExtra(Constant.KEY_ACUMULATIVO, ((Games) activity).getEsAcumuladivo());
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                activity.startActivity(intent);
                activity.overridePendingTransition(0,0);
                activity.finish();
                Toast.makeText(activity, "Partida Cambiada", Toast.LENGTH_SHORT).show();            
                ((Games) activity).nuevoJuego();
            }
        });

        categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PauseDialog.this.dismiss();
                Intent intent = new Intent(getContext(), Category.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
                Category.reproducirSonido(R.raw.pagination, activity);
                activity.finish();
				Preference.putInt("CATEGORIA", 0, activity);
				activity.getActionBar().setTitle("Categorias");						
            }
        });        
    }
}

