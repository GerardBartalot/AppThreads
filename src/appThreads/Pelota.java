package appThreads;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {
    
	private static final int TAMX = 15, TAMY = 15;
    private double x = 0, y = 0, dx = 4, dy = 4;

    public void muevePelota(Rectangle2D limites) {
        
    	x += dx;
        y += dy;

        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }
        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }
        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }
        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }

        dx += (Math.random() - 0.5) * 0.1;
        dy += (Math.random() - 0.5) * 0.1;

        dx = Math.max(-4, Math.min(4, dx));
        dy = Math.max(-4, Math.min(4, dy));
        
    }

    public Ellipse2D getShape() {
        
    	return new Ellipse2D.Double(x, y, TAMX, TAMY);
    	
    }
    
}