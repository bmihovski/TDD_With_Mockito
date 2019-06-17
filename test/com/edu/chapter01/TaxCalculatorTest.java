package com.edu.chapter01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaxCalculatorTest {

	@Test
	public void when_income_less_than_5lacs_then_deducts_10_percent_tax() {
		TaxCalculator taxCalculator = new TaxCalculator();
		
		double payableTax = taxCalculator.calculate(400_000.00);
		
		assertTrue(40000 == payableTax);
		
		payableTax = taxCalculator.calculate(0);
		
		assertTrue(0 == payableTax);
		
		payableTax = taxCalculator.calculate(500000.00);
		
		assertTrue(50000 == payableTax);
		
	}

	@Test
	public void when_income_between_5lacs_and_10lacs_then_deducts_fifty_thousand_plus_20_percent_above_5lacs() {
		
		TaxCalculator taxCalculator = new TaxCalculator();
		
		final double payableTax800k = taxCalculator.calculate(800_000.00);
		final double expectedTaxForFirstFiveHundredThousand = 50_000;
		final double expectedTaxForReminder = 60_000;
		final double expectedTotalTax =
				expectedTaxForFirstFiveHundredThousand +
						expectedTaxForReminder;
		assertTrue(expectedTotalTax == payableTax800k);
		
		final double payableTax900k = taxCalculator.calculate(900_000.00);
		
		final double expectedTotalTax900k = 130_000;
		
		assertTrue(expectedTotalTax900k == payableTax900k);
		
		final double payableTax1mil = taxCalculator.calculate(1_000_000.00);
		
		final double expectedTotalTax1mil = 150_000.00;
		
		assertTrue(expectedTotalTax1mil == payableTax1mil);
	}
}
