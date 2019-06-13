package com.edu.chapter01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxCalculatorTest {

	@Test
	public void when_income_less_than_5Lacs_then_deducts_10_percent_tax() {
		TaxCalculator taxCalculator = new TaxCalculator();
		
		double payableTax = taxCalculator.calculate(400000.00);
		
		assertTrue(400000 == payableTax);
	}

}
