package ejemplo03sincro;
public class ProductorConsumidor {
	//En este ejemplo presentamos el problema de la sincronizacion y vemos como
	//El consumidor no va a poder acceder a todos los datos que genera productor
	//La forma ideal sería hacer que consumidor esperase un nuevo valor de 
	//Productor y que este esperase que consumidor obtuviese el valor para 
	//generar uno nuevo
	public static void main(String[] args) {
		ContenedorSincronizado c = new ContenedorSincronizado();
		Productor produce = new Productor(c);
		Consumidor consume = new Consumidor(c);
		produce.start();
		consume.start();
	}
}
