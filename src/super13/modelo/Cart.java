package super13.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Cart {
	private final Map<Articulo, Integer> cesta;

	public Cart() {
		super();
		cesta = new HashMap<>();
	}

	public boolean agregar(Articulo articulo, int cantidad) {
		if (!cesta.containsKey(articulo))
			if (articulo.gestionarStock(cantidad)) {
				cesta.put(articulo, cantidad);
				return true;
			}
		return false;
	}

	public boolean isEmpty() {
		return cesta.isEmpty();
	}

	public Map<Articulo, Integer> getArticulos() {
		return cesta;

	}

	public int size() {
		return cesta.size();
	}

	public Entry<Articulo, Integer> getFirst() {
		Set<Entry<Articulo, Integer>> entrySet = cesta.entrySet();
		Object[] array = entrySet.toArray();
		return (Entry<Articulo, Integer>) array[0];

	}

	public void remove(Entry<Articulo, Integer> first) {
		cesta.remove(first.getKey());
	}
}
