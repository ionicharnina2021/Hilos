package ejemplo02;

import java.util.Random;

public class Being extends Thread {
	private final int MAXLONGLIFE = 120;
	private final int ANNUALFEED = 1;
	private static int order=0;
	
	private int id;
	private int lifeExpectancy;
	private int actualLife = 0;
	private boolean dead = false;
	Cornucopia cornucopia;

	public Being(Cornucopia cornucopia) {
		super();
		lifeExpectancy = new Random().nextInt(MAXLONGLIFE);
		id=order++;
		this.cornucopia=cornucopia;
	}

	@Override
	public void run() {
		super.run();
		do {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			feed();
			aging();
			present();
			System.out.println(isDead());
		}while(!isDead());
	}
	
	public void feed() {
		actualLife += cornucopia.provide(ANNUALFEED);
	}

	// Esta haciendo dos cosas. minima sorpresa
	// public boolean aging() {
	// actualLife++;
	// return actualLife<lifeExpectancy;
	// }
	public void aging() {
		setDead(!(actualLife < lifeExpectancy));
	}

	
	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void present() {
		System.out.println("Soy "+id+" y tengo "+actualLife+" estoy vivo? "+isDead());
		
	}
}
