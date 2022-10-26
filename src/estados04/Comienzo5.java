package estados04;

public class Comienzo5 {
	// si la clase no es runnable no le puede poner
	// el metodo run, por eso al crear el hilo
	// le digo que es de tipo runnable
	public static void main(String[] args) throws InterruptedException {
		// Observa que en este caso no he tenido que crear una clase
		// especial que sea thread o runnable, las creo aqui
		// la primera para que sea hilo y la segunda para que implemente
		// run. Pero son objetos creados en ese momento
		Thread vamos = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("Pa habernos matao");
				}
			}
		});

		// Dandole la vuelta a la tortilla
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("quien habra inventao esto");
			}
		}, "nombre del thread: loca");
//	}, "nombre del thread: loca").start();
		vamos.start();
		System.out.println("suspending");
		vamos.suspend();
		Thread.sleep(1000);
		vamos.resume();
		Thread.sleep(1000);
		vamos.stop();
		
//		vamos.resume();
//    vamos.destroy();
//		vamos.interrupt();
//		vamos.yield();
//		vamos.sleep(4);
	}
}
