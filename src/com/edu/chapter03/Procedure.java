package com.edu.chapter03;

import java.math.BigDecimal;

public class Procedure {

	String id;
	String name;
	BigDecimal price;
	
	public Procedure(String id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

}
