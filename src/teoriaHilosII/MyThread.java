package teoriaHilosII;

import java.util.Scanner;

public class MyThread extends Thread {
	@Override
	public void run() {
		do {
			System.out.println("escribiendo thread");
		}while(!isInterrupted());

	}

}
