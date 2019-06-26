package com.edu.chapter07.dao;

import java.util.List;

import com.edu.chapter07.dto.TransactionDto;

public interface FinancialTransactionDAO {

	List<TransactionDto> retrieveUnSettledTransactions();

	
}
