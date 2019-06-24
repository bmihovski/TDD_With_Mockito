package com.edu.chapter06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	
	@Test(expected = RuntimeException.class)
	public void inventory_access_raises_Error() {
		when(inventory.getItemsExpireInAMonth()).thenThrow(new RuntimeException("Database Access fail"));
		
		bazar.issueDiscountForItemsExpireIn30Days(.30);
		fail("Code should't reach here");
	}
	
	//doThrow(exception).when(mock).voidMethod(arguments);
	@Test(expected = RuntimeException.class)
	public void voidMethod_to_throw_exception() {
		doThrow(new RuntimeException()).when(pas).announce(isA(Offer.class));
		pas.announce(new Offer(null, 0));
		fail("Code should not reach here");
	}
	
	@Test
	public void consecutiveCalls() {
		when(inventory.getItemsExpireInAMonth()).thenReturn(expiredList)
												.thenReturn(null);
		assertEquals(expiredList, inventory.getItemsExpireInAMonth());
		assertEquals(null, inventory.getItemsExpireInAMonth());
	}
}
