package com.edu.chapter02;

public interface PhoneConnection {

	boolean activate(String connectionForUserName, String number);
	String generateBillFor(String number);
	
	public enum ConnectionType {
		TWO_G(), THREE_G(), FOUR_G();
	}
	
}
