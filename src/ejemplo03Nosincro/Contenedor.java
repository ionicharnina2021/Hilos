package ejemplo03Nosincro;
public class Contenedor {
	int valor = 0;

	public void put(int valor) {
		this.valor = valor;
	}

	public int get() {
		return this.valor;
	}
}
