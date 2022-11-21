package super13;

public class Comentador {
	public static boolean on = false;

	public static void mensaje(String mensaje) {
		if (on) {
			System.out.println(mensaje);
		}
	}
}
