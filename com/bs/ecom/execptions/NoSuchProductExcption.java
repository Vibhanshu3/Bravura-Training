package com.bs.ecom.execptions; 	 	

public class NoSuchProductExcption extends Exception {
	String exceptionMsg;

	public NoSuchProductExcption(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	@Override
	public String toString() {
		return "NoSuchProductExcption [exceptionMsg=" + exceptionMsg + "]";
	}
}
