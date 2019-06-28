package com.edu.chapter07;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.edu.chapter07.dao.FinancialTransactionDAO;
import com.edu.chapter07.dao.MembershipDAO;
import com.edu.chapter07.dto.MembershipStatusDto;
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
		
//		for (TransactionDto transactionDto : unSettledTxs) {
//			double payableAmount = transactionDto.getAmount() –
//			transactionDto.getAmount() * membership.getDeductable();
//			payPalFacade.sendAdvice(new PaymentAdviceDto(payableAmount,
//			transactionDto.getTargetPayPalId(), "Post payment for developer "+
//			transactionDto.getTargetId()));
//			}
		
//		 MembershipStatusDto membership = membershipDAO
//					.getStatusFor(transactionDto.getTargetId());
		
//		Consumer<PaymentAdviceDto> advice = m -> payPalFacade.sendAdvice(m);
//		
//		final List<MembershipStatusDto> membership = unSettledTxs.stream()
//											   .map(m -> membershipDAO.getStatusFor(m.getTargetId()))
//											   .collect(Collectors.toList());
//		
//	    Function<TransactionDto, Double> payableAmount = m -> transactionDto.getAmmount() -
//	    			transactionDto.getAmmount() * membershipDAO.getStatusFor(transactionDto.getTargetId()).getDeductive();
//		
//		unSettledTxs.stream()
//			.forEach(m -> advice.accept(new PaymentAdviceDto(payableAmount.apply(m), m.getTargetId(),
//					"Post payment for developer "+ m.getTargetPayPalId())));
		
		for (TransactionDto transactionDto : unSettledTxs) {
			MembershipStatusDto membership = membershipDAO
					.getStatusFor(transactionDto.getTargetId());
			double payableAmount = transactionDto.getAmmount() - transactionDto.getAmmount() * membership.getDeductive();
			payPalFacade.sendAdvice(new PaymentAdviceDto(payableAmount,
			transactionDto.getTargetPayPalId(), "Post payment for developer "+
			transactionDto.getTargetId()));
			}
		
//		payPalFacade.sendAdvice(new PaymentAdviceDto(0.00,
//				transactionDto.getTargetId(), transactionDto.getTargetPayPalId()));
		
		return unSettledTxs.size();
	}

}
