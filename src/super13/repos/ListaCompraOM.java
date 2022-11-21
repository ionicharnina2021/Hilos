package super13.repos;

import java.util.Map;
import java.util.Random;

import super13.modelo.Articulo;
import super13.modelo.Cart;

public class ListaCompraOM {

	ArticulosEnStockRepositorio articulosEnStockRepositorio;

	public ListaCompraOM(ArticulosEnStockRepositorio articulosEnStockRepositorio) {
		super();
		this.articulosEnStockRepositorio = articulosEnStockRepositorio;
	}

	public Cart getListaCompraRandom(int elementosMaximo, int cantidadMaxima) {
		Cart nuevo = new Cart();
		int elementos = new Random().nextInt(elementosMaximo) + 1;
		int cantidad = new Random().nextInt(cantidadMaxima) + 1;
		for (int i = 0; i < elementos;) {
			if (nuevo.agregar(articulosEnStockRepositorio.getArticuloRandom(),
					new Random().nextInt(cantidadMaxima) + 1)) {
				i++;
			}
		}
		return nuevo;
	}
}
