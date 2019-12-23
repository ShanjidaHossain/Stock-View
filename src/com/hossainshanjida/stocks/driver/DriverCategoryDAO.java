package com.hossainshanjida.stocks.driver;

import com.hossainshanjida.stocks.dao.CategoryDAO;
import com.hossainshanjida.stocks.dao.IQuery;

public class DriverCategoryDAO {

	public static void main(String[] args) {
		IQuery<String> dao = new CategoryDAO();
		dao.findAll().forEach(System.out::println);

	}

}
