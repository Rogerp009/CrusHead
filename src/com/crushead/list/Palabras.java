package com.crushead.list;

public class Palabras {
	
    private int id;
    public String palabra;
    public String pista;    
    private int dificultad;
    private int categoria;
    
    public Palabras(int id, String palabra, String pista, int categoria, int dificultad) {
        this.id = id;
        this.palabra = palabra.toLowerCase();
        this.dificultad = dificultad;
        this.categoria = categoria;
        this.pista = pista;
    }
    
    public int getId() {
        return id;
    }

    public int getDificultad() {
        return dificultad;
    }
    
    public int getCategoria() {
        return categoria;
    }
    
    public String getPalabra() {
        return palabra;
    }
    public String getPista() {
        return pista;
    }
    
    public void setPalabra(String palabra) {
        this.palabra = palabra.toLowerCase();
    }
    
    public void setPista(String pista) {
        this.pista = pista.toLowerCase();
    }
    
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}//end class
