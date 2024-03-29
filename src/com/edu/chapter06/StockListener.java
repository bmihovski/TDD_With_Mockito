package com.edu.chapter06;

public class StockListener {
	private final StockBroker broker;
	
	public void takeAction(Stock stock){
		double currentPrice = broker.getQuote(stock);
		if(currentPrice <= stock.boughtAt()){
			broker.buy(stock, 100);
		}else{
			broker.sell(stock, 10);
		}
		
	}
	
	public StockListener(StockBroker broker) {
		this.broker = broker;
	}
}