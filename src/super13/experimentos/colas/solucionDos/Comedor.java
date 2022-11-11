package super13.experimentos.colas.solucionDos;

import java.util.Queue;

public class Comedor implements Runnable {
	int delay;
	public int value;
	Queue<Integer> deque;
	int id;

	public Comedor(int delay, Queue<Integer> deque, int id) {
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
			value = deque.poll();
	}

}
