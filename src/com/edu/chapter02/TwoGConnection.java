package com.edu.chapter02;



public class TwoGConnection extends ClientNameAndNumber implements PhoneConnection {

	@Override
	public boolean activate(PersonName connectionForUserName, String number) {
		System.out.println("activating 2G for user= " + connectionForUserName.getFirstName() + " and number=" + number);
		numberAndNameMap.put(number, connectionForUserName);
		return true;
	}

	@Override
	public String generateBillFor(String number) {
		final PersonName person = numberAndNameMap.get(number);
		return "2G bill for " + person.getFirstName() + " " + person.getLastName() + " " + person.getMiddleName() + " " + person.getPrefix();
	} 

}
