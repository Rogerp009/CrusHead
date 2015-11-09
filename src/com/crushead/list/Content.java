package com.crushead.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Content {
	
	/**guarda las entradas de la lista.*/
	public static ArrayList<ListEntry> LIST = new ArrayList<ListEntry>();
	
	/**asigna el identificador a cada entrada de la lista*/
	public static Map<String, ListEntry> LIST_HASHMAP = new HashMap<String, ListEntry>();

	/** crear estáticamente estructura list */
	static {
		addEntry(new ListEntry(com.crushead.utils.Constant.ANIMALES, "Animales", ""));
		addEntry(new ListEntry(com.crushead.utils.Constant.FRUTAS, "Frutas", ""));		
		addEntry(new ListEntry(com.crushead.utils.Constant.FIGURAS, "Figuras Geométricas", ""));
		addEntry(new ListEntry(com.crushead.utils.Constant.ARTICULOS, "Cosas del Hogar", ""));
	}

	
	/** Añade una entrada a la lista
	 * @param entrada Elemento que añadimos a la lista
	 */
	private static void addEntry(ListEntry entrada) {
		LIST.add(entrada);
		LIST_HASHMAP.put(entrada.id, entrada);
	}
	
	/**
	 * Representa una entrada del contenido de la lista
	 */
	public static class ListEntry {
		/** var */
		public String id;
		public String title; 
		public String subtitle;
		
		/** Constructor*/
		public ListEntry (String id, String title, String subtitle) { 
			this.id = id;
		    this.title = title;
		    this.subtitle = subtitle;
		}
	}
}//end Class
