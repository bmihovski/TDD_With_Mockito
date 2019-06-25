package com.edu.chapter06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class StockListenerTest {
	StockListener listener;
	
	@Mock
	StockBroker stockBroker;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		listener = new StockListener(stockBroker);
	}
	
	@Test
	public void sells_BlueChips_Stock() throws Exception {
		when(stockBroker.getQuote(argThat(new BlueChipStockMatcher()))).thenReturn(1000.00);
		listener.takeAction(new Stock("SBI", 500.00));
		verify(stockBroker).sell(isA(Stock.class), anyInt());
	}
	
	@Test
	public void buy_low_Stocks() {
		when(stockBroker.getQuote(argThat(new BlueChipStockMatcher()))).thenReturn(1000.00);
		listener.takeAction(new Stock("XYZ", 500.00));
		verify(stockBroker).buy(isA(Stock.class), anyInt());
	}

	@Test
	public void sells_BlueChip_Stocks_WITH_answer_object() throws Exception {
		when(stockBroker.getQuote(argThat(new BlueChipStockMatcher())))
			.then(new BlueChipShareRises());
		listener.takeAction(new Stock("SBI", 1000.00));
		verify(stockBroker).sell(isA(Stock.class), anyInt());
	}
	
	@Test
	public void spyTest() {
		Stock realStock = new Stock("ICICI", 30.00);
		Stock spy = Mockito.spy(realStock);
		
		// call real method from spy
		assertEquals("ICICI", spy.getId());
		
		// changing value using spy
		spy.changePrice(100.00);
		
		// verify spy has the changed value
		assertTrue(100.00 == spy.boughtAt());
		
		    // Stubbing method
		when(spy.boughtAt()).thenReturn(5.00);
		//changing value using spy
		spy.changePrice(777.00);
		// Stubbed method value returned
		assertTrue(777.00 != spy.boughtAt());
		assertTrue(5.00 == spy.boughtAt());
		
	}
	
	@Test
	public void doReturn_is_not_type_safe() throws Exception {
		// get Quote return double
		when(stockBroker.getQuote(isA(Stock.class))).thenReturn(5.00);
		// returning string for getQuote..although return type is double
		// commented out to keep test green
		//doReturn("string").when(stockBroker).getQuote(isA(Stock.class));
		doReturn(1.00).when(stockBroker).getQuote(isA(Stock.class));
		stockBroker.getQuote(new Stock("A1", 40.00));

	}
	
	@Test
	public void doReturn_usage() throws Exception {
		
		List<String> list = new ArrayList<String>();
		List<String> spy = Mockito.spy(list);
		
		// Imposible: real method is called so spy.get(0) throws
		// IndexOutOfBoundsException (the list is yet empty)
		// commented out to keep test green
		//when(spy.get(0)).thenReturn("foo");
		doReturn("foo").when(spy).get(0);
		assertEquals("foo", spy.get(0));
	}
}
