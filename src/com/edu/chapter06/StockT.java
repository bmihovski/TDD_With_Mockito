package com.edu.chapter06;

public class StockT {

	private String id;
	private double lastValue;

	public StockT(String id, double lastValue) {
		this.id = id;
		this.lastValue = lastValue;
	}

	public double boughtAt() {
		return lastValue;
	}

	public Object getId() {
		return id;
	}

}
