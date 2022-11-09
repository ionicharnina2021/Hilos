package sincro0922;

public class HiloTransferencia implements Runnable {
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	private Integer delay;

	public HiloTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino,int delay) {
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.delay=delay;
	}

	public void run() {
		String hilo = Thread.currentThread().getName();
		synchronized (cuentaDestino) {
			System.out.println(hilo + " bloquea cuenta de " + cuentaOrigen.getNombre());
			hacerRetiro(cuentaOrigen, 50);
			try {
				Thread.currentThread().sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cuentaOrigen.getSaldo() < 0) {
				System.out.println("Cuenta sobregirada");
			}
			System.out.println(hilo + " inicia el deposito " + "en cuenta de " + cuentaDestino.getNombre());
			hacerDeposito(cuentaDestino, 50);
			System.out.println(hilo + " termina la transferencia");
			System.out.println(hilo + " termina el bloqueo de " + cuentaOrigen.getNombre());
		}
	}

	private void hacerRetiro(Cuenta cuenta, int cantidad) {
		String hilo = Thread.currentThread().getName();
		if (cuenta.getSaldo() >= cantidad) {
			System.out.println(hilo + " procede a realizar un retiro " + cuenta.getSaldo());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Error de thread");
			}
			cuenta.retiro(cantidad);
			System.out.println(hilo + " termino de realizar un retiro " + cuenta.getSaldo());
		} else {
			System.out.println(
					"No hay suficiente saldo para que " + hilo + " realice un retiro (" + cuenta.getSaldo() + ")");
		}
	}

	private void hacerDeposito(Cuenta cuenta, int cantidad) {
		String hilo = Thread.currentThread().getName();
		synchronized (cuenta) {
			System.out.println(hilo + " procede a realizar un deposito " + cuenta.getSaldo());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Error de thread");
			}
			cuenta.deposito(cantidad);
			System.out.println(hilo + " termino de realizar un deposito " + cuenta.getSaldo());
		}
	}
}
