package com.edu.chapter06;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class doAnswerTest {

	@Mock
	StockBroker broker;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void doAnswer_void_methods() throws Exception {
		Stock myStock = new Stock("A2", 0.00);
		
		doAnswer(new Answer<Double>() {
			public Double answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Stock stock = (Stock) args[0];
				// changing the value of stock to 100.00
				stock.changePrice(100.00);
				return null;
			}
		}).when(broker).buy(myStock, 10);
		
		assertTrue(0.00 == myStock.boughtAt());
		
		broker.buy(myStock, 10);
		
		assertTrue(100.00 == myStock.boughtAt());
	}
}
