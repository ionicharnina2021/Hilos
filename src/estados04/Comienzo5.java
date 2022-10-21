package estados04;


public class Comienzo5 {
    //si la clase no es runnable no le puede poner
    //el metodo run, por eso al crear el hilo
    //le digo que es de tipo runnable
public static void main(String[] args) {
    //Observa que en este caso no he tenido que crear una clase
    //especial que sea thread o runnable, las creo aqui
    //la primera para que sea hilo y la segunda para que implemente
    //run. Pero son objetos creados en ese momento
    Thread vamos=new Thread(new Runnable() {
         @Override
        public void run() {
            System.out.println("Pa habernos matao");
            // TODO Auto-generated method stub
        }
    });
    
    //Dandole la vuelta a la tortilla
    new Thread(new Runnable() {        
        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("quien habra inventao esto");
        }
    },"nombre del thread: loca").start();
    vamos.start();
    vamos.stop();
    vamos.suspend();
    vamos.resume();
//    vamos.destroy();
    vamos.interrupt();
    vamos.yield();
    vamos.sleep(4);
}
}
