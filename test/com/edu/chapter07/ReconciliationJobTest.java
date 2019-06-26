package com.edu.chapter07;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.edu.chapter07.dao.FinancialTransactionDAO;
import com.edu.chapter07.dao.MembershipDAO;
import com.edu.chapter07.dto.MembershipStatusDTO;
import com.edu.chapter07.dto.TransactionDto;

@RunWith(MockitoJUnitRunner.class)
public class ReconciliationJobTest {
	
	@Mock
	ReconciliationJob job;
	@Mock
	FinancialTransactionDAO financialTransactionDAO;
	@Mock
	MembershipDAO membershipDAO;
	
	@Before
	public void setUp() {
		job = new ReconciliationJob(financialTransactionDAO, membershipDAO);
		MembershipStatusDTO basicMembership = new MembershipStatusDTO();
		
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
	
	public void when_transaction_exists_Then_membership_details_is_retrieved_for_the_developer() throws Exception {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setTargetId("DEV001");
		List<TransactionDto> singleList = Arrays.asList(transactionDto);
	}
	
}
