package ejercicio01;

import java.util.Random;

public class Being {
	private final int MAXLONGLIFE = 120;
	private final int ANNUALFEED = 1;
	private static int order=0;
	
	private int id;
	private int lifeExpectancy;
	private int actualLife = 0;
	private boolean alive = true;

	public Being() {
		super();
		lifeExpectancy = new Random().nextInt(MAXLONGLIFE);
		id=order++;
	}

	public void feed(Cornucopia cornucopia) {
		actualLife += cornucopia.provide(ANNUALFEED);
	}

	// Esta haciendo dos cosas. minima sorpresa
	// public boolean aging() {
	// actualLife++;
	// return actualLife<lifeExpectancy;
	// }
	public void aging() {
		actualLife++;
		setAlive(actualLife < lifeExpectancy);
	}

	private void setAlive(boolean result) {
		alive = result;
	}

	public boolean isAlive() {
		return alive;
	}

	public void present() {
		System.out.println("Soy "+id+" y tengo "+actualLife+" estoy vivo? "+isAlive());
		
	}
}
