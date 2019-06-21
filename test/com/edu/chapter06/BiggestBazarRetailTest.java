package com.edu.chapter06;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

public class BiggestBazarRetailTest {
	@Mock
	PublicAddressSystem pas;
	@Mock
	Inventory inventory;
	BiggestBazarRetail bazar;
	ArrayList<Item> expiredList = new ArrayList<Item>();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		// Setup with mock object
		bazar = new BiggestBazarRetail(inventory, pas);
	}

	@Test
	public void sanityCheck() throws Exception {
		assertNotNull("Inventory object was null", inventory);
		assertNotNull("PublicAddressSystem object was null", pas);
	}
	
	@Test
	public void issues_discount() throws Exception {
		// Creating expected item list
		
		Item soap = new Item("3232", "soap", 100.00, 90.00);
		expiredList.add(soap);
		//Stubbing database call for getItemsExpireInAMonth
		when(inventory.getItemsExpireInAMonth()).thenReturn(expiredList);
		
		// Stubbing update count 
		when(inventory.itemsUpdated()).thenReturn(1);
		
		
		// TEst
		bazar.issueDiscountForItemsExpireIn30Days(0.3);
		
		// Verify that inventory update and public announcement are invoked
		verify(inventory, never()).update(isA(Item.class), anyDouble());
		verify(pas, never()).announce(isA(Offer.class));
		
	}
}
