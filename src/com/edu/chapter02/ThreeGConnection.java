package com.edu.chapter02;



public class ThreeGConnection extends ClientNameAndNumber implements PhoneConnection {

	@Override
	public boolean activate(PersonName connectionForUserName, String number) {
		System.out.println("activationg 3G foruser= " + connectionForUserName.getFirstName() + " and number= " + number);
		numberAndNameMap.put(number, connectionForUserName);
		return true;
	}

	@Override
	public String generateBillFor(String number) {
		final PersonName person = numberAndNameMap.get(number);
		return "3G bill for " + person.getFirstName() + " " + person.getLastName() + " " + person.getMiddleName() + " " + person.getPrefix();
	}

}
