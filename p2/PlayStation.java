package p2;

class PlayStation extends ElectronicDevice implements PlayGames {

	@Override
	public void powerUsed(CircuitBoard cb) {
		int cbpower = cb.getPower();
		cbpower += 15;

		System.out.println("PlayStation consume " + cbpower + " unit");
	}

	@Override
	public void playGames() {
		System.out.println("can play games");
	}
}
