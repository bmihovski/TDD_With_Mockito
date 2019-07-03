package com.edu.chapter09;

import java.util.Date;

public class Encounter extends BaseObject {

	private static final long serialVersionUID = 1L;
	
	public Encounter(Long objectId) {
		super(objectId);
	}

	private String encounterId;
	private Date startDate;
	private Date stopDate;
	private FinancialSummary financialSummary;
	private Patient patient;

	public FinancialSummary getFinancialSummary() {
		return financialSummary;
	}

	public Patient getPatient() {
		return patient;
	}
	
}
