import java.util.ArrayList;

public class fila {
    private ArrayList<cliente> filaClientes;

    public fila() {
        this.filaClientes = new ArrayList<cliente>();
    }

    public synchronized void agregarCliente(cliente cliente) {
        filaClientes.add(cliente);
    }

    public synchronized void retirarCliente(cliente cliente) {
        if (filaClientes.size() > 0) {
            filaClientes.remove(0);
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
