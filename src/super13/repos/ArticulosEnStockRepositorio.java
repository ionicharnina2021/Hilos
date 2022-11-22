package super13.repos;

import java.util.List;
import java.util.Random;

import super13.modelo.Articulo;

public class ArticulosEnStockRepositorio {
	private List<Articulo> lista;
	AlmacenCentral almacenCentral = new AlmacenCentral(this);

	public ArticulosEnStockRepositorio() {
		super();
		lista = ArticulosOM.getAll();
	}

	public ArticulosEnStockRepositorio(int stockIndividualInicial) {
		super();
		lista = ArticulosOM.getAll(stockIndividualInicial);
	}

	public int size() {
		return lista.size();
	}

	public Articulo getArticuloRandom() {
		return lista.get(new Random().nextInt(size()));
	}

	public boolean comprar(Articulo key, Integer value) {
		boolean comprar = lista.get(lista.indexOf(key)).comprar(value);
		almacenCentral.recorreLocal();
		return comprar;
	}

	public List<Articulo> GetAllArticulos() {
		return lista;

	}

}
