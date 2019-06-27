package com.edu.chapter07.dto;

public class TransactionDto {

	private String targetId;
	private String targetPayPalId;
	private double ammount;
	
	public String getTargetPayPalId() {
		return targetPayPalId;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setTargetPayPalId(String targetPayPalId) {
		this.targetPayPalId = targetPayPalId;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}


	
	
}
