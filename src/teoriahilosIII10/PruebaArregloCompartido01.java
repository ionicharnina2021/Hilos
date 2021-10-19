package teoriahilosIII10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PruebaArregloCompartido01 {
	public static void main(String[] arg) {
		ArregloSimple arregloSimpleCompartido = new ArregloSimple(6);

		// crea dos tareas para escribir en el objeto ArregloSimple compartido
		EscritorArreglo escritor1 = new EscritorArreglo(1, arregloSimpleCompartido);
		EscritorArreglo escritor2 = new EscritorArreglo(11, arregloSimpleCompartido);

		// ejecuta las tareas con un objeto ExecutorService
		ExecutorService ejecutor = Executors.newCachedThreadPool();
		ejecutor.execute(escritor1);
		ejecutor.execute(escritor2);

		ejecutor.shutdown();

		try {
			// espera 1 minuto para que ambos escritores terminen de ejecutarse
			boolean tareasTerminaron = ejecutor.awaitTermination(1, TimeUnit.MINUTES);

			if (tareasTerminaron)
				System.out.println(arregloSimpleCompartido); // imprime el contendio
			else
				System.out.println("Se agoto el tiempo esperando a que las tareas terminaran.");
		} // fin de try
		catch (InterruptedException ex) {
			System.out.println("Hubo una interrupcion mientras esperaba a que terminaran las tareas.");
		}
	}
}
