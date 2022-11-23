package super13.modelo;

import java.util.Map.Entry;
import java.util.Set;

public class CartAdapter {

	public Set<Entry<Articulo, Integer>> convert(Cart cart){
		return cart.getArticulos().entrySet();
	}
}
