package appThreads;

import java.util.HashMap;
import java.util.Map;

public class HiloController {
    
	private Map<Integer, Thread> hilos = new HashMap<>();
    private LaminaPelota lamina;

    public HiloController(LaminaPelota lamina) {
        
    	this.lamina = lamina;
    	
    }

    // Iniciar un hilo específico
    public void comienzaHilo(int idHilo) {
        
    	Pelota pelota = new Pelota();
        lamina.add(pelota);
        Runnable r = new PelotaHilos(pelota, lamina);
        Thread hilo = new Thread(r);
        hilos.put(idHilo, hilo);
        hilo.start();
        
    }

    // Detener un hilo específico
    public void detenerHilo(int idHilo) {
        
    	Thread hilo = hilos.get(idHilo);
        if (hilo != null && hilo.isAlive()) {
            hilo.interrupt();
        }
        
    }

    // Detener todos los hilos
    public void detenerTodosLosHilos() {
        
    	for (Thread hilo : hilos.values()) {
            if (hilo != null && hilo.isAlive()) {
                hilo.interrupt();
            }
        }
    	
    }
    
}