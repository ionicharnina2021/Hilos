package concurrenciaSingleThread05;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TesterThread {
	public static void main(String[] args) {
		
		ArrayList<Element> elements = new ArrayList<>();
		int size = 1000;
		for (int i = 0; i < size; i++) {
			elements.add(new Element());
		}
		Instant now = Instant.now();
		int i = 0;
		for (Element element : elements) {
			new TransformerThread(element, i,now).start();
			i++;
		}
		Instant later = Instant.now();
		Duration duration = Duration.between(now, later);
		System.out.println("la diferencia mutilhilo " + duration.toMillis());
	}
}
