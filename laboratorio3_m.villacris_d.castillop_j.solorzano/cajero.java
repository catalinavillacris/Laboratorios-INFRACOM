public class cajero extends Thread {
    private int id;
    private fila filaClientes;
    private double factorDeCansancio = 1.0; 

    public cajero(int id, fila fila) {
        this.id = id;
        this.filaClientes = fila;
    }

    @Override
    public void run() {
        while (filaClientes.hayClientes()) {
            cliente cliente = filaClientes.retirarCliente();
            recepcionCliente(cliente);
        }

        System.out.println("Cajero " + id + " ha terminado de atender clientes.");
    }
    
    public void recepcionCliente(cliente cliente) {
        int tiempoProcesamiento = cliente.getTiempoProcesamiento();
        double tiempoProcesamientoActual =  (tiempoProcesamiento * factorDeCansancio);
        System.out.println("El cajero " + id + " atentendiendo al cliente " + cliente.getUid() + " (tiempo de procesamiento basico: " + tiempoProcesamiento + "ms)." + "factor de cansancio actual: " + factorDeCansancio + "tiempo de procesamiento actual: " + tiempoProcesamientoActual + "ms).");
        try {
            Thread.sleep((long) (tiempoProcesamientoActual));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Cajero " + id + " ha terminado de procesar al cliente " + cliente.getUid() + ".");
        factorDeCansancio += tiempoProcesamientoActual*0.001;
    }
}

                
