package super13.modelo;

import java.util.Objects;

public class Articulo {
	private String barCode;
	private String nombre;

	private float precio;
	private int stock = 0;

	public Articulo(String barCode, String nombre, float precio,int stock) {
		super();
		this.barCode = barCode;
		this.nombre = nombre;
		this.stock=stock;
		setPrecio(precio);
	}

	private float getPrecio() {
		return precio;
	}

	private void setPrecio(float precio) {
		assert precio > 0;
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	private void setStock(int stock) {
		assert stock > 0;
		this.stock = stock;
	}

	private String getBarCode() {
		return barCode;
	}

	private String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barCode, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return Objects.equals(barCode, other.barCode) && Objects.equals(nombre, other.nombre);
	}

	public boolean gestionarStock(int cantidadSolicitada) {
		if (comprobarStock(cantidadSolicitada)) {
			decrementaStock(cantidadSolicitada);
			return true;
		};
		return false;
	}

	private void decrementaStock(int cantidad) {
		stock-=cantidad;

	}

	private boolean comprobarStock(int cantidad) {
		return stock>=cantidad;
	}

	public boolean comprar(Integer value) {
		boolean comprobarStock = comprobarStock(value);
		if (comprobarStock) decrementaStock(value);
		return comprobarStock;
	}

}
