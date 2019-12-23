package com.hossainshanjida.stocks.driver;

import java.util.HashMap;
import java.util.Map;

import com.hossainshanjida.stocks.dao.IQuery;
import com.hossainshanjida.stocks.dao.SectorDAO;
import com.hossainshanjida.stocks.dao.StockDAO;
import com.hossainshanjida.stocks.model.Sector;
import com.hossainshanjida.stocks.model.Stock;

public class DriverSectorDAO2 {

	public static void main(String[] args) {

		IQuery<Stock> dao = new StockDAO();
		Map<String, String> map = new HashMap<>();
		map.put("categories", "e-01,e-02");
		map.put("price", "gt:100");
		map.put("netIncome", "gt:100");
		map.put("dividendYield", "gt: 3f");
		map.put("frequency", "Quartely");
		map.put("exchange", "NYSE");


		dao.findBy(map).forEach(System.out::println);

	}

}
