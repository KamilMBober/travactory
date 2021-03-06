package collection.second.theatre.binarysearch;

import java.util.*;

public class Theatre {

	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		
		this.theatreName = theatreName;
		int lastRow = 'A'+(numRows-1);
		for(char row = 'A'; row <= lastRow; row++) {
			for(int seatNum = 1; seatNum<=seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}
	
	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber){
		Seat requestedSeat = new Seat(seatNumber);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if(foundSeat<=0) {
			return seats.get(foundSeat).reserve();
		}else {
			System.out.println("there is no seat "+seatNumber);
			return false;
		}
//		
//		for(Seat seat: seats) {
//			if(seat.getSeatNumber().equals(seatNumber)) {
//				requestedSeat = seat;
//				break;
//			}
//		}
//		if(requestedSeat == null) {
//			System.out.println("there is no seat "+seatNumber);
//			return false;
//		}
//		return requestedSeat.reserve();
	}
	
	// for test 
	public void getSeat() {
		for(Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
		
	}
}






















