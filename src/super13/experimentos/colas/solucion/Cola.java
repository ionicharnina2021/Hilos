package super13.experimentos.colas.solucion;

import java.util.ArrayDeque;

public class Cola {
	public ArrayDeque<Integer> cola=new ArrayDeque<>();

	public Cola() {
		super();
		for (int i = 0; i < 5000; i++) {
			cola.add(i+1);
		}
	}
	
}
