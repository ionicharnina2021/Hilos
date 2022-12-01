package super13.experimento.EntranEnjuegoCajeros;

import java.util.List;
import java.util.Queue;
import java.util.Random;
public class CajeresOM {

	public void getCajeres(int amount,List<Cajere>  cajeros,Queue<Cliente> clientes) {
		
		long dni=77654567;
		int numeroCaja=1;
		int lapsoMin=100,lapsoMax=500;
		for (int i = 0; i < amount; i++) {
			cajeros.add(new Cajere(String.valueOf(dni++), numeroCaja++, lapsoMin+new Random().nextInt(lapsoMax), clientes));
		}
		
	}

}
