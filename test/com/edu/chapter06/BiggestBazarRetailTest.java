package com.edu.chapter06;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class BiggestBazarRetailTest {

	@Test
	public void sanityCheck() throws Exception {
		PublicAddressSystem pas = mock(PublicAddressSystem.class);
		Inventory inventory = mock(Inventory.class);
		assertNotNull("Inventory object was null", inventory);
		assertNotNull("PublicAddressSystem object was null", pas);
	}
	
}
