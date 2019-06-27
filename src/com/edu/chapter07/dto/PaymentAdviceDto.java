package com.edu.chapter07.dto;

public class PaymentAdviceDto {
	private final double ammount;
	private final String desc;
	private final String targetPayPalId;
	
	public PaymentAdviceDto(double ammount, String desc, String targetPayPalId) {
		this.ammount = ammount;
		this.desc = desc;
		this.targetPayPalId = targetPayPalId;
	}

	public String getTargetPayPalId() {
		return targetPayPalId;
	}

	public String getDesc() {
		return desc;
	}

	public double getAmmount() {
		return ammount;
	}
	

}
