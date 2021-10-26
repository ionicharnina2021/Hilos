package dudasCine14;

import java.util.ArrayList;
import java.util.HashMap;

public class Pit {

	ArrayList<Row> rows;
	char letter='a';
	
	ArrayList<Position> positions;
	//se rellena poniendo letras y numeros
	HashMap<Position, Seat> seats;
	
	public boolean isTaken(RequestSeat requestSeat) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Row getRow(char secondLetter) {
		char lowerCase = Character.toLowerCase(secondLetter);
		int number=lowerCase-letter;
		return rows.get(number);
	}

}
