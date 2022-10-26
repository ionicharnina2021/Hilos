package concurrenciaSingleThread05;

import java.time.Duration;
import java.time.Instant;

public class TransformerThread extends Thread {

	private Element element;
	Instant initial;
	
	public TransformerThread(Element element,int i,Instant initial) {
		super(String.valueOf(i));
		this.element = element;
		this.initial=initial;
	}


	@Override
	public void run() {
		element.value++;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant later=Instant.now();
//		System.err.println("Duracion del hilo "+getName()+" es de "+Duration.between(initial, later).toMillis());
	}

}
