package super13.experimento.EntranEnjuegoCajeros;

import java.util.List;
import java.util.Queue;

import super13.repos.ArticulosEnStockRepositorio;

public class ClientesOM {
	public void getClientes(int amount, Queue<Cliente> clientes,List<Cliente> temporal,
			ArticulosEnStockRepositorio articulosEnStockRepositorio) {
		for (int i = 0; i < amount; i++) {
			temporal.add(new Cliente(String.valueOf(i), articulosEnStockRepositorio, clientes));
		}
	}
}
