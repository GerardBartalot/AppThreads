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

        JPanel laminaBotonesHilos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JButton hilo1 = new JButton("Hilo 1");
        JButton hilo2 = new JButton("Hilo 2");
        JButton hilo3 = new JButton("Hilo 3");

        gbc.gridx = 0;
        laminaBotonesHilos.add(hilo1, gbc);
        gbc.gridx = 1;
        laminaBotonesHilos.add(hilo2, gbc);
        gbc.gridx = 2;
        laminaBotonesHilos.add(hilo3, gbc);

        add(laminaBotonesHilos, BorderLayout.NORTH);

        JPanel laminaBotonesDetener = new JPanel(new GridBagLayout());

        JButton detenerTodos = new JButton("Detener Todos");
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 20, 5, 20);
        laminaBotonesDetener.add(detenerTodos, gbc);

        JButton detenerHilo1 = new JButton("Detener Hilo 1");
        JButton detenerHilo2 = new JButton("Detener Hilo 2");
        JButton detenerHilo3 = new JButton("Detener Hilo 3");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 20, 10, 5);
        laminaBotonesDetener.add(detenerHilo1, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 5, 10, 5);
        laminaBotonesDetener.add(detenerHilo2, gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(5, 5, 10, 20);
        laminaBotonesDetener.add(detenerHilo3, gbc);

        add(laminaBotonesDetener, BorderLayout.SOUTH);

        HiloController hiloController = new HiloController(lamina);

        hilo1.addActionListener(e -> hiloController.comienzaHilo(1));
        hilo2.addActionListener(e -> hiloController.comienzaHilo(2));
        hilo3.addActionListener(e -> hiloController.comienzaHilo(3));

        detenerHilo1.addActionListener(e -> hiloController.detenerHilo(1));
        detenerHilo2.addActionListener(e -> hiloController.detenerHilo(2));
        detenerHilo3.addActionListener(e -> hiloController.detenerHilo(3));
        detenerTodos.addActionListener(e -> hiloController.detenerTodosLosHilos());
        
    }
	
}