package p2;

import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MainMethod operations = new MainMethod();
		int userChoice = 0;

		do {
			System.out.println("1. For Laptop");
			System.out.println("2. For Washing Machine");
			System.out.println("3. For Computer");
			System.out.println("4. For SmartPhone");
			System.out.println("5. For PlayStation");
			System.out.println("0 For Exit");
			userChoice = sc.nextInt();

			switch (userChoice) {
			case 1:
				Laptop hpLaptop = new Laptop();
				operations.useMachine(hpLaptop);
				break;

			case 2:
				WashingMachine washingMachine = new WashingMachine();
				operations.useMachine(washingMachine);
				break;

			case 3:
				Computer computer = new Computer();
				operations.useMachine(computer);
				break;

			case 4:
				SmartPhone smartPhone = new SmartPhone();
				operations.useMachine(smartPhone);
				break;

			case 5:
				PlayStation playStation = new PlayStation();
				operations.useMachine(playStation);
				break;

			case 0:
				System.out.println("Thank you, Now Exiting!!");
				break;

			default:
				System.out.println("Invalid Input!!");

			}

		} while (userChoice != 0);
	}

	public void useMachine(ElectronicDevice e) {

		System.out.println("FEATURES");

		if (e instanceof Laptop) {
			e.useElectricity();
			e.motherBoardProcessing();
			e.powerUsed(new CircuitBoard());
			Laptop l = (Laptop) e;
			l.playGames();

		} else if (e instanceof Computer) {
			e.useElectricity();
			e.motherBoardProcessing();
			e.powerUsed(new CircuitBoard());
			Computer c = (Computer) e;
			c.playGames();

		} else if (e instanceof SmartPhone) {
			e.useElectricity();
			e.motherBoardProcessing();
			e.powerUsed(new CircuitBoard());
			SmartPhone s = (SmartPhone) e;
			s.playGames();

		} else if (e instanceof PlayStation) {
			e.useElectricity();
			e.motherBoardProcessing();
			e.powerUsed(new CircuitBoard());
			PlayStation p = (PlayStation) e;
			p.playGames();

		} else if (e instanceof WashingMachine) {
			e.useElectricity();
			e.motherBoardProcessing();
			e.powerUsed(new CircuitBoard());

		}
		System.out.println();

	}
}
