import java.util.Random;

public class cliente extends Thread {
    private int uid;
    private int numeroDeclientes = 0;
    private fila fila;
    private int tiempoProcesamiento;
    
    public cliente(int uid, int numeroDeclientes, fila fila) {
        this.uid = uid;
        this.numeroDeclientes = numeroDeclientes;
        this.fila = fila;
        this.tiempoProcesamiento = new Random().nextInt(2001) ;
    }

    public int getUid() {
        return uid;
    }

    public int getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    @Override
    public void run() {
        fila.agregarCliente(this);
        try {
            Thread.sleep(new Random().nextInt(501)); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        fila.retirarCliente();
        try {
            Thread.sleep(new Random().nextInt(501)); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
