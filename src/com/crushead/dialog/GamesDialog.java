package com.crushead.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crushead.Category;
import com.crushead.Games;
import com.crushead.R;
import com.crushead.utils.Constant;
import com.crushead.utils.Preference;
import com.crushead.utils.TypeFaceProvider;

@SuppressLint({ "DefaultLocale", "NewApi" })
public class GamesDialog extends ClearDialog {
	
    private String tittle;
    Activity activity;
	private int id;
    
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_game);
		
        String fontName = "Roboto-Regular.ttf";
        Typeface tf = TypeFaceProvider.getTypeFace(activity,fontName);
        TextView tv_tittle = (TextView) findViewById(R.id.tv_tittle);
        TextView tv_word = (TextView) findViewById(R.id.tv_word);
        Button btn_again = (Button) findViewById(R.id.btn_again);
        Button btn_menu = (Button) findViewById(R.id.btn_menu);
        tv_tittle.setTypeface(tf);
        tv_word.setTypeface(tf);
        btn_again.setTypeface(tf);
        btn_menu.setTypeface(tf);

        tv_tittle.setText(tittle);	
        tv_word.setText('"'+(((Games) activity).getPalabraActual()).getPalabra().toUpperCase()+'"');

        tv_word.setTextColor((((Games) activity)).getFallosActuales() == Games.MAX_FALLOS ?
                activity.getResources().getColor(R.color.red_500) :
                activity.getResources().getColor(R.color.green_500));
        
    	int sdk = android.os.Build.VERSION.SDK_INT;
        try {
			id = Preference.getInt("CATEGORIA", activity);
        	if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        		switch (id) {
				case Constant.ID_ANIMALES:
					btn_again.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
					btn_menu.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));					
					break;
				case Constant.ID_FRUTAS:
					btn_again.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
					btn_menu.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));						
					break;
				case Constant.ID_FIGURAS:
					btn_again.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
					btn_menu.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));						
					break;
				case Constant.ID_ARTICULOS:
					btn_again.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
					btn_menu.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));  						
					break;
				case Constant.ID_PAISES:
					btn_again.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
					btn_menu.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));  						
					break;						
				default:
					break;
				}
        	} else {
        		switch (id) {
				case Constant.ID_ANIMALES:
					btn_again.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow));
					btn_menu.setBackground(activity.getResources().getDrawable(R.drawable.animal_btn_shadow)); 					
					break;
				case Constant.ID_FRUTAS:
					btn_again.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
					btn_menu.setBackground(activity.getResources().getDrawable(R.drawable.frutas_btn_shadow));
					break;
				case Constant.ID_FIGURAS:
					btn_again.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
					btn_menu.setBackground(activity.getResources().getDrawable(R.drawable.figuras_btn_shadow));
					break;
				case Constant.ID_ARTICULOS:
					btn_again.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));
					btn_menu.setBackground(activity.getResources().getDrawable(R.drawable.cosas_btn_shadow));  						
					break;					
				case Constant.ID_PAISES:
					btn_again.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));
					btn_menu.setBackground(activity.getResources().getDrawable(R.drawable.paises_btn_shadow));  							
				default:
					break;
				}        		
        	}				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	activity.sendBroadcast(new Intent(Games.OTRA_PARTIDA));            	
            	((Games) activity).nuevoJuego();
                GamesDialog.this.dismiss();
            }
        });
        
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Category.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
                Category.reproducirSonido(R.raw.pagination, activity);
                activity.finish();
				Preference.putInt("CATEGORIA", 0, activity);
            }
        });

    }       
    public GamesDialog(Activity context, String tittle) {
        super(context);
        activity = context;
        this.tittle = tittle;
    }

    public GamesDialog(Activity context, String tittle, boolean cancelable) {
        super(context, cancelable);
        activity = context;
        this.tittle = tittle;
    } 	
}//end class
