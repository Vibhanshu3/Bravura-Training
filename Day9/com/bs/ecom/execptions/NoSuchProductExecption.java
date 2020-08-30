package Day9.com.bs.ecom.execptions;

public class NoSuchProductExecption extends Exception {
	String exceptionMsg;

	public NoSuchProductExecption(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	@Override
	public String toString() {
		return "NoSuchProductExcption [exceptionMsg=" + exceptionMsg + "]";
	}
}