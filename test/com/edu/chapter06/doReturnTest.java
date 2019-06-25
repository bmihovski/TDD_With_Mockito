package com.edu.chapter06;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class doReturnTest {

	@Mock
	StockBroker broker;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void doReturn_usage() {
		List<String> list = new ArrayList<String>();

		List<String> spy = Mockito.spy(list);

		// Imposible: real method is called so spy.get(0) throws
		// IndexOutOfBoundsException (the list is yet empty)
		// commented out to keep test green
		// when(spy.get(0)).thenReturn("foo");
		// You have to use doReturn() for stubbing:
		doReturn("foo").when(spy).get(0);
		assertEquals("foo", spy.get(0));
	}

	// @Test
	public void doReturn_is_not_type_safe() throws Exception {
		// get Quote return double
		when(broker.getQuote(isA(Stock.class))).thenReturn(5.00);
		// returning string for getQuote..although return type is double
		doReturn("string").when(broker).getQuote(isA(Stock.class));
		broker.getQuote(new Stock("A1", 40.00));
	}
}
