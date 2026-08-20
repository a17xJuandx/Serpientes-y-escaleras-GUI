/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VentanaJuego extends JFrame {

    private Juego juego;
    private JPanel panelTablero;
    private JPanel[] celdas;
    private JLabel lblTurno;
    private JLabel lblDado;
    private JButton btnTirarDado;
    private JButton btnVolver;
    private JPanel cuadritoColor;
    private JLabel lblMensaje;
    private Map<String, Color> mapaColores;
    private VentanaMenu ventanaMenu;

    public VentanaJuego(int totalJugadores, ArrayList<String> nombres, ArrayList<Character> generos,
                         ArrayList<Integer> edades, ArrayList<String> colores, int tableroSeleccionado,
                         VentanaMenu ventanaMenu) {

        this.ventanaMenu = ventanaMenu;

        Jugador[] jugadores = new Jugador[totalJugadores];
        for (int i = 0; i < totalJugadores; i++) {
            jugadores[i] = new Jugador(nombres.get(i), generos.get(i), edades.get(i), colores.get(i));
        }

        juego = new Juego(jugadores, tableroSeleccionado);

        inicializarMapaColores();

        setTitle("Serpientes y Escaleras - Tablero");
        setSize(950, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(250, 248, 242));

        // ---- Panel del tablero (8x8) ----
        panelTablero = new JPanel(new GridLayout(8, 8, 0, 0));
        panelTablero.setBackground(new Color(250, 248, 242));
        panelTablero.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        celdas = new JPanel[64];
        construirTablero();
        add(panelTablero, BorderLayout.CENTER);

        // ---- Panel lateral derecho ----
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setBorder(BorderFactory.createEmptyBorder(20, 15, 30, 15));
        panelLateral.setPreferredSize(new Dimension(230, 0));
        panelLateral.setBackground(new Color(250, 248, 242));

        // --- Título del turno ---
        JLabel lblTituloTurno = new JLabel("Turno de:");
        lblTituloTurno.setFont(new Font("Georgia", Font.ITALIC, 15));
        lblTituloTurno.setForeground(new Color(160, 160, 160));
        lblTituloTurno.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --- Nombre del jugador ---
        lblTurno = new JLabel("...");
        lblTurno.setFont(new Font("Palatino Linotype", Font.BOLD, 28));
        lblTurno.setForeground(new Color(40, 40, 40));
        lblTurno.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        cuadritoColor = new JPanel();
        cuadritoColor.setPreferredSize(new Dimension(44, 44));
        cuadritoColor.setMaximumSize(new Dimension(44, 44));
        cuadritoColor.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 2));
        cuadritoColor.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        lblDado = new JLabel("?");
        lblDado.setFont(new Font("Palatino Linotype", Font.BOLD, 80));
        lblDado.setForeground(new Color(60, 60, 60));
        lblDado.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblDadoTexto = new JLabel("ultimo dado");
        lblDadoTexto.setFont(new Font("Georgia", Font.ITALIC, 13));
        lblDadoTexto.setForeground(new Color(190, 190, 190));
        lblDadoTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lblMensaje = new JLabel(" ");
        lblMensaje.setFont(new Font("Georgia", Font.BOLD, 16));
        lblMensaje.setForeground(new Color(90, 90, 90));
        lblMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMensaje.setHorizontalAlignment(JLabel.CENTER);

        // --- Botones ---
        btnTirarDado = new JButton("Tirar Dado");
        btnTirarDado.setFont(new Font("Georgia", Font.BOLD, 15));
        btnTirarDado.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTirarDado.setMaximumSize(new Dimension(190, 50));
        btnTirarDado.setBackground(new Color(180, 210, 240));
        btnTirarDado.setForeground(new Color(40, 40, 40));
        btnTirarDado.setFocusPainted(false);
        btnTirarDado.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        btnTirarDado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panelLateral.add(btnTirarDado);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 25)));
        panelLateral.add(lblMensaje);
        panelLateral.add(Box.createVerticalGlue());

        JButton btnEstadisticas = new JButton("Ver Estadisticas");
        btnEstadisticas.setFont(new Font("Georgia", Font.PLAIN, 13));
        btnEstadisticas.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEstadisticas.setMaximumSize(new Dimension(190, 42));
        btnEstadisticas.setFocusPainted(false);
        btnEstadisticas.setBackground(new Color(250, 248, 242));
        btnEstadisticas.setForeground(new Color(140, 140, 140));
        btnEstadisticas.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        btnEstadisticas.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnVolver = new JButton("Volver al Menu");
        btnVolver.setFont(new Font("Georgia", Font.PLAIN, 13));
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setMaximumSize(new Dimension(190, 42));
        btnVolver.setFocusPainted(false);
        btnVolver.setBackground(new Color(250, 248, 242));
        btnVolver.setForeground(new Color(140, 140, 140));
        btnVolver.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // --- Armado del panel ---
        panelLateral.add(Box.createVerticalGlue());
        panelLateral.add(lblTituloTurno);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 8)));
        panelLateral.add(lblTurno);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 14)));
        panelLateral.add(cuadritoColor);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 35)));
        panelLateral.add(lblDado);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 4)));
        panelLateral.add(lblDadoTexto);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 28)));
        panelLateral.add(btnTirarDado);
        panelLateral.add(Box.createVerticalGlue());
        panelLateral.add(btnEstadisticas);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 6)));
        panelLateral.add(btnVolver);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 10)));

        add(panelLateral, BorderLayout.EAST);

        // ---- Evento Tirar Dado ----
        btnTirarDado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarTurno();
            }
        });

        // ---- Evento Ver Estadisticas ----
        btnEstadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaEstadisticas ventanaEst = new VentanaEstadisticas(juego);
                ventanaEst.setVisible(true);
            }
        });

        // ---- Evento Volver al Menu ----
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (ventanaMenu != null) {
                    ventanaMenu.setVisible(true);
                }
            }
        });

        actualizarTurnoLabel();
        actualizarTablero();
    }

    private void inicializarMapaColores() {
        mapaColores = new HashMap<>();
        mapaColores.put("Rojo", Color.RED);
        mapaColores.put("Azul", Color.BLUE);
        mapaColores.put("Blanco", Color.WHITE);
        mapaColores.put("Verde", Color.GREEN);
        mapaColores.put("Rosa", new Color(255, 20, 147));
        mapaColores.put("Morado", new Color(128, 0, 128));
        mapaColores.put("Amarillo", Color.YELLOW);
        mapaColores.put("Negro", Color.BLACK);
    }

    private void construirTablero() {
        Casilla[] casillas = juego.getTablero().getCasillas();

        Color FONDO_BASE     = new Color(255, 250, 220);
        Color SERPIENTE_ROJO = new Color(250, 140, 140);
        Color ESCALERA_VERDE = new Color(160, 230, 160);

        JPanel[] gridVisual = new JPanel[64];

        for (int i = 0; i < 64; i++) {
            JPanel celda = new JPanel();
            celda.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
            celda.setBorder(BorderFactory.createLineBorder(new Color(210, 200, 170)));

            Casilla c = casillas[i];

            Color fondo = FONDO_BASE;
            String etiquetaExtra = "";

            if (c instanceof CasillaEscalera) {
                fondo = ESCALERA_VERDE;
                etiquetaExtra = "Sube a " + ((CasillaEscalera) c).posFinal;
            } else if (c instanceof CasillaSerpiente) {
                fondo = SERPIENTE_ROJO;
                etiquetaExtra = "Baja a " + ((CasillaSerpiente) c).posFinal;
            }

            celda.setBackground(fondo);

            JPanel contenedor = new JPanel(new BorderLayout());
            contenedor.setBackground(fondo);
            contenedor.setBorder(BorderFactory.createLineBorder(new Color(210, 200, 170)));

            JLabel lblNumero = new JLabel(String.valueOf(i), SwingConstants.LEFT);
            lblNumero.setFont(new Font("Georgia", Font.BOLD, 11));
            lblNumero.setForeground(new Color(130, 120, 90));

            if (!etiquetaExtra.isEmpty()) {
                JLabel lblExtra = new JLabel(etiquetaExtra, SwingConstants.RIGHT);
                lblExtra.setFont(new Font("Georgia", Font.BOLD, 9));
                lblExtra.setForeground(new Color(60, 60, 60));
                contenedor.add(lblExtra, BorderLayout.SOUTH);
            }

            contenedor.add(lblNumero, BorderLayout.NORTH);
            contenedor.add(celda, BorderLayout.CENTER);

            gridVisual[i] = contenedor;
            celdas[i] = celda;
        }

        for (int fila = 7; fila >= 0; fila--) {
            int filaDesdeAbajo = 7 - fila;

            if (filaDesdeAbajo % 2 == 0) {
                for (int c = 0; c < 8; c++) {
                    int numCasilla = filaDesdeAbajo * 8 + c;
                    panelTablero.add(gridVisual[numCasilla]);
                }
            } else {
                for (int c = 7; c >= 0; c--) {
                    int numCasilla = filaDesdeAbajo * 8 + c;
                    panelTablero.add(gridVisual[numCasilla]);
                }
            }
        }
    }

    private void actualizarTablero() {
        for (JPanel celda : celdas) {
            celda.removeAll();
        }

        for (Jugador j : juego.getJugadores()) {
            int pos = j.getPosicion();
            JPanel celda = celdas[pos];

            JPanel ficha = new JPanel();
            ficha.setPreferredSize(new Dimension(20, 20));
            Color colorFicha = mapaColores.getOrDefault(j.getColor(), Color.GRAY);
            ficha.setBackground(colorFicha);
            ficha.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            ficha.setToolTipText(j.getNombre());

            celda.add(ficha);
        }

        panelTablero.revalidate();
        panelTablero.repaint();
    }

    private void actualizarTurnoLabel() {
        Jugador actual = juego.getJugadores()[juego.getTurno()];
        lblTurno.setText(actual.getNombre());
        Color colorJugador = mapaColores.getOrDefault(actual.getColor(), Color.GRAY);
        cuadritoColor.setBackground(colorJugador);
    }

    private void jugarTurno() {
    if (juego.isHayGanador()) {
        return;
    }

    String resultado = juego.hacerJugada();
    lblDado.setText(String.valueOf(juego.getUltimoDado()));

    actualizarTablero();
    lblMensaje.setText("<html><center>" + resultado.replace("\n", "<br>") + "</center></html>");

    if (juego.isHayGanador()) {
        btnTirarDado.setEnabled(false);
        return;
    }

    actualizarTurnoLabel();
}

    private void avanzarTurno(int nuevoTurno) {
    juego.setTurno(nuevoTurno);
}
}
