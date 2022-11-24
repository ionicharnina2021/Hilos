package super13.modelo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import super13.repos.ArticulosEnStockRepositorio;

public class AlmacenCentral implements PropertyChangeListener{
	private final ArticulosEnStockRepositorio articulosEnStockRepositorio;

	public AlmacenCentral(ArticulosEnStockRepositorio repo) {
		super();
		this.articulosEnStockRepositorio = repo;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		((Reponible)evt.getNewValue()).incrementarStock(10);
		System.out.println("cambio valor");
	}
	
	
	
	
	
	
	
	
	
	
	
}
