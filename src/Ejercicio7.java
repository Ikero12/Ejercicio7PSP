import javax.swing.*;

public class Ejercicio7 extends Thread{
    public static String mensaje=null;
    public static int contador=0;

    public Ejercicio7(String nombre) {
        super(nombre);
    }

    public void run(){

        if(getName()=="lectura"){
            try {
                lectura();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (getName()=="escritura"){
            try {
                escritura();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void lectura() throws InterruptedException {
        sleep(30);
        while(mensaje==null){
            wait();
        }
        System.out.println("El mensaje en el buzón es: " + mensaje);
        mensaje = null;
        notify();

    }
    public synchronized void escritura()throws InterruptedException{
        sleep(20);
        while (mensaje != null){
            wait();
        }
        contador+=1;
        mensaje=""+contador;

        System.out.println("Mensaje: "+ mensaje +" escrito.");

        notify();
    }
}
