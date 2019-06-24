package com.edu.chapter06;

public class StockListener implements StockBrocker {
	
	StockBrocker brocker;
	
	public StockListener(StockBrocker brocker) {
		// TODO Auto-generated constructor stub
	}

	public void takeAction(Stock stock) {
		double currentPrice = brocker.getQuote(stock);
		if (currentPrice <= stock.boughtAt()) {
			brocker.buy(stock, 100);
		} else {
			brocker.sell(stock, 10);
		}
	}

	@Override
	public double getQuote(Stock stock) {
		return stock.boughtAt();
	}

	@Override
	public void sell(Stock stock, int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy(Stock stock, int i) {
		// TODO Auto-generated method stub
		
	}

}
