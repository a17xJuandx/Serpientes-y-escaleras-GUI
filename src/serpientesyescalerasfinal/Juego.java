/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

/**
 *
 * @author a17x_
 */
public class Juego {
    private Tablero tablero;
    private int numJugadores;
    private Jugador[] jugadores;
    private int turno = 0;
    private boolean hayGanador = false;

    public Juego(Jugador[] jugadores, int tableroSeleccionado) {
        this.numJugadores = jugadores.length;
        this.jugadores = jugadores;
        this.tablero = new Tablero();
        this.tablero.inicializarTablero(tableroSeleccionado);
    }
    private int ultimoDado;

    public int getUltimoDado() {
    return ultimoDado;
    }   
    public Jugador[] getJugadores() {
        return jugadores;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isHayGanador() {
        return hayGanador;
    }

    public void setHayGanador(boolean hayGanador) {
        this.hayGanador = hayGanador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Ejecuta la jugada de un turno dado y devuelve un mensaje con lo que ocurrió.
     * Retorna null si ya hay ganador.
     */
    public String hacerJugada() {
        if (hayGanador) return null;

        Jugador p = jugadores[turno];
        int dado = p.tirarDado();
        ultimoDado = dado;
        int nuevaPosicion = p.getPosicion() + dado;
        if (nuevaPosicion > Tablero.numTotalCasilla - 1) {
            nuevaPosicion = Tablero.numTotalCasilla - 1;
        }
        p.setPosicion(nuevaPosicion);

        Casilla casillaActual = tablero.getCasillas()[p.getPosicion()];
        String mensajeExtra = "";

        if (casillaActual instanceof CasillaEscalera) {
            CasillaEscalera escalera = (CasillaEscalera) casillaActual;
            mensajeExtra = p.getNombre() + " subio por una escalera hasta la casilla " + escalera.posFinal + "!";
            p.setPosicion(escalera.posFinal);
        } else if (casillaActual instanceof CasillaSerpiente) {
            CasillaSerpiente serpiente = (CasillaSerpiente) casillaActual;
            mensajeExtra = p.getNombre() + " cayo en una serpiente y bajo a la casilla " + serpiente.posFinal + "!";
            p.setPosicion(serpiente.posFinal);
        }

        String resultado = "Turno de " + p.getNombre() + " - Dado: " + dado;
        if (!mensajeExtra.isEmpty()) {
            resultado += "\n" + mensajeExtra;
        }

        if (p.getPosicion() >= Tablero.numTotalCasilla - 1) {
            hayGanador = true;
            resultado += "\n¡FELICIDADES " + p.getNombre() + "! ¡HAS GANADO LA PARTIDA!";
        } else {
            turno = (turno + 1) % jugadores.length;
        }

        return resultado;
    }

    /**
     * Devuelve los jugadores ordenados por posición (de mayor a menor) sin modificar el arreglo original.
     */
    public Jugador[] getClasificacion() {
        Jugador[] copia = new Jugador[jugadores.length];
        for (int i = 0; i < jugadores.length; i++) copia[i] = jugadores[i];

        for (int i = 0; i < copia.length; i++) {
            for (int j = 0; j < copia.length - 1; j++) {
                if (copia[j].getPosicion() < copia[j + 1].getPosicion()) {
                    Jugador temp = copia[j];
                    copia[j]     = copia[j + 1];
                    copia[j + 1] = temp;
                }
            }
        }
        return copia;
    }

    /**
     * Devuelve los jugadores ordenados por edad (de menor a mayor) sin modificar el arreglo original.
     */
    public Jugador[] getJugadoresOrdenadosPorEdad() {
        Jugador[] copia = new Jugador[jugadores.length];
        for (int i = 0; i < jugadores.length; i++) copia[i] = jugadores[i];

        for (int i = 0; i < copia.length; i++) {
            for (int j = 0; j < copia.length - 1; j++) {
                if (copia[j].getEdad() > copia[j + 1].getEdad()) {
                    Jugador temp  = copia[j];
                    copia[j]      = copia[j + 1];
                    copia[j + 1]  = temp;
                }
            }
        }
        return copia;
    }
}

