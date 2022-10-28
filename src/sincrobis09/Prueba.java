package sincrobis09;

public class Prueba {

	public static void main(String[] args) {
		Cuenta origen=new Cuenta(1, "pancho"),destino=new Cuenta(0,"Jaime");
		new Thread() {
			public void run() {
				System.out.println("comienzo 1");
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				destino.deposito(1);
				System.out.println("deposito 1");
				System.out.println("acaba el primer hilo");
				System.out.println("el saldo despues de terminar hilo 1 "+destino.getSaldo());
			}
		}.start();
		new Thread() {
				public void run() {
					System.out.println("comienzo 2");
					synchronized (destino) {
						destino.deposito(10);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("deposito 10");
					System.out.println("acaba el segundo hilo");
					System.out.println("el saldo despues de terminar hilo 2 "+destino.getSaldo());
				};
			}.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" segunda vez "+destino.getSaldo());
	}

}
