package com.edu.chapter07;

import java.util.List;
import java.util.stream.Collectors;

import com.edu.chapter07.dao.FinancialTransactionDAO;
import com.edu.chapter07.dao.MembershipDAO;
import com.edu.chapter07.dto.TransactionDto;

public class ReconciliationJob {
	
	private final FinancialTransactionDAO financialTxDAO;
	
	private final MembershipDAO membershipDAO;
	
	public ReconciliationJob(FinancialTransactionDAO financialTransactionDAO, MembershipDAO membershipDAO) {
		this.financialTxDAO = financialTransactionDAO;
		this.membershipDAO = membershipDAO;
	}

	public int reconcile() {
		List<TransactionDto> unSettledTxs = financialTxDAO.retrieveUnSettledTransactions();
		
		unSettledTxs.stream()
					.map(m -> membershipDAO.getStatusFor(m.getTargetId()))
					.collect(Collectors.toList());
		
		return unSettledTxs.size();
	}

}
