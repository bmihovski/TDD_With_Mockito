package com.edu.chapter02;



public class FourGConnection extends ClientNameAndNumber implements PhoneConnection {

	@Override
	public boolean activate(PersonName connectionForUserName, String number) {
		System.out.println("activating 4G for user= " + connectionForUserName.getFirstName() + " and number= " + number);
		numberAndNameMap.put(number, connectionForUserName);
		return true;
	}

	@Override
	public String generateBillFor(String number) {
		final PersonName person = numberAndNameMap.get(number);
		return "4G bill for " + new PersonName().getFormattedName(person);
	} 

}
