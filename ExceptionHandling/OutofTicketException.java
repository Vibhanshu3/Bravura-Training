package ExceptionHandling;

public class OutofTicketException extends Exception{
	@Override
	public String toString() {
		return "Invalid ticket no.";
		
	}
}
