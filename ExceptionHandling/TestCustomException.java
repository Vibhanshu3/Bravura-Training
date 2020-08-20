package ExceptionHandling;

import java.util.Scanner;

public class TestCustomException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of ticket purchased :");
		int ticketPurchased = sc.nextInt();

		TestCustomException t = new TestCustomException();

		try {
			t.ticketBooking(ticketPurchased);

		} catch (OutofTicketException e) {
			System.out.println(e.toString());

		}
	}

	public void ticketBooking(int ticketPurchased) throws OutofTicketException {
		if (ticketPurchased > 6) {
			throw new OutofTicketException();

		} else {
			System.out.println(ticketPurchased);

		}
	}

}
