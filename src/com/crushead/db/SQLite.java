package com.crushead.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.crushead.list.Palabras;
import com.crushead.utils.Constant;

public class SQLite extends SQLiteOpenHelper{
	
    private final static String NAME = "crushead.db";
    private final static int VERSION = 1;
    private final static String PALABRA = "palabra";
    private final static String DIFICULTAD = "dificultad";
    private final static String PISTA = "pista";
    private final static String FALLOS = "fallos";
    private final static String CATEGORIA = "categoria";
    public final static int FACIL = 1;
    public final static int MEDIO = 2;
    public final static int DIFICIL = 3;
    
    public final static String CRUS_HEAD = "palabra_crus_head";
 
    private final static String CREATE_TABLE_PALABRAS = "CREATE TABLE " + CRUS_HEAD + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PALABRA + " TEXT, " +
            PISTA + " TEXT, " +                   
            CATEGORIA + " INTEGER, " +        
            DIFICULTAD +" INTEGER, " +
            FALLOS +" INTEGER ); ";  
    
  
	public SQLite(Context context) {		
		 super(context, NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_PALABRAS);

		insertPalabra(db, "Armadillo",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Coati",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Alcatraz",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Alcaravan",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Aguila",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Antilope",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Ciervo",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Almeja",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Almeja",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Anguila",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Boa",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Babosa",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Bufalo",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Buitre",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Bisonte",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Beluga",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Garrapata",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Condor",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Cacatua",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Buey",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Lemur",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Nutria",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Mula",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Iguana",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Gorrion",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Gorila",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Golondrina",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Chimpance",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Comadreja",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Cucaracha",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Coyote",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Calamar",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Escarabajo",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Faisan",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Gavilan",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Gorgojo",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Grulla",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Huron",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Lagartija",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Libelula",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Morsa",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Manati",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Nutria",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Ornitorrinco",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);
		insertPalabra(db, "Sardina",  "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ANIMALES, DIFICIL);

		/** Frutas*/ 
		insertPalabra(db, "Endibias"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Chirivia"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Alcachofa"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Canonigo"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Habas"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Melon"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Sandia"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Uva"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Membrillo"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Jobo"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Hicaco"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Higo"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Grosella"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Arandano"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Frutipan"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Escaramujo"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Datil"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Chirimoya"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Alquequenje"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Albaricoque"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Acerola"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Carambolo"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Caqui"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);
		insertPalabra(db, "Carisa"," no hay pista para nivel dificil", Constant.ID_FRUTAS, DIFICIL);

		/** Figuras */
		insertPalabra(db, "Trapezoides", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Trapecio", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Tetraedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Pentaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Hexaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Heptaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Octaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Eneadero", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Decaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Endecaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Dodecaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Tridecaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Tetradecaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		insertPalabra(db, "Pentadecaedro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_FIGURAS, DIFICIL);
		/** Articulos */
		insertPalabra(db, "Porton", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Vajillas", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Enchufe", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Cuadro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Llave", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Plancha", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Gavetas", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Libro", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Edredon", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Escalera", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Recogedor", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Sarten", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Mueble", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Vela", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Licuadora", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Taza", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Linterna", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Estante", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);
		insertPalabra(db, "Florero", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_ARTICULOS, DIFICIL);


		/** Paises*/
		insertPalabra(db, "Argentina", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Austria", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Belgica", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Bolivia", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Camerun", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Dinamarca", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Grecia", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Holanda", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Hondura", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Indonesia", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Irak", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Iran", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Marruecos", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Nigeria", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Nepal", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Nicaragua", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Paraguay", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Polonia", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Peru", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Rumania", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Suecia", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Sudafrica", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Tunez", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Tanzania", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Andorra", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Azerbaiyan", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Luxemburgo", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Vietnam", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Chipre", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Birmania", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Surinam", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Mozambique", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Botsuana", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Malawi", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Seychelles", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Kirguistan", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Kiribati", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Maldivas", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Uzbekistan", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Tayikistan ", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);
		insertPalabra(db, "Liechtenstein ", "Lo sentimos, no hay pista para nivel dificil", Constant.ID_PAISES, DIFICIL);

		/** Animales */
		insertPalabra(db, "Conejo", "Muy saltarin y tiene una j", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Elefante", "Grande y comienza por E", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Caballo", "La palabra tiene dos Ll", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Avestruz", "Es el ave mas grande del mundo.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Avispa", "Parecida a la abeja, pero estas no producen miel.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Cebra", "Blanca con rayas negras, ¿o negra con rayas blancas?", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Buho", "Ave que gira su cabeza hasta 180 grados para ver hacia atras.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Caracol", "Lleva su casa en la espalda.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Delfin", "Es un mamifero, el del fin.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Elefante", "Es el mamifero terrestre mas grande del mundo.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Tigre", "Felino de mayor tamaño que existe.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Rinoceronte", "Mamifero africano de color gris y patas cortas.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Orca", "Conocida tambien como ballena asesina.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Canario", "Ave pequeña de color verde amarillo.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Llama", "Mamifero que se encuentra en los andes.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Mapache", "Mamifero pequeño peludo con manchas negras alrededor de sus ojos.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Mariquita", "Insecto cuyo lomo es rojo con puntos negros.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Koala", "Mamifero originario de Australia.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Tiburon", "Pez que mayor miedo causa en los humanos.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Hipopotamo", "Mamifero que vive en africa, comienza con Hi.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Guepardo", "Animal mas veloz de la tierra.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Cocodrilo", "Reptil, depredador con boca muy grande y filosos dientes.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Oveja", "Mamifero con el cuerpo cubierto de lana.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Cerdo", "Mamifero de color rosado.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Pavo", "Posee una larga cola que al desplegar parece un abanico.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Ganso", "Conocido tambien como cisne.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Erizo", "Pequeño, vive en el mar y tiene muchas puyas.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Grillo", "Es un insecto con un insistente canto.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Gaviota", "Ave costera.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Hiena", "Llena.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Halcon", "Ave, cazador de alto vuelo.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Jaguar", "Es el felino mas grande de America.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Jabal", "Conocido tambien como cerdo salvaje.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Kiwi", "Existe una fruta con ese mismo nombre.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Luciernaga", "Insecto que alumbra de noche.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Lechuza", "Es un ave nocturna, caza de noche ratones y otros animales pequeños.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Panda", "Es como el oso pero en blanco y negro.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Puercoespin", "tiene una capa de puas que cubre su cuerpo.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Paloma", "Es uno de los animales mas comunes en nuestras ciudades.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Rata", "Roedor, un poco mas grande que la rata.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Topo", "Mamifero adaptado para vivir bajo tierra.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Urraca", "Ave que siente gran atraccion por objetos brillantes.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Venado", "unico mamifero que le crece cuernos formados por huesos muertos que se renuevan cada año.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Yegua", "Hembra del caballo.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Abejorro", "De la misma familia que las abejas.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "Salmon", "Pez que nace en rios.", Constant.ID_ANIMALES, MEDIO);
		insertPalabra(db, "OsoPolar", "Parecido al oso pero totalmente blanco.", Constant.ID_ANIMALES, MEDIO);


		/** Frutas */
		insertPalabra(db, "Acelga", "planta de tallo largo, blanco y hojas verdes.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Alfalfa", "Se come fresca en ensaladas, tiene densas agrupaciones de flores purpuras.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Apio", "Vegetal muy aromatico, parecido al perejil.", Constant.ID_FRUTAS, MEDIO); 
		insertPalabra(db, "Calabacin", "Diminutivo de calabaza.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Col", "Es redonda compuesta solo de hojas, de varios colores, verde, blanca o morada.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Grelos", "Son las hojas de los nabos que se salen antes de la floracion.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Guisantes", "Semillas encerradas dentro de un fruto de color verde claro.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Nabos", "Parecen patatas, pero de color blanco.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Berros", "Planta acuatica que crece en fuentes y riachuelos.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Frambuesa", "Su nombre es parecido a la Fresa", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Granada", "Fruta de color rojo cuyo exterior es un poco duro y dentro tiene muchas semillas", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Patata", "Verdura que tiene mucho parecido a una piedra.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Remolacha", "Verdura de color morado oscuro.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Ajo", "Es pequeña cuyos dientes estan protegidos por una capa blanca.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Berenjena", "Verdura de color morado muy oscuro.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Pepino", "Verdura larga de color verde.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Pimenton", "Vegetal de color verde oscuro.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Brrcoli", "Verdura pequeño de color verde oscuro.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Coliflor", "Es blanca, parecen copos de nieve, cubiertos de hojas verdes.", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Nispero", "Fruto marron oscuro de textura arenosa", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Papaya", "Fruta verde con textura muy suave, el tronco del arbol tiene similitud a una palmera", Constant.ID_FRUTAS, MEDIO);
		insertPalabra(db, "Kiwi", "Existe un animal con ese nombre", Constant.ID_FRUTAS, MEDIO);

		/** Figuras */
		insertPalabra(db, "Paralelepipedo", "Figura que tiene forma de caja de regalo rectangular y contiene 2 L", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Poligono", "Figura que viene representada por: triangulos, cuadrados y pentagonos y termina en no", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Equilatero", "Triangulo con sus tres lados iguales comeinza en e", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Isosceles", "Triangulo con solo dos lados iguales y contiene la palabra sos", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Escaleno", "Triangulo donde ninguno de sus lados son iguales y termina no", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Cuadrilatero", "Figura que tiene cuatro (4) lados y termina en tero", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Pentagono", "Figura que tiene catorce (5) lados y comienza en pen", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Hexagono", "Figura que tiene catorce (6) lados tiene una x", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Heptagono", "Figura que tiene catorce (7) lados tiene una p", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Octogono", "Figura que tiene catorce (8) lados tiene 3 o", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Eneagono", "Figura que tiene catorce (9) lados comienza en ene", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Decagono", "Figura que tiene catorce (10) lados comeinza en deca", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Endecagono", "Figura que tiene catorce (11) lados comienza en ende", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Dodecagono", "Figura que tiene catorce (12) lados 2 d", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Tridecagono", "Figura que tiene catorce (13) lados termina en gono", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Tetradecagono", "Figura que tiene catorce (14) lados contiene tra", Constant.ID_FIGURAS, MEDIO);
		insertPalabra(db, "Pentadecagono", "Figura que tienen quince (15) lados y comienza en penta", Constant.ID_FIGURAS, MEDIO);

		/** Objetos*/
		insertPalabra(db, "Microondas", "Calientas la comida fria", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Lavamanos", "Te lavas las manos", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Closet", "Guardas la ropa", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Sabanas", "Te da calor en las noches", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Toallas", "Te secas despues de bañarte", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Champu", "Para el cabello mientras te bañas", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Cubeta", "Recipiente donde colocas agua u otros liquidos", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Escoba", "Sirve para barrer la casa", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Fosforo:", "Para encender la cocina", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Juego de video", "Lo conectas a la TV y juegas", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Servilleta", " Te limpias las manos con ella", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Lampara", "Alumbra tu cuarto.", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Regadera", " Te bañas con ella.", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Nevera", "Donde guardas y mantienes los alimentos frios", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Cubiertos", "Los necesitas para comer", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Ventilador", "Va de un lado a otro mientras te refresca", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Bombillo", "Alumbra la casa.", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Puerta", "Por donde pasas a la casa", Constant.ID_ARTICULOS, MEDIO);
		insertPalabra(db, "Almohada", "Esta en tu cama, pones tu cabeza para descansar", Constant.ID_ARTICULOS, MEDIO);

		/** Paises*/
		insertPalabra(db, "Alemania", "Es el ultimo campeon mundial de futbol masculino.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Argelia", "Pais africano, su capital es Argel.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Australia", "Diversa variedad de animales, entre ellos, canguros.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Brasil", "Pais de America del Sur, La samba los identifica.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Colombia", "Lugar donde murio el Libertador Simon Bolivar.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Cuba", "Su capital es La Habana.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "China", "Su capital es Pekin.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Canada", "Es el pais mas grande de America.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Egipto", "El rio Nilo.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Ecuador", "La linea imaginaria que divide los Hemisferios lleva su nombre.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Francia", "Pais europeo, Torre Eiffel.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Guyana", "Limita al oeste con Venezuela, empieza con G.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Granada", "Isla del Mar Caribe, Su nombre tambien es una fruta.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Israel", "Su capital es Jerusalen.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Japon", "Pais asiatico, su capital es Tokio.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Letonia", "Pais europeo, su idioma es el leton.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Malta", "Tiene el mismo nombre que una bebida.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Rusia", "Pais mas grande del mundo.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Mexico", "Conocido por sus tacos y tamales.”,", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Montenegro", "Contiene nombre de un color", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Panama", "Tiene un gran canal que conecta el oceano Atlantico y el oceano Pacifico", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Jamaica", "Isla del Mar Caribe, conocida por el Reggae y Bob Marley", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Suiza", "Chocolate Toblerone.", Constant.ID_PAISES, MEDIO);
		insertPalabra(db, "Uruguay", "Pais suramericano, Su capital es Montevideo.", Constant.ID_PAISES, MEDIO);


		insertPalabra(db, "Perro", "El mejor amigo del hombre", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Zorro", "Existe en muchas peliculas y comienza por Z", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Atun", "Es un pez, lata de…", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Abeja", "Extraen el polen de las flores para elaborar miel.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Ardilla", "Le gusta las nuez.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Asno", "Tambien conocido como burro.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Anaconda", "Serpiente mas grande del mundo.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Camaleon", "Cambia su piel de color.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Flamenco", "Ave de color rosado con el cuello muy largo.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Foca", "Mamifero de color gris, comienza con F.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Leon", "Rey de la selva.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Ballena", "Mamifero marino mas grande de la tierra.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Saltamontes", "Salta montes.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Tucan", "Ave con el pico muy grande.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Perro", "El mejor amigo del hombre.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Gato", "Miauu.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Raton", "Mickey mouse.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Jirafa", "Animal mas alto que existe, de cuello muy largo.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Escorpion", "Tambien conocido como Alacran.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Loro", "Ave de color verde oscuro.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Caballo", "Mamifero de 4 patas, cola y cabeza larga.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Gallina", "Pone los huevos del desayuno.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Gallo", "Ki-ki-ri-ki.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Cangrejo", "Camina para atras.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Culebra", "Reptil que no tiene patas, se arrastra.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Ciempies", "100 pies.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Camello", "Tiene 2 grandes bolas en su espalda.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Conejo", "Mamifero pequeño peludo, camina saltando en sus patas traseras.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Canguro", "Mamifero australiano, lleva en su vientre una bolsa donde carga a su bebe.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Hombre", "Mamifero capaz de pensar y razonar.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Lobo", "Caperucita roja.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Lombriz", "Insecto sin patas que vive bajo la tierra.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Mariposa", "Hermoso insecto volador, sus alas llaman la atencion.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Mosquito", "Pequeño insecto que chupan la sangre.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Mono", "Mamifero primate.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Murcielago", "Batman.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Oso", "Mamifero grande muy peludo de color oscuro.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Pulpo", "Molusco marino de ocho brazos.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Pinguino", "Ave que no puede volar, de color blanco y negro.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Perezoso", "Pasa el mayor tiempo del dia durmiendo.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Vaca", "Mamifero que da la leche.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Castor", "Mamifero que construye presas.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Zorro", "Mamifero, comienza con Z.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Colibri", "Conocido tambien como picaflor.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Tortugas", "Poseen un duro caparazon.", Constant.ID_ANIMALES, FACIL);
		insertPalabra(db, "Hormiga", "Insectos que viven en colonias.", Constant.ID_ANIMALES, FACIL);

		/** Frutas */
		insertPalabra(db, "Zanahoria", "Les gusta a los conejos.", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Cebolla", "Te hace llorar al picarla.", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Espinaca", "Verdura que come Popeye el marino", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Lechuga", "Las hojas verdes que tiene la hamburguesa.", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Calabaza", "En Halloween usan mucho esta verdura.", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Tomate", "Pequeña, redonda y roja, es parte de la hamburguesa.", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Aguacate", "Verde por fuera, blanco por dentro.", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Aceituna", "Muchas personas lo sacan de has hallacas y pan de jamon,", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Anon", "Fruta de color verde claro, empieza con A", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Banana", "Le gusta mucho a los monos", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Cereza", "Fruta de color morado muy pequeña y comienza con C", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Ciruela", "El arbol que la produce es el ciruelo", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Coco", "Fruta que crece en grandes palmeras", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Fresa", "Fruta pequeña de color rojo y hojas pequeñas en la parte de arriba", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Limon", "Con esta fruta se hace limonada", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Guayaba", "Fruta pequeña y redonda que comienza con la silaba GU", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Naranja", "Fruta citrica cuyo nombre es el mismo que su color", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Manzana", "Es una fruta roja, conocida por Adan y Eva", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Mandarina", "Fruta citrica de color naranja", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Mango", "fruto amarillo rojizo y su pulpa es amarilla, su semilla es grande", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Pera", "Fruto verde con su interior blanco, su forma es igual a un bombillo", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Mora", "Fruto de color morado parecido a la fresa", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Melocoton", "Tambien llamado Durazno", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Maracuya", "Tambien se le conoce como parchita", Constant.ID_FRUTAS, FACIL);
		insertPalabra(db, "Lima", "Parecida al limon", Constant.ID_FRUTAS, FACIL);

		/** Figuras */
		insertPalabra(db, "Rectangulo", "Esta Figura tiene la misma forma que una cancha de futbol", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Cuadrado", "Figura que tiene cuatro lados y termina en do", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Triangulo", "Figura que tiene  tres lados y comienza por tri", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Circulo", "Figura que es igual a la forma de la luna", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Estrella", "Las puedes encontrar tanto en el cielo como en el mar", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Rombo", ": Es igual a un papagayos", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Ovalo", "Parece un globo cuando lo llenas", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Cubo", "Una caja cuadrada de regalo", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Esfera", "Tiene la misma forma que el planeta tierra y contiene una f", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Elipse", "Como un huevo de gallina y tiene una p", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Circunferencia", "Figura que es igual a la rueda de la bicicleta y tiene tres c y a", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Parabola", "Figura que tiene la misma forma que una C y tiene 3 a", Constant.ID_FIGURAS, FACIL);
		insertPalabra(db, "Cono", "Tiene la misma forma que un arbol de pino", Constant.ID_FIGURAS, FACIL);

		/** Cosas o articulos */
		insertPalabra(db, "Cocina", "Lugar donde preparas la comida", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Fregadero", "Lugar donde lavan los platos despues de comer", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Cafetera", "Aparato para hacer el cafe.", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Olla", "Objetos pequeños donde calientas agua", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Cubiertos", "Los necesitas para comer(Cuchara, tenedor, cuchillo)", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Platos", "Donde sirven la comida", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Vaso", "Sirves el agua para beber", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Mesa", "Se sienta toda la familia junta", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Televisor", "Para ver los dibujos animados y peliculas", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Radio", "Para escuchar musica", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Computadora", "Hacer la tarea en internet y jugar videos juegos", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Silla", "Te sientas en ella", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Telefono", "Sirve para hacer llamadas y mandar mensajes", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Espejo", "Siempre te ves en el", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Cama", "Duermes todas las noches", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Impresora", "Parte de la computadora, sirve para imprimir trabajos", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Abrelatas", "Sirve para abrir latas", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Lavadora", "Objeto de gran tamaño para lava la ropa", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Secadora", "Objeto de gran tamaño para seca la ropa", Constant.ID_ARTICULOS, FACIL);
		insertPalabra(db, "Trapeador", "Sirve para trapear la casa", Constant.ID_ARTICULOS, FACIL);
		 
		/** Paises*/
		insertPalabra(db, "Venezuela", "Es un pais de America del Sur, tiene el Salto del angel, el salto de agua mas grande del mundo.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Armenia", "Pais europeo, su idioma es armenio.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Afganistan", "Pais asiatico que comienza con Afga.,", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Bulgaria", "Es un pais europeo, su idioma es el bulgaro.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Bahamas", "Pertenece al mar Caribe, su gentilicio es bahames.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Bielorrusia", "Pais europeo, comienza con Bielo.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Croacia", "Pais europeo, su gentilicio es croata.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Eslovaquia", "Pais europeo, su idioma es el eslovaco.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Eslovenia", "Pais europeo, su idioma es el esloveno.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Estonia", "Es un pais europeo, su idioma es el estonio.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Filipinas", "Pais asiatico, su gentilicio es filipino.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Guatemala", "Su gentilicio es guatemalteco.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Hungria", "Pais europeo, su idioma es hungaro.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "India", "Femenino de Indio.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Italia", "Tiene forma de bota.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Ucrania", "Pais europeo, su idioma es ucraniano.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Madagascar", "Existe una pelicula animada ambientada en esta isla de africa.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Portugal", "Hablan portugues.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Islandia", "Pais europeo, su idioma es islandes.", Constant.ID_PAISES, FACIL);
		insertPalabra(db, "Mongolia", "Pais asiatico, su idioma es el mongol.", Constant.ID_PAISES, FACIL);
			 
	}

	@Override
	public void onUpgrade(SQLiteDatabase db,  int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		if (newVersion > oldVersion	){
			db.execSQL( "DROP TABLE IF EXISTS " + CRUS_HEAD);
			onCreate(db);
		}		
	}
	
    private void insertPalabra(SQLiteDatabase database, String palabra, String pis, int categoria, int dif){
        database.execSQL("INSERT INTO "+CRUS_HEAD+
                " ("+PALABRA+","+PISTA+","+CATEGORIA+","+DIFICULTAD+","+FALLOS+") " +
                " VALUES ('" + palabra + "', '" + pis + "', " + categoria +", " + dif + ", 7);");       
    }    
    
    
    public void insertPalabra(Palabras p) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PALABRA, p.getPalabra());
        values.put(PISTA, p.getPista());
        values.put(CATEGORIA, p.getCategoria());
        values.put(DIFICULTAD, p.getDificultad());
        values.put(FALLOS, 7);

        if(database.insert(CRUS_HEAD, null , values) == -1){
            database.close();
            throw new RuntimeException("No se ha podido insertar la palabra en la base de datos");
        }

        database.close();
    }  
    
    public void updatePalabra(int id, int fallos) {
        SQLiteDatabase database = this.getReadableDatabase();

        String query =
                "UPDATE "+CRUS_HEAD+
                " SET " + FALLOS + "=" + fallos +
                " WHERE id=" + id + ";";
        database.execSQL(query);

        database.close();
    }    
    
    @SuppressWarnings("unused")
	private void doReset(SQLiteDatabase database){
        database.execSQL("DROP TABLE IF EXISTS " + CRUS_HEAD);
        onCreate(database);
    }

    public Palabras queryPalabraAleatoria() {

        Palabras palabra = null;

        SQLiteDatabase database = this.getReadableDatabase();

        String query = "SELECT * FROM " + CRUS_HEAD +" ORDER BY RANDOM() LIMIT 1;";

        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()){

            palabra = new Palabras(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex(PALABRA)),
                    cursor.getString(cursor.getColumnIndex(PISTA)),                    
                    cursor.getInt(cursor.getColumnIndex(CATEGORIA)),                    
                    cursor.getInt(cursor.getColumnIndex(DIFICULTAD)));
        }

        cursor.close();
        database.close();

        return palabra;
    } 
         
    public Palabras queryPalabraAleatoria(int nivel, boolean acumulativo) {

        Palabras palabra = null;
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + CRUS_HEAD +
                " WHERE "+SQLite.DIFICULTAD + (acumulativo?"<=":"=") + nivel +
                " ORDER BY "+FALLOS+" DESC, RANDOM() LIMIT 1;";

        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()){
            palabra = new Palabras(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex(PALABRA)),
                    cursor.getString(cursor.getColumnIndex(PISTA)),                     
                    cursor.getInt(cursor.getColumnIndex(CATEGORIA)),                      
                    cursor.getInt(cursor.getColumnIndex(DIFICULTAD)));
        }

        cursor.close();
        database.close();

        return palabra;
    }  
    
    public Palabras queryPalabraAleatoria(int nivel, boolean acumulativo, int cat) {

        Palabras palabra = null;
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + CRUS_HEAD +
                " WHERE "+ CATEGORIA + " = " + cat + " AND "+ DIFICULTAD + (acumulativo?" <=":" =") + nivel + 
                " ORDER BY " + FALLOS+" DESC, RANDOM() LIMIT 1;";

        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()){

            palabra = new Palabras(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex(PALABRA)),
                    cursor.getString(cursor.getColumnIndex(PISTA)),                     
                    cursor.getInt(cursor.getColumnIndex(CATEGORIA)),                      
                    cursor.getInt(cursor.getColumnIndex(DIFICULTAD)));
        }

        cursor.close();
        database.close();

        return palabra;
    }     
    
       
}//end class
