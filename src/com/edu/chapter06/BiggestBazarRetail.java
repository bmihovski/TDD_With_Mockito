package com.edu.chapter06;

import java.util.List;

public class BiggestBazarRetail {
	
	public BiggestBazarRetail(Inventory inventory, PublicAddressSystem publicAddressSystem) {}

	public int issueDiscountForItemsExpireIn30Days(double discountRate) {

		List<Item> headingExpiryItems = inventory.getItemsExpireInAMonth();
		for (Item anItem : headingExpiryItems) {
			double newPrice = anItem.getPrice() - anItem.getPrice() * discountRate;
			if (newPrice > anItem.getBasePrice()) {
				inventory.update(anItem, newPrice);
				publicAddressSystem.announce(new Offer(anItem, newPrice));
			}
		}
		return inventory.itemsUpdated();
	}
	

}
