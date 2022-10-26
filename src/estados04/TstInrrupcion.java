package estados04;

public class TstInrrupcion {
public static void main(String[] args) throws InterruptedException {
	Thread hola=new Thread() {
		public void run() {
			while(!isInterrupted()) {
				System.out.println("ss");
			}
			System.out.println("me muero como hilo pero vivi como proceso");
		};
	};
	hola.start();
	Thread.sleep(1000);
	hola.interrupt();
	InterrRuna nn=new InterrRuna();
	Thread nns=new Thread(nn);
	nns.start();
	Thread.sleep(1000);
	nns.interrupt();
}
}
