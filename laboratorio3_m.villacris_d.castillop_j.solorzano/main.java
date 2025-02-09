public class main {

    public static void main(String[] args) {
        fila fila= new fila();
        cliente cliente=new cliente(fila);
        Thread hiloClientes = new Thread(cliente);

        cajero[] cajeros= new cajero[5];
        Thread[] hiloCajeros = new Thread[5];

        for (int i = 0; i < 5; i++) {
            cajeros[i] = new cajero( i + 1,fila);
            hiloCajeros[i] = new Thread(cajeros[i]);
        }

        hiloClientes.start();
        for (Thread hilo : hiloCajeros) {
            hilo.start();
        }

        try {
            Thread.sleep(500); // Espaciado entre la llegada de clientes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
    }
}

}
