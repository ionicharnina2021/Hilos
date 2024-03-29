package ejercicio01;

public class Lago {

	private static Lago instancia = new Lago();
	private int vida = 0;

	private Lago() {
	}

	public int getVida() {
		return vida;
	}

	public static Lago getInstance() {
		return instancia;
	}

	public synchronized void incrementarVida() {
		while(!isVacio()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		vida++;
		notifyAll();
	}

	public synchronized boolean beber() {
		while (isVacio()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boolean b = !isVacio();
		if (b) {
			vida--;
		}
		notifyAll();
		return b;
	}

	public boolean isVacio() {
		if (vida == 0)
			return true;
		else
			return false;
	}
}
