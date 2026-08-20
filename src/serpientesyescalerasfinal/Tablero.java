/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

/**
 *
 * @author a17x_
 */

public class Tablero {
    public static int numTotalCasilla = 64;
    Casilla casillas[] = new Casilla[numTotalCasilla];

    public Casilla[] getCasillas() {
        return casillas;
    }

    
    
public void inicializarTablero(int opcion) {
    for (int i = 0; i < casillas.length; i++) {
        casillas[i] = new CasillaNormal(i);
    }

    switch (opcion) {
        case 1:
            casillas[6]  = new CasillaEscalera(6, 31);
            casillas[10] = new CasillaEscalera(10, 41);
            casillas[22] = new CasillaEscalera(22, 38);
            casillas[35] = new CasillaEscalera(35, 56);
            casillas[40] = new CasillaEscalera(40, 62);
            casillas[48] = new CasillaEscalera(48, 59);
            casillas[33] = new CasillaSerpiente(33, 7);
            casillas[20] = new CasillaSerpiente(20, 4);
            casillas[42] = new CasillaSerpiente(42, 17);
            casillas[55] = new CasillaSerpiente(55, 23);
            casillas[61] = new CasillaSerpiente(61, 43);
            casillas[18] = new CasillaSerpiente(18, 7);
            break;
        case 2:
            casillas[5]  = new CasillaEscalera(5, 25);
            casillas[12] = new CasillaEscalera(12, 40);
            casillas[21] = new CasillaEscalera(21, 39);
            casillas[34] = new CasillaEscalera(34, 50);
            casillas[44] = new CasillaEscalera(44, 62);
            casillas[47] = new CasillaEscalera(47, 58);
            casillas[19] = new CasillaSerpiente(19, 3);
            casillas[28] = new CasillaSerpiente(28, 10);
            casillas[41] = new CasillaSerpiente(41, 20);
            casillas[53] = new CasillaSerpiente(53, 30);
            casillas[59] = new CasillaSerpiente(59, 38);
            casillas[62] = new CasillaSerpiente(62, 15);
            break;
        case 3:
            casillas[3]  = new CasillaEscalera(3, 16);
            casillas[8]  = new CasillaEscalera(8, 29);
            casillas[15] = new CasillaEscalera(15, 37);
            casillas[26] = new CasillaEscalera(26, 45);
            casillas[38] = new CasillaEscalera(38, 52);
            casillas[51] = new CasillaEscalera(51, 61);
            casillas[14] = new CasillaSerpiente(14, 2);
            casillas[24] = new CasillaSerpiente(24, 11);
            casillas[36] = new CasillaSerpiente(36, 13);
            casillas[49] = new CasillaSerpiente(49, 23);
            casillas[57] = new CasillaSerpiente(57, 30);
            casillas[60] = new CasillaSerpiente(60, 42);
            break;
        default:
            casillas[6]  = new CasillaEscalera(6, 31);
            casillas[10] = new CasillaEscalera(10, 41);
            casillas[22] = new CasillaEscalera(22, 38);
            casillas[35] = new CasillaEscalera(35, 56);
            casillas[40] = new CasillaEscalera(40, 62);
            casillas[48] = new CasillaEscalera(48, 59);
            casillas[33] = new CasillaSerpiente(33, 7);
            casillas[20] = new CasillaSerpiente(20, 4);
            casillas[42] = new CasillaSerpiente(42, 17);
            casillas[55] = new CasillaSerpiente(55, 23);
            casillas[61] = new CasillaSerpiente(61, 43);
            casillas[18] = new CasillaSerpiente(18, 7);
            break;
    }
}


    public void mostrarTablero() {
        for (Casilla c : casillas) {
            System.out.println("Posicion: " + c.numCasilla + " | Tipo: " + c.tipo);
            if (c instanceof CasillaEscalera) {
                System.out.println("  Sube a: " + ((CasillaEscalera) c).posFinal);
            } else if (c instanceof CasillaSerpiente) {
                System.out.println("  Baja a: " + ((CasillaSerpiente) c).posFinal);
            }
        }
    }
}
