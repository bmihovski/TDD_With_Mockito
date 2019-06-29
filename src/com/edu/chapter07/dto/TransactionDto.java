package com.edu.chapter07.dto;

public class TransactionDto {

	private String targetId;
	private String targetPayPalId;
	private double amount;
	
	public String getTargetPayPalId() {
		return targetPayPalId;
	}

	public double getAmount() {
		return amount;
	}

	public void setTargetPayPalId(String targetPayPalId) {
		this.targetPayPalId = targetPayPalId;
	}

	public void setAmount(double ammount) {
		this.amount = ammount;
	}
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}


	
	
}
