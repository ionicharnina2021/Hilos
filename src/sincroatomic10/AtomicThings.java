package sincroatomic10;

import java.time.Year;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class AtomicThings {
	AtomicInteger ss = new AtomicInteger();
	public int probar=1;

	public AtomicThings() {
		super();
//		ss.accumulateAndGet(x, accumulatorFunction);
//		ss.addAndGet(delta);
//		ss.compareAndSet(expect, update);
		ss.getAndIncrement();
		// and many more
	}

	public static void main(String[] args) {
		AtomicThings sss=new AtomicThings();
		new MyThread(sss,"uno").start();
		new MyThread(sss,"dos").start();
	
	}
}
