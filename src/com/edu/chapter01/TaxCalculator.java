package com.edu.chapter01;

public class TaxCalculator {

	public double calculate(double taxableIncome) {
		
		if (taxableIncome > 500_000.00) {
			return 50_000 + ((taxableIncome - 500_000) / 5);
		}
		
		return taxableIncome / 10;
	}

}
