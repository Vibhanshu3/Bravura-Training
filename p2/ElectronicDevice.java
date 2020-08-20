package p2;

public abstract class ElectronicDevice {
	
	public void useElectricity() {
		System.out.println("Uses Electricity");
	}

	public void motherBoardProcessing() {
		System.out.println("Uses Motherboard for processing");
	}

	abstract public void powerUsed(CircuitBoard cb);
	

}
