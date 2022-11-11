package super13.experimentos.colas.solucionDos;

import java.util.concurrent.ArrayBlockingQueue;

public class Cola {
	public ArrayBlockingQueue<Integer> cola=new ArrayBlockingQueue<Integer>(5000);

	public Cola() {
		super();
		for (int i = 0; i < 5000; i++) {
			cola.add(i+1);
		}
	}
	
}
