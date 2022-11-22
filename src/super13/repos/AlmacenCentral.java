package super13.repos;

import super13.modelo.Articulo;

public class AlmacenCentral {
	private final ArticulosEnStockRepositorio articulosEnStockRepositorio;

	public AlmacenCentral(ArticulosEnStockRepositorio repo) {
		super();
		this.articulosEnStockRepositorio = repo;
	}
	
	private void incremento(Articulo articulo) {
		articulo.incrementarStock(10);
	}
	
	public void recorreLocal() {
		articulosEnStockRepositorio.GetAllArticulos()
		.forEach((articulo)->{
			if(articulo.getStock()==0) {
				incremento(articulo);
				System.out.println("h habido una falla en el stock");
			}
		});;
	}
}
