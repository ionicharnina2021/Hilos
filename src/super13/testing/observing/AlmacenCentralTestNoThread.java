package super13.testing.observing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import super13.modelo.AlmacenCentral;
import super13.modelo.Articulo;
import super13.modelo.Cart;
import super13.modelo.CartAdapter;
import super13.modelo.Cliente;
import super13.repos.ArticulosEnStockRepositorio;

class AlmacenCentralTestNoThread {

	Cliente cliente;
	ArticulosEnStockRepositorio articulosEnStockRepositorio;
	AlmacenCentral almacenCentral;
	int stockIndividualInicial = 10;

	@BeforeEach
	void before() {
		articulosEnStockRepositorio = new ArticulosEnStockRepositorio(stockIndividualInicial,true);
		almacenCentral = new AlmacenCentral(articulosEnStockRepositorio);
		cliente = new Cliente("1234", articulosEnStockRepositorio);
	}

	@Ignore
	void testRunStockAvailable() {
		cliente.run();
		Cart carrito = cliente.getCarrito();
		Set<Entry<Articulo, Integer>> entrySet = carrito.getArticulos().entrySet();
		entrySet.stream().forEach((entry) -> {
			assertEquals(stockIndividualInicial, entry.getKey().getStock() + entry.getValue());
		});

	}

	@Test
	void testRunStockUnAvailable() {
		cliente.setListaCompraAleatoria(false);
		Cart generarListaCompraAleatoria = cliente.generarListaCompraAleatoria(4, 10);
		int elementos=generarListaCompraAleatoria.size();
		Set<Entry<Articulo, Integer>> convert = new CartAdapter().convert(generarListaCompraAleatoria);
		Iterator<Entry<Articulo, Integer>> iterator = convert.iterator();
		Entry<Articulo, Integer> elemento = iterator.next();
		iterator.remove();
		elemento.setValue(10);
		assertTrue(generarListaCompraAleatoria.agregar(elemento.getKey(),elemento.getValue()));
		cliente.setListaCompra(generarListaCompraAleatoria);
		cliente.run();
		assertEquals(elementos, cliente.getCarrito().size());
		assertFalse(articulosEnStockRepositorio.GetAllArticulos().stream()
		.mapToInt((articulo)->{
			return articulo.getStock();
		}).anyMatch((stock)->{return stock==0;}));
	}

}
