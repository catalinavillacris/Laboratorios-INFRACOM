import java.util.ArrayList;

public class fila {
    private ArrayList<cliente> filaClientes;

    public fila() {
        this.filaClientes = new ArrayList<cliente>();
    }

    public synchronized void agregarCliente(cliente cliente) {
        filaClientes.add(cliente);
        System.out.println("Cliente " + cliente.getUid() + " agregado a la fila (tiempo de procesamiento: " + cliente.getTiempoProcesamiento() + "ms).");
        notify(); // Notifica a los cajeros en espera
    }

    public synchronized cliente retirarCliente() {
        while (filaClientes.isEmpty()) {
            try {
                wait(); // Espera si no hay clientes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        cliente cliente = filaClientes.remove(0);
        System.out.println("Cliente " + cliente.getUid() + " retirado de la fila.");
        return cliente;
    }

    public boolean hayClientes() {
        return !filaClientes.isEmpty();
    }
}
