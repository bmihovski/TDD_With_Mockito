package com.edu.chapter04.outside.in;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import come.edu.chapter04.outside.in.TaxCalculator;
import come.edu.chapter04.outside.in.TaxConsultant;
import come.edu.chapter04.outside.in.TaxbleIncomeCalculator;

@RunWith(MockitoJUnitRunner.class)
public class TaxConsultantTest {

	@Mock
	TaxbleIncomeCalculator taxableIncomeCalculator;
	@Mock
	TaxCalculator taxCalculator;

	TaxConsultant consultant;

	@Before
	public void setUp() {
		consultant = new TaxConsultant(taxableIncomeCalculator, taxCalculator);
	}

	@Test
	public void when_deductable_present_then_taxable_income_is_less_than_the_total_income() {
		double totalIncome = 1200000;
		double homeLoanInterest = 150000;
		double homeLoanPrincipal = 20000;
		double providentFundSavings = 50000;
		double lifeInsurancePremium = 30000;

		consultant.consult(totalIncome, homeLoanInterest, homeLoanPrincipal, providentFundSavings,
				lifeInsurancePremium);
		verify(taxableIncomeCalculator, only()).calculate(eq(totalIncome), eq(homeLoanInterest), eq(homeLoanPrincipal),
				eq(providentFundSavings), eq(lifeInsurancePremium));
		verify(taxCalculator, only()).calculate(anyDouble());
	}

	@Test
	public void when_when_total_income_is_taxable_then_taxable_income_is_total_income() {

	}

	@Test
	public void when_investment_is_250000_then_taxable_income_is_reduced_by_twentyfive_hundred_thousand()
			throws Exception {

	}
}
