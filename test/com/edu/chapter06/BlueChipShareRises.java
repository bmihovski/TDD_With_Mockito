package com.edu.chapter06;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class BlueChipShareRises implements Answer<Double> {
	@Override
	public Double answer(InvocationOnMock invocation) {
		Object[] args = invocation.getArguments();
		Stock stock = (Stock) args[0];
		return stock.boughtAt() + 1.00;
	}
}
