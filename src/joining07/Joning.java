package joining07;

public class Joning {

	public static void main(String[] args) {
		Thread hiloUno = new Thread() {
			@Override
			public void run() {
				int max = 10;
				do {
					System.out.println("el uno");
					try {
						this.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (--max > 0);
			}

		};
		Thread hiloDos = new Thread() {
			@Override
			public void run() {
				int max = 10;
				try {
					hiloUno.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				do {
					System.out.println("el dos");
					try {
						this.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (--max > 0);
			}

		};
		hiloDos.start();
		hiloUno.start();
	}
}
