package super13.experimentos.colas;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class TestColacomedor {

	@Test
	void test() throws InterruptedException {
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
//		boolean repetidos=false;
//		for (int i = 0; i <comedores.size()-1&&!repetidos; i++) {
//			for (int j = i; j < comedores.size()&&!repetidos; j++) {
//				if(comedores.get(i).value==comedores.get(j).value) {
//					repetidos=true;
//				}
//			}
//		}
//		System.out.println("repetidos "+repetidos);
		Thread.sleep(10000);
		//si soy capaz de saber si algun hilo tiene value 0
		comedores.forEach((comedor)->{
			if(comedor.value==0) {
				System.out.println("me quede sin valor");
			}
		});
		assertFalse(comedores.stream()
				.collect(Collectors.groupingBy(comedor->comedor.value,Collectors.counting()))
				.entrySet().stream()
					.anyMatch((entry)->entry.getValue()>1));
		System.out.println("acaba la prueba");
	}

}










