package p2;

class SmartPhone extends ElectronicDevice implements PlayGames {

	public void powerUsed(CircuitBoard cb) {
		int cbpower = cb.getPower();
		cbpower += 5;

		System.out.println("SmartPhone consume " + cbpower + " unit" + " while charging");
	}

	@Override
	public void playGames() {
		System.out.println("can play games");
	}

}
