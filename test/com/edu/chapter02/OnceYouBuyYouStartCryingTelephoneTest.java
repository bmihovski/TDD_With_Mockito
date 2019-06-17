package com.edu.chapter02;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

public class OnceYouBuyYouStartCryingTelephoneTest {
	
	OnceYouBuyYouStartCryingTelephone telephone = new OnceYouBuyYouStartCryingTelephone();
	
	@Test(expected = RuntimeException.class)
	public void when_input_first_name_is_null_then_throws_exception() throws Exception {
		telephone.addConnection(null, null, null, null, null, 0);
		
		fail("Code should not reach here!");
	}

	@Test(expected = RuntimeException.class)
	public void when_input_last_name_is_null_then_throws_exception() throws Exception {
		telephone.addConnection("ivan", null, null, null, null, 0);
		
		fail("code should not reach here");
	}
	
	@Test(expected = RuntimeException.class)
	public void when_input_z_is_null_then_throws_exception() throws Exception {
		telephone.addConnection("gee", null, null, "ned", null, 0);
		
		fail("code should not reach here");
	}
	
	@Test(expected = RuntimeException.class)
	public void when_input_gen_is_invalid_then_throws_exception() throws Exception {
		telephone.addConnection("isew", null, null, "ens", new Date(), 0);
		
		fail("code should not reach here");
	}
	
	public void when_valid_input_then_adds_input() throws Exception {
		assertNotNull(telephone.addConnection("esd", null, null, "eswq", new Date(), OnceYouBuyYouStartCryingTelephone.THREE_G));
	}
	
	public void when_all_name_atributes_are_passed_then_forms_the_name() throws Exception {
		
		String johnsFirstName = "john";
		String johnsSecondName = "smith";
		String johnsLastName = "maddison";
		String johnsNamePrefix = "dr.";
		
		String number = telephone.addConnection(johnsFirstName, johnsNamePrefix,
					johnsLastName, johnsSecondName, new Date(), OnceYouBuyYouStartCryingTelephone.THREE_G);
		
		assertNotNull(number);
		
		String billDetails = telephone.bill(number);
		assertTrue(billDetails.contains(johnsFirstName));
		assertTrue(billDetails.contains(johnsNamePrefix));
		assertTrue(billDetails.contains(johnsLastName));
		assertTrue(billDetails.contains(johnsSecondName));
	}
	
}
