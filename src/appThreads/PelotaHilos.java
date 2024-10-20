package appThreads;

import java.awt.Component;

public class PelotaHilos implements Runnable {
    
	private Pelota pelota;
    private Component componente;

    public PelotaHilos(Pelota unaPelota, Component unComponente) {
        
    	pelota = unaPelota;
        componente = unComponente;
        
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            pelota.muevePelota(componente.getBounds());
            componente.repaint();
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
}