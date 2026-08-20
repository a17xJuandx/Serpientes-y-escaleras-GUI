/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serpientesyescalerasfinal;

import javax.swing.JFrame;

/**
 *
 * @author a17x_
 */
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class VentanaEstadisticas extends JFrame {

    private Juego juego;
    private Map<String, Color> mapaColores;

    public VentanaEstadisticas(Juego juego) {
        this.juego = juego;
        inicializarMapaColores();

        setTitle("Estadisticas - Serpientes y Escaleras");
        setSize(620, 580);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(250, 248, 242));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // --- Título ---
        JLabel lblTitulo = new JLabel("Estadisticas de la Partida", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(60, 60, 60));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));

        // --- Estado de la partida ---
        String estadoTexto = juego.isHayGanador() ? "Partida finalizada" : "Partida en curso";
        JLabel lblEstado = new JLabel(estadoTexto, SwingConstants.CENTER);
        lblEstado.setFont(new Font("Georgia", Font.ITALIC, 14));
        lblEstado.setForeground(juego.isHayGanador() ? new Color(46, 139, 87) : new Color(180, 100, 0));
        lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblEstado);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        // --- Clasificación por posición ---
        JPanel panelClasificacion = crearPanelClasificacion();
        panelClasificacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(panelClasificacion);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));

        // --- Jugadores ordenados por edad ---
        JPanel panelEdad = crearPanelEdad();
        panelEdad.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(panelEdad);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));

        // --- Resumen general ---
        JPanel panelResumen = crearPanelResumen();
        panelResumen.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(panelResumen);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        // --- Botón cerrar ---
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Georgia", Font.BOLD, 14));
        btnCerrar.setBackground(new Color(180, 210, 240));
        btnCerrar.setForeground(new Color(40, 40, 40));
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setMaximumSize(new Dimension(160, 38));
        btnCerrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelPrincipal.add(btnCerrar);

        JScrollPane scroll = new JScrollPane(panelPrincipal);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(12);
        add(scroll);
    }

    // Panel con la clasificación de jugadores por posición en el tablero
    private JPanel crearPanelClasificacion() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(250, 248, 242));
        panel.setMaximumSize(new Dimension(560, 999));

        TitledBorder borde = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            "Clasificacion por Posicion",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Georgia", Font.BOLD, 13),
            new Color(60, 60, 60)
        );
        panel.setBorder(borde);

        Jugador[] clasificacion = juego.getClasificacion();

        for (int i = 0; i < clasificacion.length; i++) {
            Jugador j = clasificacion[i];
            JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 4));
            fila.setBackground(i % 2 == 0 ? new Color(245, 245, 240) : new Color(255, 255, 255));
            fila.setMaximumSize(new Dimension(560, 36));

            // Indicador de posición/ganador
            String medallon;
            if (i == 0 && juego.isHayGanador()) {
                medallon = "1°";
            } else {
                medallon = (i + 1) + "°";
            }
            JLabel lblPos = new JLabel(medallon);
            lblPos.setFont(new Font("Arial", Font.BOLD, 13));
            lblPos.setPreferredSize(new Dimension(45, 25));

            // Ficha de color
            JPanel ficha = new JPanel();
            ficha.setPreferredSize(new Dimension(18, 18));
            ficha.setBackground(mapaColores.getOrDefault(j.getColor(), Color.GRAY));
            ficha.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

            JLabel lblInfo = new JLabel(j.getNombre() + "  —  Casilla: " + j.getPosicion());
            lblInfo.setFont(new Font("Georgia", Font.PLAIN, 13));

            fila.add(lblPos);
            fila.add(ficha);
            fila.add(lblInfo);
            panel.add(fila);
        }

        return panel;
    }

    // Panel con jugadores ordenados por edad
    private JPanel crearPanelEdad() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(250, 248, 242));
        panel.setMaximumSize(new Dimension(560, 999));

        TitledBorder borde = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            "Jugadores por Edad (menor a mayor)",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Georgia", Font.BOLD, 13),
            new Color(60, 60, 60)
        );
        panel.setBorder(borde);

        Jugador[] porEdad = juego.getJugadoresOrdenadosPorEdad();

        for (int i = 0; i < porEdad.length; i++) {
            Jugador j = porEdad[i];
            JPanel fila = new JPanel(new BorderLayout(8, 0));
            fila.setBackground(i % 2 == 0 ? new Color(245, 245, 240) : new Color(255, 255, 255));
            fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));
            fila.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));

            JPanel ficha = new JPanel();
            ficha.setPreferredSize(new Dimension(18, 18));
            ficha.setMaximumSize(new Dimension(18, 18));
            ficha.setBackground(mapaColores.getOrDefault(j.getColor(), Color.GRAY));
            ficha.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

            char generoSimbolo = j.getGenero() == 'F' ? 'F' : 'M';
            JLabel lblInfo = new JLabel(
                j.getNombre() + "  |" + generoSimbolo + "  —  " + j.getEdad() + " años  —  Color: " + j.getColor()
            );
            lblInfo.setFont(new Font("Georgia", Font.PLAIN, 13));

            fila.add(ficha, BorderLayout.WEST);
            fila.add(lblInfo, BorderLayout.CENTER);
            panel.add(fila);
        }

        return panel;
    }

    // Panel con resumen numérico general
    private JPanel crearPanelResumen() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 6));
        panel.setBackground(new Color(250, 248, 242));
        panel.setMaximumSize(new Dimension(560, 999));

        TitledBorder borde = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            "Resumen General",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Georgia", Font.BOLD, 13),
            new Color(60, 60, 60)
        );
        panel.setBorder(borde);

        Jugador[] jugadores = juego.getJugadores();

        // Calcular estadísticas
        int edadMin = jugadores[0].getEdad();
        int edadMax = jugadores[0].getEdad();
        int sumEdad = 0;
        int posMax  = jugadores[0].getPosicion();
        String lider = jugadores[0].getNombre();

        for (Jugador j : jugadores) {
            sumEdad += j.getEdad();
            if (j.getEdad() < edadMin) edadMin = j.getEdad();
            if (j.getEdad() > edadMax) edadMax = j.getEdad();
            if (j.getPosicion() > posMax) {
                posMax = j.getPosicion();
                lider  = j.getNombre();
            }
        }
        double promedioEdad = (double) sumEdad / jugadores.length;

        agregarFila(panel, "Total de jugadores:", String.valueOf(jugadores.length));
        agregarFila(panel, "Turno actual:", String.valueOf(juego.getTurno() + 1));
        agregarFila(panel, "Lider del tablero:", lider + " (casilla " + posMax + ")");
        agregarFila(panel, "Edad minima:", edadMin + " años");
        agregarFila(panel, "Edad maxima:", edadMax + " años");
        agregarFila(panel, "Edad promedio:", String.format("%.1f años", promedioEdad));
        agregarFila(panel, "Hay ganador:", juego.isHayGanador() ? "Si" : "No");

        return panel;
    }

    private void agregarFila(JPanel panel, String etiqueta, String valor) {
        JLabel lbl = new JLabel(etiqueta);
        lbl.setFont(new Font("Georgia", Font.BOLD, 13));
        lbl.setForeground(new Color(80, 80, 80));

        JLabel val = new JLabel(valor);
        val.setFont(new Font("Georgia", Font.PLAIN, 13));
        val.setForeground(new Color(40, 40, 40));

        panel.add(lbl);
        panel.add(val);
    }

    private void inicializarMapaColores() {
        mapaColores = new HashMap<>();
        mapaColores.put("Rojo",     Color.RED);
        mapaColores.put("Azul",     Color.BLUE);
        mapaColores.put("Blanco",   Color.WHITE);
        mapaColores.put("Verde",    Color.GREEN);
        mapaColores.put("Rosa",     new Color(255, 20, 147));
        mapaColores.put("Morado",   new Color(128, 0, 128));
        mapaColores.put("Amarillo", Color.YELLOW);
        mapaColores.put("Negro",    Color.BLACK);
    }
}
