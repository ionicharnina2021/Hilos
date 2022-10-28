package sincroatomic10;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ArregloSimple // PRECAUCI�N: �NO ES SEGURO PARA LOS SUBPROCESOS!
{
	private final int arreglo[]; // el arreglo entero compartido
	//Es una forma muy sencilla de sincronizar valores
	private int indiceEscritura = 0; // �ndice del siguiente elemento a escribir
	private final static Random generador = new Random();

	// construye un objeto ArregloSimple de un tama�o dado
	public ArregloSimple(int tamanio) {
		arreglo = new int[tamanio];
	} // fin del constructor

	// agrega un valor al arreglo compartido
	public void agregar(int valor) {
		int posicion = indiceEscritura; // almacena el �ndice de escritura

		try {
			// pone el subproceso en inactividad de 0 a 499 milisegundos
			Thread.sleep(generador.nextInt(500));
		} // fin de try
		catch (InterruptedException ex) {
			ex.printStackTrace();
		} // fin de catch

		// coloca el valor en el elemento apropiado
		arreglo[posicion] = valor;
		System.out.printf("%s escribio %2d en el elemento %d.\n", Thread.currentThread().getName(), valor, posicion);

//		operacion no atomica
		++indiceEscritura; // incrementa el �ndice del siguiente elemento a escribir
		System.out.printf("Siguiente indice de escritura: %d %s\n", indiceEscritura,Thread.currentThread().getName());
	} // fin del m�todo agregar

	// se utiliza para imprimir el contenido del arreglo entero compartido
	public String toString() {
		String cadenaArreglo = "\nContenido de ArregloSimple:\n";

		for (int i = 0; i < arreglo.length; i++)
			cadenaArreglo += arreglo[i] + " ";

		return cadenaArreglo;
	}
} 