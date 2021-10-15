package teoriaHilosII;

import java.util.Scanner;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		do {
			System.out.println("escribiendo");
			Scanner leer=new Scanner(System.in);
			leer.nextInt();
		}while(true);

	}

}
