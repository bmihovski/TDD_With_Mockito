package com.edu.chapter01;

public class TaxCalculator {

	public double calculate(double taxableIncome) {
		
		if (isIncomeIn30PercentTaxRange(taxableIncome)) {
			return deduct30PercentAbove10Lacs(taxableIncome) +
					calculate(1_000_000);
		}
		
		if (isIncomeIn20PercentTaxRange(taxableIncome)) {
			return deduct20PercentAbove5Lacs(taxableIncome) +
					calculate(500_000);
		}
		
		return (taxableIncome * .10);
	}

	private double deduct20PercentAbove5Lacs(double taxableIncome) {
		return (taxableIncome - 500_000) * .2;
	}

	private double deduct30PercentAbove10Lacs(double taxableIncome) {
		return (taxableIncome - 1_000_000) * .3;
	}

	private boolean isIncomeIn20PercentTaxRange(double taxableIncome) {
		return taxableIncome > 500_000;
	}

	private boolean isIncomeIn30PercentTaxRange(double taxableIncome) {
		return taxableIncome > 1_000_000;
	}

}
