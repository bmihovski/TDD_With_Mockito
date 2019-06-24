package com.edu.chapter06;

public class Stock {

	private String id;
	private double lastValue;

	public Stock(String id, double lastValue) {
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
