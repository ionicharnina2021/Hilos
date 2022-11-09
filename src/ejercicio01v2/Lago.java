package ejercicio01v2;

public class Lago {

	private static Lago instancia = new Lago();
	private int vida = 0;

	private Lago() {
	}

	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}

	public static Lago getInstance() {
		return instancia;
	}

	public synchronized void incrementarVida() {
		vida++;
		notifyAll();
	}

	public synchronized boolean beber() {
		while (isVacio()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		boolean b = !isVacio();
		if (b) {
			vida--;
		}
		return b;
	}

	public boolean isVacio() {
		return vida==0;
	}
}
