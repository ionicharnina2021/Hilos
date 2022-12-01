package super13.experimento.EntranEnjuegoCajeros;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;

import super13.modelo.Cart;

public class Cajere implements Callable {
	private final String DNI;
	private int numeroCaja;
	private int lapso;
	Queue<Cliente> clientes;


	public Cajere(String dNI, int numeroCaja, int lapso, Queue<Cliente> clientes) {
		super();
		DNI = dNI;
		this.numeroCaja = numeroCaja;
		this.lapso = lapso;
		this.clientes = clientes;
	}

	private int getNumeroCaja() {
		return numeroCaja;
	}

	private void setNumeroCaja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	private String getDNI() {
		return DNI;
	}

	private float getLapso() {
		return lapso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cajere other = (Cajere) obj;
		return Objects.equals(DNI, other.DNI);
	}

	@Override
	public Object call() throws InterruptedException {
		Cliente poll =  clientes.poll();
		if (poll != null) {
			procesaPedido(poll.getCarrito());
			Thread.sleep(lapso);
			return poll;
		}
		return null;
	}

	private void procesaPedido(Cart carrito) {
		// TODO Auto-generated method stub

	}

}
