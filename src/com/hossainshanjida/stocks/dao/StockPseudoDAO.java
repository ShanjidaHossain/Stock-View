package com.hossainshanjida.stocks.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.hossainshanjida.stocks.model.Stock;

public class StockPseudoDAO implements IQuery<Stock> {
	
	public List<Stock> findAll() {	
		
		List<Stock> list = new ArrayList<Stock>();
		
		IntStream.rangeClosed(1, 30 ).forEach( e -> {
			
			String symbol = "ibm-" + e;
			String name = "international business machine " + e;
			float price = 30 + e;
			String category = "e-03" +e ;
			float netIncome = 100 + e;
			float dividendYield = 30 + e;
			String sector = "Consumer Staples" + e;
			String frequency = "Quartely";
			String exchange = "NYSE";

			list.add(new Stock( symbol,  name,  category,  sector,  frequency,  exchange,
					 price,  netIncome,  dividendYield));
		});		
		
		return list;
	}

}