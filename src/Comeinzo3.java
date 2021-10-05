class Meollo2 extends Thread{
    Meollo2(String str){
        super(str);
        System.out.println(str);
    }
    public void run(){
    	System.out.println("buena la hermos hecho");
    }
}
public class Comeinzo3 {
    public static void main(String[] args) {
        Meollo2 cosa=new Meollo2("pepe");
        //Luego la pruebo
        cosa.start();
        //observa el orden de la ejecucion
        System.out.println("Yo ya he llegado al final, soy el main");
    }
}
