package com.edu.chapter02;

public class PersonName {
	private String firstName;
	private String prefix;
	private String middleName;
	private String lastName;
	private static final String SPACE = " ";
	
	public PersonName() {}

	public PersonName(String firstName, String prefix, String middleName, String lastName) {
		this.firstName = firstName;
		this.prefix = prefix;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	protected String buildName(PersonName name) {
		StringBuilder personName = new StringBuilder();
		if (name.getFirstName() != null) {
			personName.append(name.getFirstName()).append(SPACE);
		}

		if (name.getPrefix() != null) {
			personName.append(name.getPrefix()).append(SPACE);
		}
		
		if (name.getMiddleName() != null) {
			personName.append(name.getMiddleName()).append(SPACE);
		}
		if (name.getLastName() != null) {
			personName.append(name.getLastName());
		}
		return personName.toString();
	}

}