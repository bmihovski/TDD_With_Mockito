package com.edu.chapter02;

import static org.junit.Assert.fail;

import org.junit.Test;

public class OnceYouBuyYouStartCryingTelephoneTest {
	
	OnceYouBuyYouStartCryingTelephone telephone = new OnceYouBuyYouStartCryingTelephone();
	
	@Test(expected = RuntimeException.class)
	public void when_input_a_is_null_then_throws_exception() throws Exception {
		telephone.add(null, null, null, null, null, 0);
		
		fail("Code should not reach here!");
	}

}
