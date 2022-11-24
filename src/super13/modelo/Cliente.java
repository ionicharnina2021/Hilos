package super13.modelo;

import java.util.Map.Entry;

import super13.repos.ArticulosEnStockRepositorio;
import super13.repos.ListaCompraOM;

public class Cliente implements Runnable {
	private final String creditCard;
	private Cart carrito;
	private Cart listaCompra;
	private boolean listaCompraAleatoria=true;
	private ArticulosEnStockRepositorio articulosEnStockRepositorio;
	
	

	public Cliente(String creditCard, ArticulosEnStockRepositorio articulosEnStockRepositorio) {
		super();
		this.creditCard = creditCard;
		this.articulosEnStockRepositorio = articulosEnStockRepositorio;
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
		/*
		 * * v2 debemos hacer varias cosas en el hilo tengamos en cuenta que el mismo
		 * cliente puede hacer varias compras. Solo hay que volver a arrancarlo como
		 * hilo y el Thread ejecutara este metodo. Por eso hay que: 1o vaciar el carrito
		 * y creando una lista de la compra aleatoria o no como el run es un metodo sin
		 * parametros, por lo tanto configurar el tipo de lista compra debe hacerse
		 * aparte. Esto es algo raro pero no hay otro metodo
		 */
		iniciarCompra();		
		/*
		 * 2o ahora hay que comprar. El cliente va a hacer una cosa, varias veces,
		 * primero vamos a coger un elemento de la lista de la compra. preguntamos al
		 * supermercado si tiene stock, en caso afirmativo pasamos el articulo comprado
		 * al carrito
		 */
		while (!listaCompra.isEmpty()) {
			hacerCompra();
		}
		/*
		 * 3o una vez terminado vamos a entrar en la cola para pagar la compra Esta
		 * ultima parte necesita que se le pase la cola en la que se inserta
		 */
		pagarCompra();
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
		return false;
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
