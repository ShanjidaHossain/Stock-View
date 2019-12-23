package com.hossainshanjida.stocks.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hossainshanjida.stocks.dao.SectorDAO;
import com.hossainshanjida.stocks.dao.StockDAO;
import com.hossainshanjida.stocks.model.Sector;
import com.hossainshanjida.stocks.model.Stock;

public class DriverDAO {

	public static void main(String[] args) {

		t7();

	}
	
	
	  public static void t7() {
	  
	  System.out.println("Sector Test");
	  
	  SectorDAO dao = new SectorDAO(); Map<String, String> map = new HashMap<>();
		map.put("sectors", "eq:55");
	  
	  List<Sector> list = dao.findBy(map);
	  
	  for (Sector s : list) { System.out.println(s); }
	  
	  }
	 

	public static void t6() {

		System.out.println("netIncome Test");

		StockDAO dao = new StockDAO();
		Map<String, String> map = new HashMap<>();
		map.put("netIncome", "gt:50");

		List<Stock> list = dao.findBy(map);

		for (Stock stock : list) {
			System.out.println(stock);
		}

	}

	public static void t5() {

		System.out.println("Category Test");

		StockDAO dao = new StockDAO();
		Map<String, String> map = new HashMap<>();
		map.put("categories", "e-04,e-05");
		map.put("price", "gt:55");

		List<Stock> list = dao.findBy(map);

		for (Stock stock : list) {
			System.out.println(stock);
		}

	}

	public static void t4() {

		System.out.println("Category Test");

		StockDAO dao = new StockDAO();
		Map<String, String> map = new HashMap<>();
		map.put("category", "eq:e-05");

		List<Stock> list = dao.findBy(map);

		for (Stock stock : list) {
			System.out.println(stock);
		}

	}

	public static void t3() {

		System.out.println("Price Test");

		StockDAO dao = new StockDAO();
		Map<String, String> map = new HashMap<>();
		map.put("price", "gt:50");

		List<Stock> list = dao.findBy(map);

		for (Stock stock : list) {
			System.out.println(stock);
		}

	}

	public static void t2() {

		StockDAO dao = new StockDAO();
		Map<String, String> map = new HashMap<>();
		map.put("symbol", "eq:ibm-41");

		List<Stock> list = dao.findBy(map);

		for (Stock stock : list) {
			System.out.println(stock);
		}

	}

	public static void t1() {

		StockDAO dao = new StockDAO();
		List<Stock> list = dao.findAll();

		for (Stock stock : list) {
			System.out.println(stock);
		}

	}

}
