package super13.experimento.reaprovecharhilo;

import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;

import super13.modelo.Articulo;
import super13.modelo.Cart;
import super13.repos.ArticulosEnStockRepositorio;
import super13.repos.ListaCompraOM;

public class ClienteCallable implements Callable {
	private final String creditCard;
	private Cart carrito;
	private Cart listaCompra;
	private boolean listaCompraAleatoria=true;
	private ArticulosEnStockRepositorio articulosEnStockRepositorio;
	Queue<ClienteCallable> compras;
	

	

	public ClienteCallable(String creditCard, ArticulosEnStockRepositorio articulosEnStockRepositorio,
			Queue<ClienteCallable> compras) {
		super();
		this.creditCard = creditCard;
		this.articulosEnStockRepositorio = articulosEnStockRepositorio;
		this.compras = compras;
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
		return compras.offer(this);
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

	@Override
	public Object call() throws Exception {
		iniciarCompra();		
		while (!listaCompra.isEmpty()) {
			hacerCompra();
		}
		pagarCompra();
		Thread.sleep(new Random().nextInt(100));
		return carrito;
	}

	@Override
	public String toString() {
		return creditCard;
	}
}
