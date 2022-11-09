package super13.repos;

import java.util.List;

import super13.modelo.Articulo;

public class ArticulosEnStrockRepositorio {
	private List<Articulo> lista;

	public ArticulosEnStrockRepositorio() {
		super();
		lista=ArticuloEnStockOM.getAll();
	}
	
}
