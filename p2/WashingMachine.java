package p2;

class WashingMachine extends ElectronicDevice {

	@Override
	public void powerUsed(CircuitBoard cb) {
		int cbpower = cb.getPower();
		cbpower += 25;

		System.out.println("Washing Machine consume " + cbpower + " unit");
	}

}
