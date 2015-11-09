package com.crushead.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crushead.Category;
import com.crushead.Games;
import com.crushead.R;
import com.crushead.db.SQLite;
import com.crushead.utils.Constant;
import com.crushead.utils.Preference;
import com.crushead.utils.TypeFaceProvider;

@SuppressLint("NewApi")
public class DifficultyDialog extends ClearDialog{
	
    Activity activity = null;
    int id;
    Button btn_facil = null;
    Button btn_medio = null;
    Button btn_dificil = null;
    
    int sdk = android.os.Build.VERSION.SDK_INT;
    public DifficultyDialog(Activity context) {
    	super(context, true);
        this.activity = context;
    }
    
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_difficulty);
        String fontName = "Roboto-Regular.ttf";
        Typeface tf = TypeFaceProvider.getTypeFace(activity, fontName);

        TextView tv_difficulty = (TextView) findViewById(R.id.tv_difficulty);
        TextView categoria = (TextView) findViewById(R.id.categoria);
        btn_facil = (Button) findViewById(R.id.btn_b1);
        btn_medio = (Button) findViewById(R.id.btn_b2_excl);
        btn_dificil = (Button) findViewById(R.id.btn_c1_excl);

        tv_difficulty.setTypeface(tf);
        btn_facil.setTypeface(tf);
        btn_medio.setTypeface(tf);
        btn_dificil.setTypeface(tf);
        categoria.setTypeface(tf);
    	int sdk = android.os.Build.VERSION.SDK_INT;
        try {
			id = Preference.getInt("CATEGORIA", activity);
        	if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        		switch (id) {
				case Constant.ID_ANIMALES:
					categoria.setText("Categoria Animales");
					categoria.setTextColor(activity.getResources().getColor(R.color.indigo));					
                    btn_facil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
                    btn_medio.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
                    btn_dificil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
					break;
				case Constant.ID_FRUTAS:
					categoria.setText("Categoria Frutas y Verduras");		
					categoria.setTextColor(activity.getResources().getColor(R.color.light_green));						
                    btn_facil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
                    btn_medio.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
                    btn_dificil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));					
					break;
				case Constant.ID_FIGURAS:
					categoria.setText("Categoria Dibujos Geométricos");	
					categoria.setTextColor(activity.getResources().getColor(R.color.pink));						
                    btn_facil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
                    btn_medio.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
                    btn_dificil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));					
					break;
				case Constant.ID_ARTICULOS:
					categoria.setText("Categoria Cosas del Hogar");	
					categoria.setTextColor(activity.getResources().getColor(R.color.purple));	
                    btn_facil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
                    btn_medio.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
                    btn_dificil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));					
					break;		
				case Constant.ID_PAISES:
					categoria.setText("Categoria Paises");	
					categoria.setTextColor(activity.getResources().getColor(R.color.cyan));	
                    btn_facil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
                    btn_medio.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
                    btn_dificil.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));					
					break;						
				default:
					break;
				}
        	} else {
        		switch (id) {
				case Constant.ID_ANIMALES:
					categoria.setText("Categoria Animales");
					categoria.setTextColor(activity.getResources().getColor(R.color.indigo));						
					categoria.setTextColor(activity.getResources().getColor(R.color.indigo));
                    btn_facil.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
                    btn_medio.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
                    btn_dificil.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));					
					break;
				case Constant.ID_FRUTAS:
					categoria.setText("Categoria Frutas y Verduras");	
					categoria.setTextColor(activity.getResources().getColor(R.color.light_green));						
                    btn_facil.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
                    btn_medio.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
                    btn_dificil.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));					
					break;
				case Constant.ID_FIGURAS:
					categoria.setText("Categoria Dibujos Geométricos");		
					categoria.setTextColor(activity.getResources().getColor(R.color.pink));						
                    btn_facil.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
                    btn_medio.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
                    btn_dificil.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));					
					break;
				case Constant.ID_ARTICULOS:
					categoria.setText("Categoria Cosas del Hogar");		
					categoria.setTextColor(activity.getResources().getColor(R.color.purple));						
                    btn_facil.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
                    btn_medio.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
                    btn_dificil.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));					
					break;	
				case Constant.ID_PAISES:
					categoria.setText("Categoria Paises");	
					categoria.setTextColor(activity.getResources().getColor(R.color.cyan));	
                    btn_facil.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
                    btn_medio.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
                    btn_dificil.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));					
					break;					
				default:
					break;
				}        		
        	}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        btn_facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DifficultyDialog.this.dismiss();
        		switch (id) {
				case Constant.ID_ANIMALES:
					iniciarPartida(SQLite.FACIL, false, Constant.ID_ANIMALES);	  
					break;
				case Constant.ID_FRUTAS:
					iniciarPartida(SQLite.FACIL, false, Constant.ID_FRUTAS);
					break;
				case Constant.ID_FIGURAS:		
					iniciarPartida(SQLite.FACIL, false, Constant.ID_FIGURAS);					
					break;
				case Constant.ID_ARTICULOS:
					iniciarPartida(SQLite.FACIL, false, Constant.ID_ARTICULOS);					
					break;	
				case Constant.ID_PAISES:
					iniciarPartida(SQLite.FACIL, false, Constant.ID_PAISES);					
					break;						
				default:
					break;
        		}
            }
        });

        btn_medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DifficultyDialog.this.dismiss();
        		switch (id) {
				case Constant.ID_ANIMALES:
					iniciarPartida(SQLite.MEDIO, false, Constant.ID_ANIMALES);	  
					break;
				case Constant.ID_FRUTAS:
					iniciarPartida(SQLite.MEDIO, false, Constant.ID_FRUTAS);
					break;
				case Constant.ID_FIGURAS:		
					iniciarPartida(SQLite.MEDIO, false, Constant.ID_FIGURAS);					
					break;
				case Constant.ID_ARTICULOS:
					iniciarPartida(SQLite.MEDIO, false, Constant.ID_ARTICULOS);					
					break;	
				case Constant.ID_PAISES:
					iniciarPartida(SQLite.MEDIO, false, Constant.ID_PAISES);					
					break;							
				default:
					break;
        		}
            }
        });

        btn_dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DifficultyDialog.this.dismiss();
        		switch (id) {
				case Constant.ID_ANIMALES:
					iniciarPartida(SQLite.DIFICIL, false, Constant.ID_ANIMALES);	  
					break;
				case Constant.ID_FRUTAS:
					iniciarPartida(SQLite.DIFICIL, false, Constant.ID_FRUTAS);
					break;
				case Constant.ID_FIGURAS:		
					iniciarPartida(SQLite.DIFICIL, false, Constant.ID_FIGURAS);					
					break;
				case Constant.ID_ARTICULOS:
					iniciarPartida(SQLite.DIFICIL, false, Constant.ID_ARTICULOS);					
					break;	
				case Constant.ID_PAISES:
					iniciarPartida(SQLite.DIFICIL, false, Constant.ID_PAISES);					
					break;						
				default:
					break;
        		}
            }
        });

    }
 
    private void iniciarPartida(int nivel, boolean acumulativo, int category) {
        Intent intent = new Intent(activity, Games.class);
        intent.putExtra(Constant.KEY_NIVEL, nivel);
        intent.putExtra(Constant.CATEGORIA, category);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constant.KEY_ACUMULATIVO, acumulativo);
        activity.startActivity(intent);
        Category.reproducirSonido(R.raw.pagination, activity);
        activity.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		activity.getActionBar().setBackgroundDrawable(activity.getResources().getDrawable(R.color.main));
		activity.getActionBar().setTitle("Categorias");				
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = MotionEventCompat.getActionMasked(event);	
		switch (action) {
		case (MotionEvent.ACTION_DOWN):
			activity.getActionBar().setBackgroundDrawable(activity.getResources().getDrawable(R.color.main));
			activity.getActionBar().setTitle("Categorias");						
			break;
		case (MotionEvent.ACTION_MOVE):
			activity.getActionBar().setBackgroundDrawable(activity.getResources().getDrawable(R.color.main));
			activity.getActionBar().setTitle("Categorias");							
			break;
		case (MotionEvent.ACTION_UP):
			activity.getActionBar().setBackgroundDrawable(activity.getResources().getDrawable(R.color.main));
			activity.getActionBar().setTitle("Categorias");						
			break;
		case (MotionEvent.ACTION_CANCEL):
			activity.getActionBar().setBackgroundDrawable(activity.getResources().getDrawable(R.color.main));
			activity.getActionBar().setTitle("Categorias");					
			break;
		case (MotionEvent.ACTION_OUTSIDE):
			activity.getActionBar().setBackgroundDrawable(activity.getResources().getDrawable(R.color.main));
			activity.getActionBar().setTitle("Categorias");					
			break;				
		default:
			break;
		}		
		return super.onTouchEvent(event);
	}    
 
	
}//end class
