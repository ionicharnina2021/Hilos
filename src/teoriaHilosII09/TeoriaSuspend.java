package teoriaHilosII09;

public class TeoriaSuspend {
@SuppressWarnings("deprecation")
public static void main(String[] args) throws InterruptedException {
	Thread thread=new Thread(new MyRunnable());
	System.out.println(thread.getState());
	thread.start();
	System.out.println(thread.getState());
	thread.suspend();
	System.out.println(thread.getState());
	thread.resume();
	System.out.println(thread.getState());
	MyThread myThread=new MyThread();
	myThread.start();
	Thread.sleep(100);
	myThread.interrupt();
	
}
}
