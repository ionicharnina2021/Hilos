package super13.repos;

import java.util.List;
import java.util.Random;

import super13.modelo.AlmacenCentral;
import super13.modelo.Articulo;

public class ArticulosEnStockRepositorio {
	private List<Articulo> lista;
	AlmacenCentral almacenCentral = new AlmacenCentral(this);

	public ArticulosEnStockRepositorio() {
		super();
		lista = ArticulosOM.getAll();
	}

	public ArticulosEnStockRepositorio(int stockIndividualInicial,boolean observing) {
		super();
		if(!observing)
			lista = ArticulosOM.getAll(stockIndividualInicial);
		else
			lista=ArticulosOM.getAll(stockIndividualInicial,almacenCentral);
	}


	public int size() {
		return lista.size();
	}

	public Articulo getArticuloRandom() {
		return lista.get(new Random().nextInt(size()));
	}

	public boolean comprar(Articulo key, Integer value) {
		boolean comprar = lista.get(lista.indexOf(key)).comprar(value);
		//ya no hace falta este sondeo
//		almacenCentral.recorreLocal();
		return comprar;
	}

	public List<Articulo> GetAllArticulos() {
		return lista;
	}

	public boolean isEmpty() {
		return !lista.stream()
				.mapToInt((articulo)->articulo.getStock())
				.anyMatch((stock)->{return stock>0;});
	}

}
