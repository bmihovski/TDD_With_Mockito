package com.edu.chapter07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;

import com.edu.chapter07.dao.FinancialTransactionDAO;
import com.edu.chapter07.dao.MembershipDAO;
import com.edu.chapter07.dto.MembershipStatusDto;
import com.edu.chapter07.dto.PaymentAdviceDto;
import com.edu.chapter07.dto.TransactionDto;

@RunWith(MockitoJUnitRunner.class)
public class ReconciliationJobTest {
	
	@Mock
	ReconciliationJob job;
	@Mock
	FinancialTransactionDAO financialTransactionDAO;
	@Mock
	MembershipDAO membershipDAO;
	@Mock
	PayPalFacade payPalFacade;
	@Mock
	TransactionDto transactionDto;
	
	@Before
	public void setUp() {
		job = new ReconciliationJob(financialTransactionDAO, membershipDAO, payPalFacade, transactionDto);
		MembershipStatusDto basicMembership = new MembershipStatusDto();
		
		basicMembership.setDeductive(.30);
		when(membershipDAO.getStatusFor(anyString()))
						  .thenReturn(basicMembership);
	}
	
	@Test
	public void when_no_Transaction_To_Process_Job_RETURNS_Processing_Count_Zero() throws Exception {
		assertEquals(0, job.reconcile());
	}

	@Test
	public void reconcile_returns_Transaction_count() throws Exception {
		List<TransactionDto> singleTxList = Arrays.asList(new TransactionDto());
		
		when(financialTransactionDAO.retrieveUnSettledTransactions()).thenReturn(singleTxList);
		
		assertEquals(1, job.reconcile());
	}
	
	@Test
	public void when_transaction_exists_Then_membership_details_is_retrieved_for_the_developer() throws Exception {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setTargetId("DEV001");
		List<TransactionDto> singleList = Arrays.asList(transactionDto);
		when(financialTransactionDAO.retrieveUnSettledTransactions())
									.thenReturn(singleList);
		
		assertEquals(1, job.reconcile());
		verify(membershipDAO).getStatusFor(anyString());
	}
	
	@Test
	public void when_transactions_exist_then_membership_details_is_retrieved_for_each_developer() 
		throws Exception {
		
		TransactionDto johnsTransaction = new TransactionDto();
		String johnsDeveloperId = "john001";
		johnsTransaction.setTargetId(johnsDeveloperId);
		TransactionDto bobsTransaction = new TransactionDto();
		String bobsDeveloperId = "bob999";
		bobsTransaction.setTargetId(bobsDeveloperId);
		List<TransactionDto> multipleTxs = Arrays.asList(johnsTransaction, bobsTransaction);
		
		when(financialTransactionDAO.retrieveUnSettledTransactions())
									.thenReturn(multipleTxs);
		assertEquals(2, job.reconcile());
		
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
		
		verify(membershipDAO, new Times(2)).getStatusFor(argCaptor.capture());
		List<String> passedValues = argCaptor.getAllValues();
		
		assertEquals(johnsDeveloperId, passedValues.get(0));
		assertEquals(bobsDeveloperId, passedValues.get(1));
		
	}
	
	@Test
	public void when_transaction_exists_Then_sends_Payble_TO_PayPal() throws Exception {
		
		final String davidsDeveloperId = "dev999";
		final String davidsPayPalId = "david@paypal.com";
		final double davidsSuperMarioGamePrice = 100.00;
		
		List<TransactionDto> davidsTransactionList = Arrays.asList(createTxDto(
				davidsDeveloperId, davidsPayPalId, davidsSuperMarioGamePrice));
		
		when(financialTransactionDAO.retrieveUnSettledTransactions()).thenReturn(davidsTransactionList);
		
		assertEquals(1, job.reconcile());
		
		verify(payPalFacade).sendAdvice(isA(PaymentAdviceDto.class));
		
	}
	
	@Test
	public void calculates_payable() throws Exception {
		final String ronaldosDeveloperId = "ronaldo007";
		final String ronaldosPayPalId = "ronaldo@real.madrid.com";
		final double ronaldosSockerFee = 100.00;
		
		List<TransactionDto> ronaldosTransactionList = Arrays.asList(createTxDto(ronaldosDeveloperId,
				ronaldosPayPalId, ronaldosSockerFee));
		
		when(financialTransactionDAO.retrieveUnSettledTransactions())
			.thenReturn(ronaldosTransactionList);
		
		assertEquals(1, job.reconcile());
		
		ArgumentCaptor<PaymentAdviceDto> calculateAdvice = 
				ArgumentCaptor.forClass(PaymentAdviceDto.class);
		verify(payPalFacade).sendAdvice(calculateAdvice.capture());
		
		assertTrue(70.00 == calculateAdvice.getValue().getAmmount());
	}

	@Test
	public void calculates_payable_with_multiple_Transaction() throws Exception {
		
		String johnsDeveloperId = "john001";
		String johnsPayPalId = "john@gmail.com";
		double johnsGameFee = 200;
		
		String davesDeveloperId = "dave888";
		String davesPayPalId = "IamDave009@rf.ce";
		double davesGameFee = 150;
		
		List<TransactionDto> transactionList = Arrays.asList(createTxDto(johnsDeveloperId, johnsPayPalId, johnsGameFee),
				createTxDto(davesDeveloperId, davesPayPalId, davesGameFee)); 
		
		when(financialTransactionDAO.retrieveUnSettledTransactions())
			.thenReturn(transactionList);
		
		when(membershipDAO.getStatusFor(eq(johnsDeveloperId))).thenReturn(membership(.15));
		when(membershipDAO.getStatusFor(eq(johnsDeveloperId))).thenReturn(membership(.10));
		
		assertEquals(2, job.reconcile());
		
		ArgumentCaptor<PaymentAdviceDto> calcultateAdvice = 
				ArgumentCaptor.forClass(PaymentAdviceDto.class);
		
		verify(payPalFacade, new Times(2)).sendAdvice(calcultateAdvice.capture());
		
		assertTrue(120.00 == calcultateAdvice.getAllValues().get(0).getAmmount());
		
		assertTrue(135.00 == calcultateAdvice.getAllValues().get(1).getAmmount());
		
	}
	
	private TransactionDto createTxDto(String devId, String payPalId, double gamePrice) {
		
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setTargetId(devId);
		transactionDto.setTargetPayPalId(payPalId);
		transactionDto.setAmmount(gamePrice);
		
		return transactionDto;
	}
	
}
