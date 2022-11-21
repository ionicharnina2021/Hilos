package super13.modelo;

import super13.repos.ArticulosEnStockRepositorio;

public class SuperMercado {
	private ArticulosEnStockRepositorio articulosEnStockRepositorio;

	public SuperMercado() {
		super();
		articulosEnStockRepositorio=new ArticulosEnStockRepositorio();
	}

}
