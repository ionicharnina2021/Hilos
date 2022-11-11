package super13.repos;

import java.util.List;

import super13.modelo.Articulo;

public class ArticulosRepositorio {
	private List<Articulo> lista;

	public ArticulosRepositorio() {
		super();
		lista=ArticulosOM.getAll();
	}
	
}
