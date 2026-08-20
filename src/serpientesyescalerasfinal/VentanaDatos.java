/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

/**
 *
 * @author a17x_
 */


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaDatos extends JFrame {

    private int totalJugadores;
    private int jugadorActual = 0;

    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<Character> generos = new ArrayList<>();
    private ArrayList<Integer> edades = new ArrayList<>();
    private ArrayList<String> colores = new ArrayList<>();

    private JLabel lblTituloJugador;
    private JTextField txtNombre, txtEdad;
    private JRadioButton rbtnFemenino, rbtnMasculino;
    private ButtonGroup grupoGenero;
    private JComboBox<String> comboColores;
    private JButton btnRegistrar;

    private String[] listaColores = {"Rojo", "Azul", "Blanco", "Verde", "Rosa", "Morado", "Amarillo", "Negro"};

    public VentanaDatos(int totalJugadores) {
        this.totalJugadores = totalJugadores;

        setTitle("Registro de Jugadores");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(250, 248, 242));
        this.getContentPane().add(panel);

        JLabel lblTitulo = new JLabel("Registro de Jugadores", SwingConstants.CENTER);
        lblTitulo.setBounds(30, 20, 350, 35);
        lblTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(60, 60, 60));
        panel.add(lblTitulo);

        lblTituloJugador = new JLabel("Jugador 1 de " + totalJugadores, SwingConstants.CENTER);
        lblTituloJugador.setBounds(30, 55, 350, 25);
        lblTituloJugador.setFont(new Font("Georgia", Font.ITALIC, 14));
        lblTituloJugador.setForeground(new Color(46, 139, 87));
        panel.add(lblTituloJugador);

        Font fuenteLabel = new Font("Georgia", Font.PLAIN, 14);
        Font fuenteInput = new Font("Georgia", Font.PLAIN, 14);
        Color colorLabel = new Color(80, 80, 80);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 100, 120, 25);
        lblNombre.setFont(fuenteLabel);
        lblNombre.setForeground(colorLabel);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 100, 180, 28);
        txtNombre.setFont(fuenteInput);
        panel.add(txtNombre);

        JLabel lblGenero = new JLabel("Genero:");
        lblGenero.setBounds(40, 148, 120, 25);
        lblGenero.setFont(fuenteLabel);
        lblGenero.setForeground(colorLabel);
        panel.add(lblGenero);

        rbtnMasculino = new JRadioButton("M", true);
        rbtnMasculino.setBounds(170, 148, 60, 25);
        rbtnMasculino.setFont(fuenteInput);
        rbtnMasculino.setBackground(new Color(250, 248, 242));
        panel.add(rbtnMasculino);

        rbtnFemenino = new JRadioButton("F");
        rbtnFemenino.setBounds(235, 148, 60, 25);
        rbtnFemenino.setFont(fuenteInput);
        rbtnFemenino.setBackground(new Color(250, 248, 242));
        panel.add(rbtnFemenino);

        grupoGenero = new ButtonGroup();
        grupoGenero.add(rbtnMasculino);
        grupoGenero.add(rbtnFemenino);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(40, 196, 120, 25);
        lblEdad.setFont(fuenteLabel);
        lblEdad.setForeground(colorLabel);
        panel.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(170, 196, 80, 28);
        txtEdad.setFont(fuenteInput);
        panel.add(txtEdad);

        JLabel lblColor = new JLabel("Color de Ficha:");
        lblColor.setBounds(40, 244, 120, 25);
        lblColor.setFont(fuenteLabel);
        lblColor.setForeground(colorLabel);
        panel.add(lblColor);

        comboColores = new JComboBox<>(listaColores);
        comboColores.setBounds(170, 244, 150, 28);
        comboColores.setFont(fuenteInput);
        comboColores.setBackground(Color.WHITE);
        panel.add(comboColores);

        btnRegistrar = new JButton("Registrar Jugador");
        btnRegistrar.setBounds(100, 300, 210, 42);
        btnRegistrar.setFont(new Font("Georgia", Font.BOLD, 15));
        btnRegistrar.setBackground(new Color(180, 210, 240));
        btnRegistrar.setForeground(new Color(40, 40, 40));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorderPainted(false);
        panel.add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarRegistro();
            }
        });
    }

    private void procesarRegistro() {
        String nombre = txtNombre.getText();
        String edadStr = txtEdad.getText();
        String colorElegido = (String) comboColores.getSelectedItem();

        if (nombre.isEmpty() || edadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        char genero = rbtnMasculino.isSelected() ? 'M' : 'F';

        nombres.add(nombre);
        generos.add(genero);
        edades.add(edad);
        colores.add(colorElegido);

        comboColores.removeItem(colorElegido);
        jugadorActual++;

        if (jugadorActual < totalJugadores) {
            txtNombre.setText("");
            txtEdad.setText("");
            lblTituloJugador.setText("Jugador " + (jugadorActual + 1) + " de " + totalJugadores);
        } else {
            JOptionPane.showMessageDialog(this, "Todos los jugadores han sido registrados con exito!");
            VentanaEscogerTablero ventanaTablero = new VentanaEscogerTablero(totalJugadores, nombres, generos, edades, colores);
            ventanaTablero.setVisible(true);
            dispose();
        }
    }
}