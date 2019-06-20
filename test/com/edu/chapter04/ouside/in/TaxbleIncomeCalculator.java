package com.edu.chapter04.ouside.in;

public interface TaxbleIncomeCalculator {
	
	double calculate(double totalIncome, double homeLoanInterest, double homeLoanPrincipal,
				double providentFundSavings, double lifeInsurancePremium);

}
