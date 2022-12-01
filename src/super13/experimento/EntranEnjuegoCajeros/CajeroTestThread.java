package super13.experimento.EntranEnjuegoCajeros;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import super13.modelo.AlmacenCentral;
import super13.repos.ArticulosEnStockRepositorio;

class CajeroTestThread {

	ArticulosEnStockRepositorio articulosEnStockRepositorio;
	AlmacenCentral almacenCentral;
	int stockIndividualInicial = 100;
	ExecutorService executorService;
	List<Cliente> inicial;
	Queue<Cliente> colaDeClientes;
	List<Cajere> cajeros;

	@BeforeEach
	void before() {
		articulosEnStockRepositorio = new ArticulosEnStockRepositorio(stockIndividualInicial, false);
		almacenCentral = new AlmacenCentral(articulosEnStockRepositorio);
		colaDeClientes = new ArrayDeque<>();
		inicial = new ArrayList<>();
		new ClientesOM().getClientes(10, colaDeClientes, inicial, articulosEnStockRepositorio);
		cajeros = new ArrayList<>();
		new CajeresOM().getCajeres(3, cajeros, colaDeClientes);
		executorService = Executors.newCachedThreadPool();
	}

	@Test
	void testRunStockAvailable() throws InterruptedException, ExecutionException {
		int contador = 0;
		// primera compra
		for (Cliente cliente : inicial) {
			executorService.execute(cliente);
		}
//		Thread.sleep(100);
		// actividad normal del supermercado
		do {
			for (Cajere cajere : cajeros) {
				if (!colaDeClientes.isEmpty()) {
					Future<Cliente> submit = executorService.submit(cajere);
					executorService.execute(submit.get());
					contador++;
				}
			}
			System.out.println("contador " + contador);
		} while (contador < 100);

	}

}
