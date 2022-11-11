package super13.experimentos.colas;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PruebiTonti {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Comedor> comedores=new ArrayList<>();
		Cola cola=new Cola();
		Thread.sleep(1000);
		int delay=5000;
		int members=5000;
		for (int i = 0; i < members; i++) {
			comedores.add(new Comedor(delay--, cola.cola,i));			
		}
		System.out.println("cantidad de comedores "+comedores.size());
//		Thread.sleep(1000);
		System.out.println("arrancamos hilos");
		for (int i = 0; i < members; i++) {
			new Thread(comedores.get(i)).start();
		}
		Thread.sleep(10000);
		System.out.println("repetidos "+comedores.stream().collect(Collectors.groupingBy(comedor->comedor.value,Collectors.counting()))
				.entrySet().stream().anyMatch((entry)->entry.getValue()>1));
		System.out.println("acaba la prueba");
	}

}
