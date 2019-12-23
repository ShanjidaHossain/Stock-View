package com.hossainshanjida.stocks.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.in;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.hossainshanjida.stocks.model.Stock;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class StockDAO implements IQuery<Stock> {

	@Override
	public List<Stock> findAll() {

		Map<String, String> map = new HashMap<>();
		return this.findBy(map);
	}

	@Override
	public List<Stock> findBy(Map<String, String> map) {

		List<Stock> stocks = new ArrayList<Stock>();
		Gson gson = new Gson();

		Bson bson = new Document();

		// Symbol
		if (map.containsKey("symbol")) {
			String symbolSearch = map.get("symbol");
			String[] parts = symbolSearch.split(":");

			if (parts[1].equalsIgnoreCase("all")) {

			} else if (parts[0].contentEquals("eq")) {
				bson = eq("symbol", parts[1]);
			}

			System.out.println(Arrays.toString(parts));

		}

		// Price
		if (map.containsKey("price")) {
			String priceSearch = map.get("price");
			String[] parts = priceSearch.split(":");

			if (!parts[1].equalsIgnoreCase("all")) {
				if (parts[0].contentEquals("gt")) {
					float price = Float.parseFloat(parts[1]);
					bson = and(bson, gt("price", price));
				}

				System.out.println(Arrays.toString(parts));

			}
		}
		// Category
		if (map.containsKey("category")) {
			String symbolSearch = map.get("category");
			String[] parts = symbolSearch.split(":");

			if (parts[1].equalsIgnoreCase("all")) {

			} else if (parts[0].contentEquals("eq")) {
				bson = and(bson, eq("category", parts[1]));
			}
			System.out.println(Arrays.toString(parts));

		}
		// Categories
		if (map.containsKey("categories")) {
			String categoriesSearch = map.get("categories");
			String[] parts = categoriesSearch.split(",");
			{
				bson = and(bson, in("category", parts));
			}
			System.out.println(Arrays.toString(parts));
		}

		// Net Income
		if (map.containsKey("netIncome")) {
			String netIncomeSearch = map.get("netIncome");
			String[] parts = netIncomeSearch.split(":");

			if (!parts[1].equalsIgnoreCase("all")) {
				if (parts[0].contentEquals("gt")) {
					float netIncome = Float.parseFloat(parts[1]);
					bson = and(bson, gt("netIncome", netIncome));
				}

				System.out.println(Arrays.toString(parts));

			}
		}

		// Dividend Yield
		if (map.containsKey("dividendYield")) {
			String dividendYieldSearch = map.get("dividendYield");
			String[] parts = dividendYieldSearch.split(":");

			if (parts[1].equalsIgnoreCase("all")) {

			} else if (parts[0].contentEquals("eq")) {
				bson = eq("dividendYield", parts[1]);
			}

			System.out.println(Arrays.toString(parts));

		}

		// Sectors
		if (map.containsKey("sector")) {
			String sectorSearch = map.get("sector");
			String[] parts = sectorSearch.split(",");

			if (parts[1].equalsIgnoreCase("all")) {

			} else if (parts[0].contentEquals("eq")) {
				bson = and(bson, eq("sector", parts[1]));
			}
			System.out.println(Arrays.toString(parts));

		}

		// Frequency
		if (map.containsKey("frequency")) {
			String frequencySearch = map.get("frequency");
			String[] parts = frequencySearch.split(":");

			if (parts[1].equalsIgnoreCase("all")) {

			} else if (parts[0].contentEquals("eq")) {
				bson = eq("frequency", parts[1]);
			}

			System.out.println(Arrays.toString(parts));

		}

		// Exchange
		if (map.containsKey("exchange")) {
			String ExchangeSearch = map.get("exchange");
			String[] parts = ExchangeSearch.split(":");

			if (parts[1].equalsIgnoreCase("all")) {

			} else if (parts[0].contentEquals("eq")) {
				bson = eq("exchange", parts[1]);
			}

			System.out.println(Arrays.toString(parts));

		}

		try (MongoClient mc = new MongoClient("localhost", 27017);) {

			MongoDatabase db = mc.getDatabase("stockdb");
			MongoCollection<Document> collection = db.getCollection("stocks");

			FindIterable<Document> list = collection.find(bson);

			for (Document document : list) {
				String json = document.toJson();
				Stock stock = gson.fromJson(json, Stock.class);
				stocks.add(stock);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stocks;
	}

}
