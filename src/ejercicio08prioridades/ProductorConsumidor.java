package ejercicio08prioridades;
public class ProductorConsumidor {
	//En este ejemplo presentamos el problema de la sincronizacion y vemos como
	//El consumidor no va a poder acceder a todos los datos que genera productor
	//La forma ideal ser�a hacer que consumidor esperase un nuevo valor de 
	//Productor y que este esperase que consumidor obtuviese el valor para 
	//generar uno nuevo
	public static void main(String[] args) {
		ContenedorSincronizado c = new ContenedorSincronizado();
		Productor produce = new Productor(c);
		Consumidor consume = new Consumidor(c);
		Consumidor consumez = new Consumidor(c);
		Consumidor consumezz = new Consumidor(c);
		
		produce.start();
		consume.start();
		consumez.start();
		consumezz.start();
		
	}
}
