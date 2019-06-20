package com.edu.chapter04.ouside.in;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaxConsultantTest {
	
	@Mock
	TaxbleIncomeCalculator taxbleIncomeCalculator;
	@Mock
	TaxCalculator taxCalculator;

	TaxConsultant consultant;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		consultant = new TaxConsultant(taxbleIncomeCalculator, taxCalculator);

	}
	
	@Test
	public void when_deductable_present_then_taxable_income_is_less_than_the_total_income() {
		
		double totalIncome = 1_200_000;
		double homeLoanInterest = 150_000;
		double homeLoanPrincipal = 20_000;
		double providentFundSavings = 50_000;
		double lifeInsurancePremium = 30_000;
		
		consultant.consult(totalIncome, homeLoanInterest, homeLoanPrincipal,
				providentFundSavings, lifeInsurancePremium);
		
		verify(taxbleIncomeCalculator, only())
			.calculate(eq(totalIncome), eq(homeLoanInterest),
						eq(homeLoanPrincipal), eq(providentFundSavings),
						eq(lifeInsurancePremium));
		
		verify(taxCalculator, only()).calculate(anyDouble());
		
	}
}
