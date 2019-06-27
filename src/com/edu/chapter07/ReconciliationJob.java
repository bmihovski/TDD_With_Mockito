package com.edu.chapter07;

import java.util.List;
import java.util.stream.Collectors;

import com.edu.chapter07.dao.FinancialTransactionDAO;
import com.edu.chapter07.dao.MembershipDAO;
import com.edu.chapter07.dto.PaymentAdviceDto;
import com.edu.chapter07.dto.TransactionDto;

public class ReconciliationJob {
	
	private final FinancialTransactionDAO financialTxDAO;
	
	private final MembershipDAO membershipDAO;
	
	private final PayPalFacade payPalFacade;
	
	private final TransactionDto transactionDto;
	
	public ReconciliationJob(FinancialTransactionDAO financialTransactionDAO,
			MembershipDAO membershipDAO, PayPalFacade payPalFacade, TransactionDto transactionDto) {
		this.financialTxDAO = financialTransactionDAO;
		this.membershipDAO = membershipDAO;
		this.payPalFacade = payPalFacade;
		this.transactionDto = transactionDto;
	}

	public int reconcile() {
		List<TransactionDto> unSettledTxs = financialTxDAO.retrieveUnSettledTransactions();
		
		for (TransactionDto transactionDto : unSettledTxs) {
			double payableAmount = transactionDto.getAmmount() –
			transactionDto.getAmount() * membership.getDeductable();
			payPalFacade.sendAdvice(new PaymentAdviceDto(payableAmount,
			transactionDto.getTargetPayPalId(), "Post payment for developer "+
			transactionDto.getTargetId()));
			}
		
		final double membership =unSettledTxs.stream()
					.map(m -> membershipDAO.getStatusFor(m.getTargetId()))
					.collect(Collectors.toList());
		
		payPalFacade.sendAdvice(new PaymentAdviceDto(0.00,
				transactionDto.getTargetId(), transactionDto.getTargetPayPalId()));
		
		return unSettledTxs.size();
	}

}
