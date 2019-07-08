package com.edu.chapter09;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentHandlerTest {

	PaymentHandler handler;
	@Mock
	Patient patient;
	List<Encounter> encounters;

	
	@Before
	public void setUp() {
		encounters = new ArrayList<Encounter>();
		handler = new TestablePaymentHandler(1L);
	}
	
	@Test
	public void sanity() throws Exception {
		// This empty test ensures that legacy objects get instantiated
	}
	
	class TestablePaymentHandler extends PaymentHandler {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TestablePaymentHandler(Long objectId) {
			super(objectId, false);
		}
		
		protected List<Encounter> getEncounters() {
			return encounters;
		}
	}

}
