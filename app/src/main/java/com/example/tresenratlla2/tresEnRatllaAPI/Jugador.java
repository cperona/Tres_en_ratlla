package com.example.tresenratlla2.tresEnRatllaAPI;

public class Jugador {
    private String nom;
    //La fitxa que està jugant en cada moment. Pot ser "x" o "o".
    private String fitxa;
    //Nombre de fitxes que ha tirat el jugador
    private int fitxesTirades;
    //Ultima posició de la graella tirada
    private int ultimaPosicioTirada;

    public Jugador(String nom, String fitxa) {
        this.nom = nom;
        this.fitxa = fitxa;
        this.fitxesTirades = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFitxa() {
        return fitxa;
    }

    public void setFitxa(String fitxa) {
        this.fitxa = fitxa;
    }

    public int getFitxesTirades() {
        return fitxesTirades;
    }

    public void setFitxesTirades(int fitxesTirades) {
        this.fitxesTirades = fitxesTirades;
    }

    public int getUltimaPosicioTirada() {
        return ultimaPosicioTirada;
    }

    public void setUltimaPosicioTirada(int ultimaPosicioTirada) {
        this.ultimaPosicioTirada = ultimaPosicioTirada;
    }
}
