package ejercicio01;

public class Lago {
	private int vida = 0;

	public int getVida() {
		return vida;
	}

	private static Lago instancia = new Lago();
	
	private Lago() {
	}

	public static Lago getInstance() {
		return instancia;
	}

	public void incrementarVida() {
		vida++;		
	}

	public  void beber(){
		vida--;
	}
	public boolean isVacio() {
		if (vida == 0)
			return true;
		else
			return false;
	}
}
