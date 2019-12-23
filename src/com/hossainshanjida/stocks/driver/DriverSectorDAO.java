package com.hossainshanjida.stocks.driver;

import com.hossainshanjida.stocks.dao.IQuery;
import com.hossainshanjida.stocks.dao.SectorDAO;
import com.hossainshanjida.stocks.model.Sector;

public class DriverSectorDAO {

	public static void main(String[] args) {
		 
		IQuery<Sector> dao = new SectorDAO();
		  dao.findAll().forEach(System.out::println);
		  

	}

}
