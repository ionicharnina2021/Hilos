package dudasCine14;

public class User extends Thread {
	Cinema cinema;
	
	
	public User(dudasCine14.Cinema cinema) {
		super();
		this.cinema = cinema;
	}

	@Override
	public void run() {
		super.run();
		//aleatorio sin repeticion
		do {
			
		}while(cinema.requestSeat(new RequestSeat()));
		
	}
}
