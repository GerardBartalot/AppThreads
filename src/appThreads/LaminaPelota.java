package appThreads;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class LaminaPelota extends JPanel {
    
	private ArrayList<Pelota> pelotas = new ArrayList<>();

    public void add(Pelota p) {
        
    	pelotas.add(p);
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota pelota : pelotas) {
            g2.fill(pelota.getShape());
        }
    }
    
}