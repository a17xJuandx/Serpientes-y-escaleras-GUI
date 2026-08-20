/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJugar extends JFrame {
    private JLabel lblTitulo;
    private JLabel lblSubtitulo;
    private JLabel lblInstruccion;
    private JComboBox<Integer> comboJugadores;
    private JButton btnSiguiente;

    public VentanaJugar() {
        setTitle("Serpientes y Escaleras");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(250, 248, 242));
        this.getContentPane().add(panel);

        lblTitulo = new JLabel("Serpientes y Escaleras", SwingConstants.CENTER);
        lblTitulo.setBounds(30, 30, 350, 40);
        lblTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 26));
        lblTitulo.setForeground(new Color(60, 60, 60));
        panel.add(lblTitulo);

        lblSubtitulo = new JLabel("Bienvenido!", SwingConstants.CENTER);
        lblSubtitulo.setBounds(30, 72, 350, 25);
        lblSubtitulo.setFont(new Font("Georgia", Font.ITALIC, 15));
        lblSubtitulo.setForeground(new Color(46, 139, 87));
        panel.add(lblSubtitulo);

        lblInstruccion = new JLabel("Numero de jugadores:", SwingConstants.CENTER);
        lblInstruccion.setBounds(30, 140, 350, 25);
        lblInstruccion.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblInstruccion.setForeground(new Color(80, 80, 80));
        panel.add(lblInstruccion);

        Integer[] opciones = {2, 3, 4, 5, 6, 7, 8};
        comboJugadores = new JComboBox<>(opciones);
        comboJugadores.setBounds(130, 172, 150, 30);
        comboJugadores.setFont(new Font("Georgia", Font.PLAIN, 14));
        comboJugadores.setBackground(Color.WHITE);
        panel.add(comboJugadores);

        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(110, 225, 190, 42);
        btnSiguiente.setFont(new Font("Georgia", Font.BOLD, 15));
        btnSiguiente.setBackground(new Color(180, 210, 240));
        btnSiguiente.setForeground(new Color(40, 40, 40));
        btnSiguiente.setFocusPainted(false);
        btnSiguiente.setBorderPainted(false);
        panel.add(btnSiguiente);

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numJugadores = (int) comboJugadores.getSelectedItem();
                VentanaDatos ventanaDatos = new VentanaDatos(numJugadores);
                ventanaDatos.setVisible(true);
                dispose();
            }
        });
    }
}