package p2;

class Laptop extends ElectronicDevice implements PlayGames {

	public void powerUsed(CircuitBoard cb) {
		int cbpower = cb.getPower();
		cbpower += 10;

		System.out.println("Laptop consume " + cbpower + " unit");
	}

	@Override
	public void playGames() {
		System.out.println("can play games");
	}

}
