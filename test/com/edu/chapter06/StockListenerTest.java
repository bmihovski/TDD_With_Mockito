package com.edu.chapter06;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StockListenerTest {
	StockListener listener;
	
	@Mock
	StockBrocker brocker;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		listener = new StockListener(brocker);
	}
	
	@Test
	public void sells_BlueChips_Stock() throws Exception {
		when(brocker.getQuote(argThat(new BlueChipStockMatcher()))).thenReturn(1000.00);
		listener.takeAction(new Stock("SBI", 500.00));
		verify(brocker).sell(isA(Stock.class), anyInt());
	}
	
	@Test
	public void buy_low_Stocks() {
		when(brocker.getQuote(argThat(new BlueChipStockMatcher()))).thenReturn(1000.00);
		listener.takeAction(new Stock("XYZ", 500.00));
		verify(brocker).buy(isA(Stock.class), anyInt());
	}

}
