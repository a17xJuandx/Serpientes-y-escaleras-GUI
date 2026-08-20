/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

/**
 *
 * @author a17x_
 */
public class CasillaEscalera extends Casilla{
    
    int posFinal;

    public CasillaEscalera(int numCasilla,int posFinal) {
        super(numCasilla,"Escalera");
        this.posFinal = posFinal;
    }
    
}
