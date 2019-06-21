package com.edu.chapter06;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BiggestBazarRetailTest {
	@Mock
	PublicAddressSystem pas;
	@Mock
	Inventory inventory;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void sanityCheck() throws Exception {
		assertNotNull("Inventory object was null", inventory);
		assertNotNull("PublicAddressSystem object was null", pas);
	}
	
}
