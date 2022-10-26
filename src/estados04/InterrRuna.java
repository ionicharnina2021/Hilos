package estados04;

public class InterrRuna extends Papito implements Runnable{
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("nn");
		}
		System.out.println("yo a mi manera");
	}

}
