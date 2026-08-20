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

public class VentanaMenu extends JFrame {

    private JButton botonIniciarJuego;
    private JButton botonEstadisticas;
    private JButton botonSalir;

    private int totalJugadores;
    private ArrayList<String>    nombres;
    private ArrayList<Character> generos;
    private ArrayList<Integer>   edades;
    private ArrayList<String>    colores;
    private int tableroSeleccionado;

    public VentanaMenu(int totalJugadores, ArrayList<String> nombres,
                       ArrayList<Character> generos, ArrayList<Integer> edades,
                       ArrayList<String> colores, int tableroSeleccionado) {

        this.totalJugadores      = totalJugadores;
        this.nombres             = nombres;
        this.generos             = generos;
        this.edades              = edades;
        this.colores             = colores;
        this.tableroSeleccionado = tableroSeleccionado;

        setTitle("Serpientes y Escaleras");
        setSize(420, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(250, 248, 242));
        this.getContentPane().add(panel);

        JLabel lblTitulo = new JLabel("Serpientes y Escaleras", SwingConstants.CENTER);
        lblTitulo.setBounds(30, 30, 350, 40);
        lblTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 26));
        lblTitulo.setForeground(new Color(60, 60, 60));
        panel.add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Menu Principal", SwingConstants.CENTER);
        lblSubtitulo.setBounds(30, 72, 350, 25);
        lblSubtitulo.setFont(new Font("Georgia", Font.ITALIC, 15));
        lblSubtitulo.setForeground(new Color(46, 139, 87));
        panel.add(lblSubtitulo);

        botonIniciarJuego = new JButton("Iniciar Partida");
        botonIniciarJuego.setBounds(110, 130, 190, 46);
        botonIniciarJuego.setFont(new Font("Georgia", Font.BOLD, 15));
        botonIniciarJuego.setBackground(new Color(180, 210, 240));
        botonIniciarJuego.setForeground(new Color(40, 40, 40));
        botonIniciarJuego.setFocusPainted(false);
        botonIniciarJuego.setBorderPainted(false);
        botonIniciarJuego.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(botonIniciarJuego);

        botonEstadisticas = new JButton("Ver Estadisticas");
        botonEstadisticas.setBounds(110, 188, 190, 46);
        botonEstadisticas.setFont(new Font("Georgia", Font.BOLD, 15));
        botonEstadisticas.setBackground(new Color(220, 240, 220));
        botonEstadisticas.setForeground(new Color(40, 40, 40));
        botonEstadisticas.setFocusPainted(false);
        botonEstadisticas.setBorderPainted(false);
        botonEstadisticas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(botonEstadisticas);

        botonSalir = new JButton("Salir");
        botonSalir.setBounds(110, 248, 190, 38);
        botonSalir.setFont(new Font("Georgia", Font.PLAIN, 13));
        botonSalir.setBackground(new Color(250, 248, 242));
        botonSalir.setForeground(new Color(140, 140, 140));
        botonSalir.setFocusPainted(false);
        botonSalir.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));
        botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(botonSalir);

        botonIniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJuego ventanaJuego = new VentanaJuego(
                        totalJugadores, nombres, generos, edades, colores,
                        tableroSeleccionado, VentanaMenu.this);
                ventanaJuego.setVisible(true);
                setVisible(false);
            }
        });

        botonEstadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador[] jugadores = new Jugador[totalJugadores];
                for (int i = 0; i < totalJugadores; i++) {
                    jugadores[i] = new Jugador(nombres.get(i), generos.get(i), edades.get(i), colores.get(i));
                }
                Juego juego = new Juego(jugadores, tableroSeleccionado);
                VentanaEstadisticas ventanaEst = new VentanaEstadisticas(juego);
                ventanaEst.setVisible(true);
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

