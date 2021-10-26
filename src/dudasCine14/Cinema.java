package dudasCine14;

public class Cinema {
	Pit pit=new Pit();

	public synchronized boolean requestSeat(RequestSeat requestSeat) {
		// TODO Auto-generated method stub
		if(pit.isTaken(requestSeat)) {
			return false;
		}
		//lo ocupe y reotorno true;
		return false;
	}
	
	
}
