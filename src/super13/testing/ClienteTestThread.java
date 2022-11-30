package super13.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import super13.experimento.reaprovecharhilo.ClienteCallable;
import super13.modelo.AlmacenCentral;
import super13.modelo.Cart;
import super13.repos.ArticulosEnStockRepositorio;

class ClienteTestThread {

	ClienteCallable cliente;
	ArticulosEnStockRepositorio articulosEnStockRepositorio;
	AlmacenCentral almacenCentral;
	int stockIndividualInicial = 100;
	ExecutorService executorService;
	Queue<ClienteCallable> colaDeClientes;
	ArrayList<ClienteCallable> clientesCompradores;

	@BeforeEach
	void before() {
		articulosEnStockRepositorio = new ArticulosEnStockRepositorio(stockIndividualInicial, false);
		almacenCentral = new AlmacenCentral(articulosEnStockRepositorio);
		colaDeClientes = new ArrayDeque<>();
		colaDeClientes.offer(new ClienteCallable("1", articulosEnStockRepositorio, colaDeClientes));
		colaDeClientes.offer(new ClienteCallable("2", articulosEnStockRepositorio, colaDeClientes));
		colaDeClientes.offer(new ClienteCallable("3", articulosEnStockRepositorio, colaDeClientes));
		colaDeClientes.offer(new ClienteCallable("4", articulosEnStockRepositorio, colaDeClientes));
		colaDeClientes.offer(new ClienteCallable("5", articulosEnStockRepositorio, colaDeClientes));
		executorService = Executors.newCachedThreadPool();
		clientesCompradores = new ArrayList<>();
	}

	@Test
	void testRunStockAvailable() throws InterruptedException, ExecutionException {
		ArrayList<Cart> carritos = new ArrayList<>();
		int contador = 0;
		ClienteCallable poll = colaDeClientes.poll();
		do {
			// Este cliente esta en la cola. ahora ya no
			clientesCompradores.add(poll);
			Future<Cart> submit = executorService.submit(poll);
			poll = colaDeClientes.poll();
			carritos.add(submit.get());
			contador++;
//			System.out.println("el carrito " + submit.get().getArticulos());
		} while (!colaDeClientes.isEmpty() && !articulosEnStockRepositorio.isEmpty());
		 poll = colaDeClientes.poll();
		System.out.println("clientes en cola " + colaDeClientes.size());
		executorService.awaitTermination(1, TimeUnit.SECONDS);
		assertEquals(carritos.size(), contador);
		System.out.println(clientesCompradores.toString());
	}

}
