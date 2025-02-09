import java.util.Random;

public class cliente extends Thread {
    private static int contadorClientes = 0; 
    private int uid;
    private int tiempoProcesamiento;
    private fila fila;
    private Random rand = new Random();
    
    public cliente(fila fila) {
        this.fila = fila;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { 
            int uid = contadorClientes++; 
            int tiempoProcesamiento = rand.nextInt(2001); 
    
            cliente nuevoCliente = new cliente(fila);
            nuevoCliente.setUid(uid);
            nuevoCliente.setTiempoProcesamiento(tiempoProcesamiento);
    
            fila.agregarCliente(nuevoCliente);
            try {
                Thread.sleep(rand.nextInt(501)); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            fila.retirarCliente();
            try {
                Thread.sleep(rand.nextInt(501)); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setTiempoProcesamiento(int tiempoProcesamiento) {
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    public int getUid() {
        return uid;
    }

    public int getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }
}
