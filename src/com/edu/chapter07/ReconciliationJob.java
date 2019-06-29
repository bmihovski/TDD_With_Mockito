package com.edu.chapter07;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

	public ReconciliationJob(FinancialTransactionDAO financialTransactionDAO, MembershipDAO membershipDAO,
			PayPalFacade payPalFacade, TransactionDto transactionDto) {
		this.financialTxDAO = financialTransactionDAO;
		this.membershipDAO = membershipDAO;
		this.payPalFacade = payPalFacade;
		this.transactionDto = transactionDto;
	}

	public int reconcile() {
		List<TransactionDto> unSettledTxs = financialTxDAO.retrieveUnSettledTransactions();
		
		Map<String, List<TransactionDto>> developerTxMap = new LinkedHashMap<String, List<TransactionDto>>();
		
		//Setting a developer wise Transaction map 
		
		for (TransactionDto transactionDto : unSettledTxs) {
			List<TransactionDto> transactions = developerTxMap.get(transactionDto.getTargetId());
			
			if (transactions == null) {
				transactions = new ArrayList<TransactionDto>();
			}
			transactions.add(transactionDto);
			developerTxMap.put(transactionDto.getTargetId(), transactions);
		}
		
		// Looping throught the developer Id, only once PayPal is called
		
		for (String developerId : developerTxMap.keySet()) {
			MembershipStatusDto membership = membershipDAO.getStatusFor(developerId);
			String payPalId = null;
			double totalTxAmount = 0.00;
			for (TransactionDto tx : developerTxMap.get(developerId)) {
				totalTxAmount += tx.getAmount();
				payPalId = tx.getTargetPayPalId();
			}
			
			double payableAmount = totalTxAmount - totalTxAmount * membership.getDeductable();
			payPalFacade.sendAdvice(new PaymentAdviceDto(payableAmount, payPalId, null));
			
		}
			
		
		return unSettledTxs.size();
	}

}
