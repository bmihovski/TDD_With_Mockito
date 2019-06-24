package com.edu.chapter06;

interface StockBrockerT {

	double getQuote(Stock stock);

	void sell(Stock stock, int quantity);

	void buy(Stock stock, int quantity);

}
