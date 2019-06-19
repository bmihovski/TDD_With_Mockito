package com.edu.chapter02;

public class PersonName {
	private String firstName;
	private String prefix;
	private String middleName;
	private String lastName;

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

}