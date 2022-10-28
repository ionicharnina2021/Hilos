package sincrobis09;

//Uso de un bloque sincronizado para controlar el acceso a SumArray.
class sumArray {
	private int sum;

	// sumArray no est� sincronizado
	int sumArray(int nums[]) {
		sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			System.out.println("Total acumulado de " + Thread.currentThread().getName() + " es " + sum);
			try {
				Thread.sleep(10);// permitir el cambio de tarea
			} catch (InterruptedException exc) {
				System.out.println("Hilo interrumpido");
			}
		}
		return sum;
	}
}

class MiHilo implements Runnable {
	Thread hilo;
	static sumArray sumarray = new sumArray();
	int a[];
	int resp;

	// Construye un nuevo hilo.
	MiHilo(String nombre, int nums[]) {
		hilo = new Thread(this, nombre);
		a = nums;
	}

	// Un m�todo que crea e inicia un hilo
	public static MiHilo creaEInicia(String nombre, int nums[]) {
		MiHilo miHilo = new MiHilo(nombre, nums);

		miHilo.hilo.start(); // Inicia el hilo
		return miHilo;
	}

	// Punto de entrada del hilo
	public void run() {
		int sum;
		System.out.println(hilo.getName() + " iniciando.");

		// synchronize llama a sumArray()
		synchronized (sumarray) {
			// Aqu�, las llamadas a sumArray() en sumarray se sincronizan
			resp = sumarray.sumArray(a);
		}
		System.out.println("Suma para " + hilo.getName() + " es " + resp);
		System.out.println(hilo.getName() + " terminado.");
	}
}

public class Sincronizacion {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		MiHilo mh2 = MiHilo.creaEInicia("#2", a);
		MiHilo mh1 = MiHilo.creaEInicia("#1", a);

		//no entiendo bien esta supeditacion del hilo1 y 2 ambos hacen join
//		try {
//			mh1.hilo.join();
//			mh2.hilo.join();
//		} catch (InterruptedException exc) {
//			System.out.println("Hilo principal interrumpido.");
//		}
	}
}