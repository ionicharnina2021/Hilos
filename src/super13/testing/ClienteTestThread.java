package super13.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import super13.modelo.Articulo;
import super13.modelo.Cart;
import super13.modelo.Cliente;
import super13.repos.AlmacenCentral;
import super13.repos.ArticulosEnStockRepositorio;

class ClienteTestThread {


	Cliente cliente;
	ArticulosEnStockRepositorio articulosEnStockRepositorio;
	AlmacenCentral almacenCentral;
	int stockIndividualInicial = 10;
	ExecutorService executorService;

	@BeforeEach
	void before() {
		articulosEnStockRepositorio = new ArticulosEnStockRepositorio(stockIndividualInicial);
		almacenCentral = new AlmacenCentral(articulosEnStockRepositorio);
		cliente = new Cliente("1234", articulosEnStockRepositorio);
		executorService = Executors.newCachedThreadPool();
	}

	@Test
	void testRunStockAvailable() throws InterruptedException {
		LocalTime principio=LocalTime.now();
		executorService.execute(cliente);
		executorService.awaitTermination(1, TimeUnit.SECONDS);
		Cart carrito = cliente.getCarrito();
		Set<Entry<Articulo, Integer>> entrySet = carrito.getArticulos().entrySet();
		entrySet.stream().forEach((entry) -> {
			assertEquals(stockIndividualInicial, entry.getKey().getStock() + entry.getValue());
		});
		System.out.println(Duration.between(principio, LocalTime.now()));

	}
	
	
	
}
