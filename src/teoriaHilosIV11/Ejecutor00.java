package teoriaHilosIV11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Ejecutor00 {
public static void main(String[] args) {
	ThreadFactory threadFactory=new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r);
		}
	};
	//tres objetos que iplmentan Runnable
	TareaImprimir tarea1 = new TareaImprimir("tarea1");
	TareaImprimir tarea2 = new TareaImprimir("tarea2");
	TareaImprimir tarea3 = new TareaImprimir("tarea3");
//	ExecutorService executorService=Executors.newCachedThreadPool();
	ExecutorService executorService=Executors.newCachedThreadPool(threadFactory);
	//new Thread and start
	executorService.execute(tarea1);
	executorService.execute(tarea2); // inicia tarea2
	executorService.execute(tarea3); 
	// cierra los subprocesos trabajadores cuando terminan sus tareas
	executorService.shutdown();
	System.out.println("Tareas iniciadas, main termina.\n");
}
}
