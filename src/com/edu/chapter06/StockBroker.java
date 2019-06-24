package com.edu.chapter06;

interface StockBroker {

	double getQoute(Stock stock);

	void sell(Stock stock, int quantity);

	void buy(Stock stock, int quantity);

}
