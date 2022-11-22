package super13.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import super13.modelo.Articulo;
import super13.modelo.Cart;
import super13.modelo.Cliente;
import super13.repos.AlmacenCentral;
import super13.repos.ArticulosEnStockRepositorio;

class ClienteTestNoThread {

	Cliente cliente;
	ArticulosEnStockRepositorio articulosEnStockRepositorio;
	AlmacenCentral almacenCentral;
	int stockIndividualInicial=10;
	
	@BeforeEach
	void before() {
		articulosEnStockRepositorio=new ArticulosEnStockRepositorio(stockIndividualInicial);
		almacenCentral=new AlmacenCentral(articulosEnStockRepositorio);
		cliente = new Cliente("1234",articulosEnStockRepositorio);
	}

	@Test
	void testRunStockAvailable() {
		cliente.run();
		Cart carrito = cliente.getCarrito();
		Set<Entry<Articulo,Integer>> entrySet = carrito.getArticulos().entrySet();
		entrySet.stream().forEach((entry)->{
			assertEquals(stockIndividualInicial, entry.getKey().getStock()+entry.getValue());
		});
		
	}
	
	@Ignore
	void testRunStockUnAvailable() {
		
	}

}
