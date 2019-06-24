package com.edu.chapter06;

import org.mockito.ArgumentMatcher;

public class BlueChipStockMatcher extends ArgumentMatcher<Stock> {
	@Override
	public boolean matches(Object argument) {
		Stock myStock = (Stock) argument;
		return "SBI".equals(myStock.getId()) ||
			   "HDFC".equals(myStock.getId());
	}
}
