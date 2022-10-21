package ejercicio01noSincro;

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

	public void incrementarVida() {
		vida++;
	}

	public boolean beber() {
		boolean vacio = isVacio();
		if (!vacio) {
			vida--;
		}
		return !vacio;
	}

	public boolean isVacio() {
		if (vida == 0)
			return true;
		else
			return false;
	}
}
