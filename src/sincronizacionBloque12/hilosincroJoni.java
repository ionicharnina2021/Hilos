package sincronizacionBloque12;

public class hilosincroJoni {
	public static void main(String[] args) {
		Valor valor=new Valor();
		Thread threadTwo = new Thread() {
			public void run() {
				System.out.println("esperando respuesta desde dos");
				try {
					sleep(1300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				valor.aprobacion=true;
			};
		};
		Thread threadOne = new Thread() {
			public void run() {
				System.out.println("esperando confirmacion del uno");
				try {
					threadTwo.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("recibida la notificacion");
				if(valor.aprobacion) {
					System.out.println("haciendo lo que sea");
				}
			};
		};
		threadOne.start();
		threadTwo.start();
	}
}
