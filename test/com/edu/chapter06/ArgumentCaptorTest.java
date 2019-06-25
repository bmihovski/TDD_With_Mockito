package com.edu.chapter06;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ArgumentCaptorTest {
	
	@Mock
	StockBroker broker;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void argument_captor() throws Exception {
		// Creating a captor for Stock class
		ArgumentCaptor<Stock> argument = ArgumentCaptor.forClass(Stock.class);
		// Calling a method on mock object
		broker.getQuote(new Stock("A", 5.00));
		
		// Passing argument captor to verify to collect the argument
		verify(broker).getQuote(argument.capture());
		
		// Comfirm that "A" was passed
		assertEquals("A", argument.getValue().getId());
	}

}
