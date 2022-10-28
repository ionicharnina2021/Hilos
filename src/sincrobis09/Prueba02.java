package sincrobis09;

public class Prueba02 {
public static void main(String[] args) {
	Cuenta origen=new Cuenta(1, "pancho"),destino=new Cuenta(0,"Jaime");
	origen.deposito(1000);
	Thread hilotrans=new Thread(new HiloTransferencia(origen, destino));
	hilotrans.start();
}
}
