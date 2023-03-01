package com.example.tresenratlla2.tresEnRatllaAPI;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class TresEnRatllaAPI {
    private String[] graella;
    private Jugador jugador1;
    private Jugador jugador2;
    //Jugador del torn actual.
    private Jugador jugadorDelTorn;
    //Nombre de fitxes que poden ser tirades
    private int numJugadesPossibles;
    //Conjunt de combinacions guanyadores
    private ArrayList<Integer[]> posicionsGuanyadores;

    public Jugador getJugadorDelTorn() {
        return jugadorDelTorn;
    }

    public TresEnRatllaAPI() {
        this.graella = new String[9];
        this.numJugadesPossibles = 3;
        this.posicionsGuanyadores = new ArrayList<>();
        //Combinacions guanyadores
        this.posicionsGuanyadores.add(new Integer[]
                {
                        0, 1, 2
                });
        this.posicionsGuanyadores.add(new Integer[]
                {
                        3, 4, 5
                });
        this.posicionsGuanyadores.add(new Integer[]
                {
                        6, 7, 8
                });
        this.posicionsGuanyadores.add(new Integer[]
                {
                        0, 3, 6
                });
        this.posicionsGuanyadores.add(new Integer[]
                {
                        1, 4, 7
                });
        this.posicionsGuanyadores.add(new Integer[]
                {
                        2, 5, 8
                });
        this.posicionsGuanyadores.add(new Integer[]
                {
                        0, 4, 8
                });
        this.posicionsGuanyadores.add(new Integer[]
                {
                        2, 4, 6
                });
    }

    /** Reparteix fitxes al principi del joc de forma aleatòria
     *
     */
    public void reparteixFitxes() {
        jugador1 = new Jugador("Jugador 1", caraoCreu());
        if (jugador1.getFitxa().equals("x")) {
            jugador2 = new Jugador("Jugador 2", "o");
        } else {
            jugador2 = new Jugador("Jugador 2", "x");
        }
        this.jugadorDelTorn = jugador1;
    }

    /** El jugador tira una fitxa a la graella
     *
     */
    public void tiraFitxa(Jugador jugador, int posicioTirada) {
        this.graella[posicioTirada] = jugador.getFitxa();
        jugador.setUltimaPosicioTirada(posicioTirada);
        jugador.setFitxesTirades(jugador.getFitxesTirades()+1);
    }

    /** Canvia el torn del jugador. Si és "x" el canvia a "o" i a la inversa
     *
     */
    public void canviaTornJugador() {
        if (jugadorDelTorn == jugador1) {
            jugadorDelTorn = jugador2;
        } else {
            jugadorDelTorn = jugador1;
        }
    }

    /**
     * @return Retorna true si el jugador ha esgotat les jugades
     */
    public boolean jugadorHaEsgotatLesJugades() {
        if (jugadorDelTorn.getFitxesTirades() >= numJugadesPossibles) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return Retorna true si la casella a la posicioTirada ja està ocupada
     */
    public boolean casellaOcupada(int posicioTirada) {
        if (this.graella[posicioTirada] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return Retorna true si un jugador ha guanyat la partida
     */
    public boolean hiHaGuanyador() {
        if (jugadorHaGuanyat(jugador1) || jugadorHaGuanyat(jugador2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param jugador Jugador que s'evaluarà si ha guanyat la partida
     * @return Retorna true si el jugador introduit ha guanyat la partida
     */
    private boolean jugadorHaGuanyat(Jugador jugador) {
        for (Integer[] pos : this.posicionsGuanyadores) {
            if (comparaPosicions(pos, jugador)) {
                return true;
            }
        }
        return false;
    }

    private boolean comparaPosicions(Integer[] pos, Jugador jugador) {
        for (Integer p : pos) {
            if (this.graella[p] == null || !this.graella[p].equals(jugador.getFitxa())) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return Retorna true si hi ha empat
     */
    public boolean hiHaEmpat() {
        if(!hiHaGuanyador()) {
            if (jugador1.getFitxesTirades() >= 3 && jugador2.getFitxesTirades() >= 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return Retorna el jugador que ha guanyat la partida, en cas que hi hagi guanyador
     */
    public Jugador guanyadorPartida() {
        if (hiHaGuanyador()) {
            if (jugadorHaGuanyat(jugador1)) {
                return jugador1;
            }
            if (jugadorHaGuanyat(jugador2)) {
                return jugador2;
            }
        }
        return null;
    }

    /**
     * @return Retorna "x" o "o" de forma aleatòria
     */
    private String caraoCreu() {
        boolean cara = new Random().nextBoolean();
        if (cara) {
            return "o";
        } else {
            return "x";
        }
    }
}
