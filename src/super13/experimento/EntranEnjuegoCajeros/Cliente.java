package super13.experimento.EntranEnjuegoCajeros;

import java.util.Map.Entry;
import java.util.Queue;

import super13.modelo.Articulo;
import super13.modelo.Cart;
import super13.repos.ArticulosEnStockRepositorio;
import super13.repos.ListaCompraOM;

public class Cliente implements Runnable {
	private final String creditCard;
	private Cart carrito;
	private Cart listaCompra;
	private boolean listaCompraAleatoria=true;
	private ArticulosEnStockRepositorio articulosEnStockRepositorio;
	private Queue<Cliente> colaPago;
	
	

	public Cliente(String creditCard, ArticulosEnStockRepositorio articulosEnStockRepositorio, Queue<Cliente> compras) {
		super();
		this.creditCard = creditCard;
		this.articulosEnStockRepositorio = articulosEnStockRepositorio;
		this.colaPago = compras;
	}
	private void iniciarCompra() {
		this.carrito = new Cart();
		int elementosMaximo = 3;
		int cantidadMaxima = 10;
		if(listaCompraAleatoria)
		this.listaCompra = generarListaCompraAleatoria(elementosMaximo, cantidadMaxima);
	}

	public Cart generarListaCompraAleatoria(int elementosMaximo, int cantidadMaxima) {
		return new ListaCompraOM(this.articulosEnStockRepositorio).getListaCompraRandom(elementosMaximo,
				cantidadMaxima);
	}

	private boolean agregarCarrito(Articulo articulo, int cantidad) {
		return carrito.agregar(articulo, cantidad);
	}

	private String getCreditCard() {
		return creditCard;
	}

	@Override
	public void run() {
		
		iniciarCompra();		
		
		while (!listaCompra.isEmpty()) {
			hacerCompra();
		}
		
		pagarCompra();
		System.out.println("pagar compra "+creditCard);
	}

	private void hacerCompra() {
		// obtenemos el primer elemento de la lista
		Entry<Articulo, Integer> first = listaCompra.getFirst();
		// y lo borramos de la lista. Lo podamos comprar o no
		listaCompra.remove(first);
		if (articulosEnStockRepositorio.comprar(first.getKey(), first.getValue())) {
			carrito.agregar(first.getKey(), first.getValue());
		}
	}

	private boolean pagarCompra() {
		return colaPago.offer(this);
	}

	public Cart getCarrito() {
		return carrito;
	}

	public Cart getListaCompra() {
		return listaCompra;
		
	}

	private boolean isListaCompraAleatoria() {
		return listaCompraAleatoria;
	}

	public void setListaCompraAleatoria(boolean listaCompraAleatoria) {
		this.listaCompraAleatoria = listaCompraAleatoria;
	}

	public void setListaCompra(Cart listaCompra) {
		this.listaCompra = listaCompra;
	}

}
