/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

/**
 *
 * @author a17x_
 */
import java.util.Random;

public class Jugador {
    private String nombre;
    private char genero;
    private int edad;
    private int posicion = 0;
    private String color;

    public Jugador(String nombre, char genero, int edad, String color) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad   = edad;
        this.color  = color;
    }

    // GETTERS
    public String getNombre()   { return nombre; }
    public char   getGenero()   { return genero; }
    public int    getEdad()     { return edad; }
    public int    getPosicion() { return posicion; }
    public String getColor()    { return color; }

    // SETTERS
    public void setNombre(String nombre)   { this.nombre = nombre; }
    public void setGenero(char genero)     { this.genero = genero; }
    public void setEdad(int edad)          { this.edad = edad; }
    public void setPosicion(int posicion)  { this.posicion = posicion; }
    public void setColor(String color)     { this.color = color; }

    // DADO ALEATORIO
    public int tirarDado() {
        Random rnd = new Random();
        return rnd.nextInt(6) + 1;  // Valor entre 1 y 6
    }
}
