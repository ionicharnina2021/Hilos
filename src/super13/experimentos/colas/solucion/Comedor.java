package super13.experimentos.colas.solucion;

import java.util.ArrayDeque;

public class Comedor implements Runnable {
	int delay;
	public int value;
	ArrayDeque<Integer> deque;
	int id;

	public Comedor(int delay, ArrayDeque<Integer> deque, int id) {
		this.delay = delay;
		this.deque = deque;
		this.id = id;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		System.out.println("mi pausa es de "+delay);
		try {
			Thread.currentThread().sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println();
//		System.out.println("El hilo "+id+"pide en el cola");
		synchronized (deque) {
			value = deque.poll();
		}
//		System.out.println("el hilo "+id+" termina y consigue un valor de "+value);
	}

}
