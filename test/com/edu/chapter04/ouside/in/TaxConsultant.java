package com.edu.chapter04.ouside.in;

public class TaxConsultant {

	public final TaxbleIncomeCalculator taxbleIncomeCalculator;
	public final TaxCalculator calc;
	public TaxConsultant(TaxbleIncomeCalculator taxbleIncomeCalculator, TaxCalculator calc) {
		this.taxbleIncomeCalculator = taxbleIncomeCalculator;
		this.calc = calc;
	}

	public void consult(double totalIncome, double homeLoanInterest, double homeLoanPrincipal,
			double providentFundSavings, double lifeInsurancePremium) {
		double taxableIncome = taxbleIncomeCalculator.calculate(totalIncome, homeLoanInterest,
				homeLoanPrincipal, providentFundSavings, lifeInsurancePremium);
		double payableTax = calc.calculate(taxableIncome);
		
	}

}
