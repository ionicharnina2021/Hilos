package super13.repos;

import java.util.Map;

import super13.modelo.Articulo;

public class Cliente {
	private final String creditCard;
	private Cart carrito;
	private Map<Articulo, Integer> listaCompra;
	
	public Cliente(String creditCard) {
		super();
		this.creditCard = creditCard;
	}

	public void iniciarCompra() {
		this.carrito=new Cart();
	}
	
	public boolean agregarCarrito(Articulo articulo,int cantidad) {
		return carrito.agregar(articulo,cantidad);
	}

	private String getCreditCard() {
		return creditCard;
	}
	run(){
		//segun mi lista de la compra voy a recoger los productos
		//pasar por caja y ahi termina el hilo
	}
	public boolean pagarCompra() {
		return false;
	}
}
