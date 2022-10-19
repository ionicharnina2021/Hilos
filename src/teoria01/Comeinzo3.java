package teoria01;

class Meollo2 extends Thread{
    Meollo2(String str){
        super(str);
        System.out.println(this.getName());
    }
    public void run(){
        System.out.println("buena la hermos hecho");
    }
}
public class Comeinzo3 {
    public static void main(String[] args) throws InterruptedException {
        Meollo2 cosa=new Meollo2("pepe");
        //Luego la pruebo
        cosa.start();
        //observa el orden de la ejecucion
        Thread.sleep(500);
        System.out.println("Yo ya he llegado al final, soy el main");
    }
}
