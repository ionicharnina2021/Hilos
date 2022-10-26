package ejercicio08prioridades;

public class Consumidor extends Thread {
	private ContenedorSincronizado contenedor;
	private int cantidadObjetivo;
	private int value;

	public Consumidor(ContenedorSincronizado contenedor, int cantidadObjetivo) {
		super();
		this.contenedor = contenedor;
		this.cantidadObjetivo = cantidadObjetivo;
	}
	
	private void queTalVoy() {
		//*** que sacase un numero con el coeficiente entre
		//objetivo/value
		int x=cantidadObjetivo/value*10;
		this.setPriority(x);
	}

	public void run() {
		value =1;
		System.out.println("comenzando el hilo "+getName());
		for (int i = 0; i < 10; i++) {
			value = contenedor.get();
			System.out.println("Consumidor "+getName()+" . get: " + value);
			try {
				sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queTalVoy();
		}
	}
}
