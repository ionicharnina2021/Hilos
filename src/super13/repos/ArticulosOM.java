package super13.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import super13.modelo.AlmacenCentral;
import super13.modelo.Articulo;

public class ArticulosOM {
	private static String[] barcodes = { "1", "2", "3", "4", "5", "6" };
	private static String[] nombres = { "pan", "agua", "chocolate", "fresa", "sardina", "pollo" };
	private static float[] precios = { 2, 3, 4, 2, 3, 4 };
	private static ArrayList<Articulo> articulos;
	private static int randomStockMaximo = 100;

	public static List<Articulo> getAll() {
		return getAll(new Random().nextInt(randomStockMaximo));
	}

	public static List<Articulo> getAll(int stockIndividualInicial) {
		if (articulos == null) {
			articulos = new ArrayList<>();
			for (int i = 0; i < barcodes.length; i++) {
				articulos.add(new Articulo(barcodes[i], nombres[i], precios[i], stockIndividualInicial));
			}
		}
		return articulos;
	}
	
	public static List<Articulo> getAll(int stockIndividualInicial,AlmacenCentral almacenCentral) {
		if (articulos == null) {
			articulos = new ArrayList<>();
			for (int i = 0; i < barcodes.length; i++) {
				articulos.add(
						new Articulo(barcodes[i], nombres[i], precios[i], stockIndividualInicial,almacenCentral));
			}
		}
		return articulos;
	}
	

}
