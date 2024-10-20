package appThreads;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame {
    public MarcoRebote() {
        setBounds(600, 300, 400, 350);
        LaminaPelota lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);

        // Panel para los botones de los hilos (parte superior)
        JPanel laminaBotonesHilos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio alrededor de los botones y márgenes
        
        // Botones para iniciar los hilos
        JButton hilo1 = new JButton("Hilo 1");
        JButton hilo2 = new JButton("Hilo 2");
        JButton hilo3 = new JButton("Hilo 3");

        // Añadir botones superiores con layout adaptativo
        gbc.gridx = 0;
        laminaBotonesHilos.add(hilo1, gbc);
        gbc.gridx = 1;
        laminaBotonesHilos.add(hilo2, gbc);
        gbc.gridx = 2;
        laminaBotonesHilos.add(hilo3, gbc);

        add(laminaBotonesHilos, BorderLayout.NORTH);

        // Panel para los botones de detener hilos (parte inferior)
        JPanel laminaBotonesDetener = new JPanel(new GridBagLayout());

        // Botón para detener todos los hilos (ahora con espacio respecto a los bordes laterales)
        JButton detenerTodos = new JButton("Detener Todos");
        gbc.gridx = 0;
        gbc.gridwidth = 3; // Ocupa todo el ancho
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 20, 5, 20); // Añadir espacio lateral al botón "Detener Todos"
        laminaBotonesDetener.add(detenerTodos, gbc);

        // Botones para detener los hilos
        JButton detenerHilo1 = new JButton("Detener Hilo 1");
        JButton detenerHilo2 = new JButton("Detener Hilo 2");
        JButton detenerHilo3 = new JButton("Detener Hilo 3");

        // Añadir botones inferiores con layout adaptativo
        gbc.gridwidth = 1; // Volver a una columna por botón
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 20, 10, 5); // Espacio entre botones y márgenes (20px en el lado izquierdo)
        laminaBotonesDetener.add(detenerHilo1, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 5, 10, 5); // Espacio estándar en los laterales del botón central
        laminaBotonesDetener.add(detenerHilo2, gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(5, 5, 10, 20); // Espacio en el lado derecho (20px)
        laminaBotonesDetener.add(detenerHilo3, gbc);

        add(laminaBotonesDetener, BorderLayout.SOUTH);

        HiloController hiloController = new HiloController(lamina);

        // Asignar acciones a los botones para iniciar los hilos
        hilo1.addActionListener(e -> hiloController.comienzaHilo(1));
        hilo2.addActionListener(e -> hiloController.comienzaHilo(2));
        hilo3.addActionListener(e -> hiloController.comienzaHilo(3));

        // Asignar acciones a los botones para detener los hilos
        detenerHilo1.addActionListener(e -> hiloController.detenerHilo(1));
        detenerHilo2.addActionListener(e -> hiloController.detenerHilo(2));
        detenerHilo3.addActionListener(e -> hiloController.detenerHilo(3));
        detenerTodos.addActionListener(e -> hiloController.detenerTodosLosHilos());
    }
}
