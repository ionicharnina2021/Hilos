package super13.experimentos.colas.solucionDos;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
		ExecutorService executors=Executors.newCachedThreadPool();
			for (int i = 0; i < members; i++) {
				executors.execute(comedores.get(i));
			}
		Thread.sleep(10000);
		System.out.println("repetidos "+comedores.stream().collect(Collectors.groupingBy(comedor->comedor.value,Collectors.counting()))
				.entrySet().stream().anyMatch((entry)->entry.getValue()>1));
		System.out.println("acaba la prueba");
	}

}
