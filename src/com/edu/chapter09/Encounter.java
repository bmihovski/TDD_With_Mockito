package com.edu.chapter09;

import java.util.Date;

public class Encounter extends BaseObject {

	private static final long serialVersionUID = 1L;
	
	public Encounter(Long objectId) {
		super(objectId);
	}

	public Encounter(Long objectId, boolean isInit) {
		super(objectId, isInit);
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

	public void setStartDate(Date startDate) {
		this.startDate = startDate;		
	}

	public Date getStartDate() {
		return startDate;
	}

	public void addCharge(EncounterCharges aCharge) {
		DataAccessFacade.addChargeFor(this, aCharge);
	}

	public String getEncounterId() {
		return encounterId;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public void setFinancialSummary(FinancialSummary financialSummary) {
		this.financialSummary = financialSummary;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
