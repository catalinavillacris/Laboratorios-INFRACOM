public class main {

    public static void main(String[] args) {
        fila fila= new fila();


        
            new cliente(fila).start();
    

        for (int i = 0; i < 5; i++) {
            new cajero(i, fila).start();
        }
    }

}
