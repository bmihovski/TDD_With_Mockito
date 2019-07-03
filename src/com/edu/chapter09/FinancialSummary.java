package com.edu.chapter09;

import java.util.Date;


public class FinancialSummary extends BaseObject {
	
	public FinancialSummary(Long objectId) {
		super(objectId);
	}

	private static final long serialVersionUID = 1L;
	private Encounter encounter;
	private double amountDue;
	private Date lastPaymentDate;

	public double getAmmountDue() {
		return amountDue;
	}

}
