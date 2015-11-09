package com.crushead;

import java.util.ArrayList;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crushead.db.SQLite;
import com.crushead.dialog.GamesDialog;
import com.crushead.dialog.PauseDialog;
import com.crushead.libary.FloatingButton;
import com.crushead.list.Palabras;
import com.crushead.utils.Constant;
import com.crushead.utils.Preference;
import com.crushead.utils.TypeFaceProvider;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class Games extends Activity {

    public static final int MAX_FALLOS = 7;
    private View.OnClickListener clickListenerLetras = null;
    private ArrayList<TextView> botonesLetras = null;
    private TextView palabra = null;
    private String progreso = null;
    private Palabras palabraActual;
    private int fallos, nivelSeleccionado, categoria = 0;
    private boolean finDePartida = false; // Evita que pulsemos otras letras si somos rapidos
    private boolean esAcumulativo;
    
    Boolean querty = false;
	private FloatingButton change = null;
	Activity ctx;
	
	public final static String CONTINUAR = "com.game.CONTINUAR";
	public final static String OTRA_PARTIDA = "com.game.OTRA_PARTIDA";
	public final static String CATEGORIA = "com.game.CATEGORIA";
	
	String solucion = "";
	String nuevoProgreso = "";
	
	int color2 = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
        ctx = this;
        setContentView(R.layout.game);
        palabraActual = null;
        String fontName = "Roboto-Regular.ttf";      
        String fontName2 = "Tinet.ttf";  
		getActionBar().setDisplayHomeAsUpEnabled(true);//show up  
        
        // TextView de las palabras
        palabra = (TextView) findViewById(R.id.txt_palabra);
        
        Bundle extras = getIntent().getExtras();// Obtenemos datos enviados en el intent.
        if (extras != null) {
            nivelSeleccionado = extras.getInt(Constant.KEY_NIVEL);
            esAcumulativo = extras.getBoolean(Constant.KEY_ACUMULATIVO);
            categoria = extras.getInt(Constant.CATEGORIA);
            switch (nivelSeleccionado) {
			case 1:
				switch (categoria) {
				case 1:
					getActionBar().setSubtitle("Nivel Facil - Animales");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.indigo));
					palabra.setTextColor(getResources().getColor(R.color.indigo));
					changeJuego(getResources().getColor(R.color.indigo));
					break;
				case 2:
					getActionBar().setSubtitle("Nivel Facil - Frutas y Verduras");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.light_green));
					palabra.setTextColor(getResources().getColor(R.color.light_green));
					changeJuego(getResources().getColor(R.color.light_green));
					break;
				case 3:
					getActionBar().setSubtitle("Nivel Facil - Dibujos Geometricos");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.pink));		
					palabra.setTextColor(getResources().getColor(R.color.pink));
					changeJuego(getResources().getColor(R.color.pink));
					break;
				case 4:
					getActionBar().setSubtitle("Nivel Facil - Cosas del Hogar");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.purple));
					palabra.setTextColor(getResources().getColor(R.color.purple));
					changeJuego(getResources().getColor(R.color.purple));
					break;					
				case 5:
					getActionBar().setSubtitle("Nivel Facil - Paises");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.cyan));
					palabra.setTextColor(getResources().getColor(R.color.cyan));
					changeJuego(getResources().getColor(R.color.cyan));
					break;						
				default:
					break;
				}
				break;
			case 2:
				switch (categoria) {
				case 1:
					getActionBar().setSubtitle("Nivel Medio - Animales");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.indigo));		
					palabra.setTextColor(getResources().getColor(R.color.indigo));
					changeJuego(getResources().getColor(R.color.indigo));
					break;
				case 2:
					getActionBar().setSubtitle("Nivel Medio - Frutas y Verduras ");	
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.light_green));	
					palabra.setTextColor(getResources().getColor(R.color.light_green));	
					changeJuego(getResources().getColor(R.color.light_green));
					break;
				case 3:
					getActionBar().setSubtitle("Nivel Medio - Dibujos Geometricos");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.pink));		
					palabra.setTextColor(getResources().getColor(R.color.pink));	
					changeJuego(getResources().getColor(R.color.pink));
					break;
				case 4:
					getActionBar().setSubtitle("Nivel Medio - Cosas del Hogar");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.purple));	
					palabra.setTextColor(getResources().getColor(R.color.purple));	
					changeJuego(getResources().getColor(R.color.purple));					
					break;			
				case 5:
					getActionBar().setSubtitle("Nivel Medio - Paises");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.cyan));
					palabra.setTextColor(getResources().getColor(R.color.cyan));
					changeJuego(getResources().getColor(R.color.cyan));
					break;						
				default:
					break;
				}					
				break;
			case 3:
				switch (categoria) {
				case 1:
					getActionBar().setSubtitle("Nivel Dificil - Animales");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.indigo));	
					palabra.setTextColor(getResources().getColor(R.color.indigo));
					changeJuego(getResources().getColor(R.color.indigo));
					break;
				case 2:
					getActionBar().setSubtitle("Nivel Dificil - Frutas y Verduras ");	
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.light_green));	
					palabra.setTextColor(getResources().getColor(R.color.light_green));	
					changeJuego(getResources().getColor(R.color.light_green));
					break;
				case 3:
					getActionBar().setSubtitle("Nivel Dificil - Dibujos Geometricos");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.pink));	
					palabra.setTextColor(getResources().getColor(R.color.pink));
					changeJuego(getResources().getColor(R.color.pink));
					break;
				case 4:
					getActionBar().setSubtitle("Nivel Dificil - Cosas del Hogar");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.purple));		
					palabra.setTextColor(getResources().getColor(R.color.purple));
					changeJuego(getResources().getColor(R.color.purple));
					break;	
				case 5:
					getActionBar().setSubtitle("Nivel Dificil - Paises");
					getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.cyan));
					palabra.setTextColor(getResources().getColor(R.color.cyan));
					changeJuego(getResources().getColor(R.color.cyan));
					break;							
				default:
					break;
				}							
				break;				
			default:
				break;
			}
        }else{
            categoria = 1;
            nivelSeleccionado = SQLite.FACIL;
            esAcumulativo = false;
        }        
	
        // Lista de botones
        botonesLetras = new ArrayList<TextView>();
        // Rellenar la lista de botonesLetras
        botonesLetras.add((TextView) findViewById(R.id.txt_a));
        botonesLetras.add((TextView) findViewById(R.id.txt_b));
        botonesLetras.add((TextView) findViewById(R.id.txt_c));
        botonesLetras.add((TextView) findViewById(R.id.txt_d));
        botonesLetras.add((TextView) findViewById(R.id.txt_e));
        botonesLetras.add((TextView) findViewById(R.id.txt_f));
        botonesLetras.add((TextView) findViewById(R.id.txt_g));
        botonesLetras.add((TextView) findViewById(R.id.txt_h));
        botonesLetras.add((TextView) findViewById(R.id.txt_i));
        botonesLetras.add((TextView) findViewById(R.id.txt_j));
        botonesLetras.add((TextView) findViewById(R.id.txt_k));
        botonesLetras.add((TextView) findViewById(R.id.txt_l));
        botonesLetras.add((TextView) findViewById(R.id.txt_m));
        botonesLetras.add((TextView) findViewById(R.id.txt_n));
        botonesLetras.add((TextView) findViewById(R.id.txt_o));
        botonesLetras.add((TextView) findViewById(R.id.txt_p));
        botonesLetras.add((TextView) findViewById(R.id.txt_q));
        botonesLetras.add((TextView) findViewById(R.id.txt_r));
        botonesLetras.add((TextView) findViewById(R.id.txt_s));
        botonesLetras.add((TextView) findViewById(R.id.txt_t));
        botonesLetras.add((TextView) findViewById(R.id.txt_u));
        botonesLetras.add((TextView) findViewById(R.id.txt_v));
        botonesLetras.add((TextView) findViewById(R.id.txt_w));
        botonesLetras.add((TextView) findViewById(R.id.txt_x));
        botonesLetras.add((TextView) findViewById(R.id.txt_y));
        botonesLetras.add((TextView) findViewById(R.id.txt_z));
        
        // ClickListener para las letras:
        clickListenerLetras = new View.OnClickListener() {
            @Override
            public void onClick(View view) {;
                ((TextView) view).setOnClickListener(null);
                comprobarLetra((TextView) view);
            }
        };   
        
        Typeface tf = TypeFaceProvider.getTypeFace(this, fontName);
        Typeface tf2 = TypeFaceProvider.getTypeFace(this, fontName2);
        for(TextView b : botonesLetras) {
            b.setTypeface(tf);
            b.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);            
            b.setOnClickListener(clickListenerLetras);
        }
        palabra.setTypeface(tf2);
        nuevoJuego();   
		
	}//end onCreate
   
	private void changeJuego(int color){
		color2 = color;
		change = new FloatingButton.Builder(this)//floating bottom		
			.withDrawable(getResources().getDrawable(R.drawable.ic_looks_one_white_24dp))//icon
			.withButtonColor(color)//color
			.withButtonSize(50)		
			.withGravity(Gravity.TOP | Gravity.RIGHT)//position
			.withMargins(0, 12, 12, 0)//margin (left, top, right, bottom)
			.create();//create
		
		change.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Crouton.makeText(Games.this, "Partida nueva...", Style.CONFIRM).show();
			}
		});
	}
	
	public void showButton(final boolean show){
		int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
		change.setVisibility(View.VISIBLE);
		change.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						change.setVisibility(show ? View.VISIBLE: View.GONE);
					}
				});			
					
	}//end method showButton

    BroadcastReceiver receiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context ctx, Intent intent) {
			// TODO Auto-generated method stub
			if(intent != null){
				if(intent.getAction().equals(CONTINUAR) == true){
					if(fallos != 0 || nuevoProgreso.length() != 0){
						showButton(false);	
					}else{
						showButton(true);
					}					
				}else{
					if(intent.getAction().equals(OTRA_PARTIDA) == true){
						showButton(true);
					}
				}
			}
		}
	};
	
    public void nuevoJuego() {
        fallos = 0;
        finDePartida = false;
        for (TextView b : botonesLetras) {
            b.setTextColor(Color.BLACK);
            b.setOnClickListener(clickListenerLetras);
            b.setPaintFlags(b.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
        }
        
        ImageView img_ahorcado = (ImageView) findViewById(R.id.img_ahorcado);
        img_ahorcado.setImageResource(R.drawable.ahorcado_0);
        SQLite bd = new SQLite(this);       
        switch (categoria) {
		case 1:
	        palabraActual = bd.queryPalabraAleatoria(nivelSeleccionado, esAcumulativo, 1);			
			break;
		case 2:
	        palabraActual = bd.queryPalabraAleatoria(nivelSeleccionado, esAcumulativo, 2);
			break;			
		case 3:
	        palabraActual = bd.queryPalabraAleatoria(nivelSeleccionado, esAcumulativo, 3);
			break;	
		case 4:
	        palabraActual = bd.queryPalabraAleatoria(nivelSeleccionado, esAcumulativo, 4);
			break;
		case 5:
	        palabraActual = bd.queryPalabraAleatoria(nivelSeleccionado, esAcumulativo, 5);
			break;						
		default:
			break;
		}
        progreso = "";      
        for (int i = 0; i < palabraActual.getPalabra().length(); i++) {
        	if(Character.isLowerCase(palabraActual.getPalabra().charAt(i))){
        		progreso += '_';
            }else{
            	progreso += palabraActual.getPalabra().charAt(i);
            }
        }
            palabra.setText(progreso);
        
    }//end method new game
    
    public Palabras getPalabraActual() {
        return palabraActual;
    }
    public int getFallosActuales() {
        return fallos;
    }
    public int getNivelSeleccionado() {
        return nivelSeleccionado;
    }
    public boolean getEsAcumuladivo() {
        return esAcumulativo;
    }    
    
    public int getCategoria() {
        return categoria;
    }     
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_MENU ) {
            new PauseDialog(this).show();
        	showButton(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
    public void onBackPressed() {
        new PauseDialog(this).show();
    	showButton(false);
    }

    public void volverAtras() {
        super.onBackPressed();
    	showButton(false);
        Category.reproducirSonido(R.raw.pagination, this);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
    
    public void comprobarLetra(TextView textView) {
        if (!finDePartida) {
        	showButton(false);
            if (palabraActual.getPalabra().contains(textView.getText())) {
                textView.setTextColor(Color.GREEN);
                solucion = palabraActual.getPalabra();
                nuevoProgreso = "";
                char letra;
                for (int i = 0; i < progreso.length(); i++) {
                    letra = textView.getText().charAt(0);
                    nuevoProgreso += (solucion.charAt(i) == letra) ? letra : progreso.charAt(i);
                }

                progreso = nuevoProgreso;
                Category.reproducirSonido(R.raw.acierto, this);

                if (nuevoProgreso.equals(solucion)) {
                    finDePartida = true;
                    new GamesDialog(this, "¡Has acertado!", false).show();
                    almacenarEstadisticas(Constant.KEY_WON);
                    /*
                    almacenarEstadisticas(Constant.KEY_WON);
                	sendBroadcast(new Intent(Games.OTRA_PARTIDA));
                	Crouton.makeText(ctx, "¡Has acertado!", Style.CONFIRM).show();
                	nuevoJuego();     
                     */
                }

                // visualizacion del proceso
                palabra.setText(progreso);
            } else {
                textView.setTextColor(Color.RED);
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                fallos++;

                ImageView img_ahorcado = (ImageView) findViewById(R.id.img_ahorcado);
                int id_imagen_fallo = getResources().getIdentifier("com.crushead:drawable/ahorcado_" + fallos, null, null);
                img_ahorcado.setImageResource(id_imagen_fallo);

                Category.reproducirSonido(R.raw.error, this);

                if (fallos == MAX_FALLOS) {
                    finDePartida = true;
                    new GamesDialog(this, "¡Ooops!", false).show();
                    almacenarEstadisticas(Constant.KEY_LOST);
                }
            }
        }
    }
    @SuppressWarnings("unused")
	@Deprecated
    private String visualizar(String s) {
        String resultado = "";
        for (int i = 0; i < s.length()-1; i++) {
            resultado += s.charAt(i) + " ";
        }
        resultado += s.charAt(s.length()-1);
        return resultado;
    }

    private void almacenarEstadisticas(String resultado){// Almacena el resultado para la contabilizacion de las estadisticas.
        int nivel = palabraActual.getDificultad();
        String str_nivel = "";
        switch (nivel){
            case SQLite.FACIL: str_nivel = Constant.KEY_PET; break;
            case SQLite.MEDIO: str_nivel = Constant.KEY_FIRST; break;
            case SQLite.DIFICIL: str_nivel = Constant.KEY_ADVANCED; break;
        }

        int contador;
        try {
            contador = Preference.getInt(str_nivel+resultado, this);
        } catch (Exception e) {
            contador = 0;
        }
        Preference.putInt(str_nivel+resultado,contador+1,this);
        almacenarFallos();
    }

    private void almacenarFallos() {//Actualiza los fallos de la palabra actual en la base de datos.
    	SQLite bd = new SQLite(this);
    	Log.i("FALLOS","Nmero de fallos final: "+fallos);
        bd.updatePalabra(palabraActual.getId(),fallos);
        bd.close();
    }    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.games, menu);
		if(nivelSeleccionado == SQLite.DIFICIL){
			menu.findItem(R.id.action_pista).setVisible(false);	
		}else{
			menu.findItem(R.id.action_pista).setVisible(true);				
		}	
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	showButton(false);
	            new PauseDialog(this).show();
	            return true;
			case R.id.action_pista:
				if(palabraActual.pista != null){
					Crouton.makeText(this, palabraActual.pista, Style.INFO).show();
				}else{
					Crouton.makeText(this, "No existen pista", Style.INFO).show();					
				}
	            return true;          
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Crouton.cancelAllCroutons();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Crouton.cancelAllCroutons();		
		super.onPause();
		unregisterReceiver(receiver);
	}    
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		IntentFilter filter = new IntentFilter();
		filter.addAction(CATEGORIA);
		filter.addAction(OTRA_PARTIDA);
		filter.addAction(CONTINUAR);
		registerReceiver(receiver, filter);
	}
}//end class
