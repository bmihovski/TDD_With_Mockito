package com.edu.chapter04.ouside.in;

public class TaxConsultant {

	private final TaxbleIncomeCalculator taxbleIncomeCalculator;
	private final TaxCalculator calculator;
	
	public TaxConsultant(TaxbleIncomeCalculator taxbleIncomeCalculator, TaxCalculator calc) {
		this.taxbleIncomeCalculator = taxbleIncomeCalculator;
		this.calculator = calc;
	}

	public void consult(double totalIncome, double homeLoanInterest, double homeLoanPrincipal,
			double providentFundSavings, double lifeInsurancePremium) {
		double taxableIncome = taxbleIncomeCalculator.calculate(totalIncome, homeLoanInterest,
				homeLoanPrincipal, providentFundSavings, lifeInsurancePremium);
		double payableTax = calculator.calculate(taxableIncome);
		
	}

}
