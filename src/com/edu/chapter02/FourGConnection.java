package com.edu.chapter02;

import java.util.HashMap;
import java.util.Map;

public class FourGConnection implements PhoneConnection {

	private Map<String, String> numberAndNameMap = new HashMap<String, String>();
	
	@Override
	public boolean activate(String connectionForUserName, String number) {
		System.out.println("activating 4G for user=" + connectionForUserName + "and number=" + number);
		numberAndNameMap.put(number, connectionForUserName);
		return true;
	}

	@Override
	public String generateBillFor(String number) {
		return "4G bill for " + numberAndNameMap.get(number);
	} 

}
