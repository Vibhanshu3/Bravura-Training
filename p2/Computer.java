package p2;

class Computer extends ElectronicDevice implements PlayGames {

	@Override
	public void powerUsed(CircuitBoard cb) {
		int cbpower = cb.getPower();
		cbpower += 20;

		System.out.println("Computer consume " + cbpower + " unit");
	}

	@Override
	public void playGames() {
		System.out.println("can play games");
	}

}
