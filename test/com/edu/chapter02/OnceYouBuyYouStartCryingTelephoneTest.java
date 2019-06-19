package com.edu.chapter02;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.edu.chapter02.PhoneConnection.ConnectionType;

public class OnceYouBuyYouStartCryingTelephoneTest {
	
	OnceYouBuyYouStartCryingTelephone telephone = new OnceYouBuyYouStartCryingTelephone();
	
	@Test(expected = RuntimeException.class)
	public void when_input_first_name_is_null_then_throws_exception() throws Exception {
		telephone.addConnection(new PersonName(null, null, null, null), null, null);
		
		fail("Code should not reach here!");
	}

	@Test(expected = RuntimeException.class)
	public void when_input_last_name_is_null_then_throws_exception() throws Exception {
		telephone.addConnection(new PersonName("ivan", null, null, null), null, null);
		
		fail("code should not reach here");
	}
	
	@Test(expected = RuntimeException.class)
	public void when_input_z_is_null_then_throws_exception() throws Exception {
		telephone.addConnection(new PersonName("gee", null, null, "ned"), null, null);
		
		fail("code should not reach here");
	}
	
	@Test(expected = RuntimeException.class)
	public void when_input_gen_is_invalid_then_throws_exception() throws Exception {
		telephone.addConnection(new PersonName("isew", null, null, "ens"), new Date(), null);
		
		fail("code should not reach here");
	}
	
	@Test
	public void when_valid_input_then_adds_input() throws Exception {
		assertNotNull(telephone.addConnection(new PersonName("esd", null, null, "eswq"), new Date(), ConnectionType.THREE_G));
	}
	
	@Test
	public void when_all_name_atributes_are_passed_then_forms_the_name() throws Exception {
		
		String johnsFirstName = "john";
		String johnsSecondName = "smith";
		String johnsLastName = "maddison";
		String johnsNamePrefix = "dr.";
		
		String number4G = telephone.addConnection(new PersonName(johnsFirstName, johnsNamePrefix, johnsLastName, johnsSecondName), new Date(),
					ConnectionType.FOUR_G);
		
		assertNotNull(number4G);
		
		String bill4GDetails = telephone.bill(number4G);
		assertTrue(bill4GDetails.contains(johnsFirstName));
		assertTrue(bill4GDetails.contains(johnsNamePrefix));
		assertTrue(bill4GDetails.contains(johnsLastName));
		assertTrue(bill4GDetails.contains(johnsSecondName));
		
		String kenFirstName = "ken";
		String kenSecondName = "eres";
		String kenLastName = "maee";
		String kenNamePrefix = "me.";
		
		String number3G = telephone.addConnection(new PersonName(kenFirstName, kenNamePrefix, kenLastName, kenSecondName), new Date(),
					ConnectionType.FOUR_G);
		
		assertNotNull(number3G);
		
		String bill3GDetails = telephone.bill(number3G);
		assertTrue(bill3GDetails.contains(kenFirstName));
		assertTrue(bill3GDetails.contains(kenNamePrefix));
		assertTrue(bill3GDetails.contains(kenLastName));
		assertTrue(bill3GDetails.contains(kenSecondName));
	}
	
}
