/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

/**
 *
 * @author a17x_
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaEscogerTablero extends JFrame {

    private int totalJugadores;
    private ArrayList<String> nombres;
    private ArrayList<Character> generos;
    private ArrayList<Integer> edades;
    private ArrayList<String> colores;

    public VentanaEscogerTablero(int totalJugadores, ArrayList<String> nombres, ArrayList<Character> generos, ArrayList<Integer> edades, ArrayList<String> colores) {
        this.totalJugadores = totalJugadores;
        this.nombres = nombres;
        this.generos = generos;
        this.edades = edades;
        this.colores = colores;

        setTitle("Seleccion de Tablero");
        setSize(600, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(250, 248, 242));
        this.getContentPane().add(panel);

        JLabel lblTitulo = new JLabel("Elige tu Tablero", SwingConstants.CENTER);
        lblTitulo.setBounds(30, 20, 530, 38);
        lblTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 26));
        lblTitulo.setForeground(new Color(60, 60, 60));
        panel.add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Cada camino tiene sus riesgos...", SwingConstants.CENTER);
        lblSubtitulo.setBounds(30, 58, 530, 25);
        lblSubtitulo.setFont(new Font("Georgia", Font.ITALIC, 14));
        lblSubtitulo.setForeground(new Color(46, 139, 87));
        panel.add(lblSubtitulo);

        JButton btnTablero1 = new JButton("<html><center><b>El Jardin</b><br><br><i>Para los que recien empiezan</i></center></html>");
        btnTablero1.setBounds(30, 110, 160, 180);
        btnTablero1.setFont(new Font("Georgia", Font.PLAIN, 13));
        btnTablero1.setBackground(new Color(220, 240, 220));
        btnTablero1.setFocusPainted(false);
        btnTablero1.setBorderPainted(false);
        btnTablero1.setActionCommand("El Jardin");
        panel.add(btnTablero1);

        JButton btnTablero2 = new JButton("<html><center><b>El Laberinto</b><br><br><i>Un camino lleno de sorpresas</i></center></html>");
        btnTablero2.setBounds(210, 110, 160, 180);
        btnTablero2.setFont(new Font("Georgia", Font.PLAIN, 13));
        btnTablero2.setBackground(new Color(220, 230, 245));
        btnTablero2.setFocusPainted(false);
        btnTablero2.setBorderPainted(false);
        btnTablero2.setActionCommand("El Laberinto");
        panel.add(btnTablero2);

        JButton btnTablero3 = new JButton("<html><center><b>El Abismo</b><br><br><i>No apto para corazones debiles</i></center></html>");
        btnTablero3.setBounds(390, 110, 160, 180);
        btnTablero3.setFont(new Font("Georgia", Font.PLAIN, 13));
        btnTablero3.setBackground(new Color(245, 220, 220));
        btnTablero3.setFocusPainted(false);
        btnTablero3.setBorderPainted(false);
        btnTablero3.setActionCommand("El Abismo");
        panel.add(btnTablero3);

        ActionListener accionTablero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comando = e.getActionCommand();
                int tableroSeleccionado = 1;

                if (comando.contains("Laberinto")) {
                    tableroSeleccionado = 2;
                } else if (comando.contains("Abismo")) {
                    tableroSeleccionado = 3;
                }

                JOptionPane.showMessageDialog(null, "Has seleccionado el Tablero Tipo " + tableroSeleccionado);
                VentanaMenu menu = new VentanaMenu(totalJugadores, nombres, generos, edades, colores, tableroSeleccionado);
                menu.setVisible(true);
                dispose();
            }
        };

        btnTablero1.addActionListener(accionTablero);
        btnTablero2.addActionListener(accionTablero);
        btnTablero3.addActionListener(accionTablero);
    }
}