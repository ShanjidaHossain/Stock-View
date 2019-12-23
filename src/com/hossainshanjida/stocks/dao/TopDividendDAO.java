package com.hossainshanjida.stocks.dao;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.hossainshanjida.stocks.model.DividendYeild;
import com.hossainshanjida.stocks.model.Sector;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TopDividendDAO implements IQuery<DividendYeild> {

	@Override
	public List<DividendYeild> findBy(Map<String, String> map) {

		List<DividendYeild> dividendYeild = new ArrayList<DividendYeild>();
		Gson gson = new Gson();

		Bson bson = new Document();

		if (map.containsKey("dividendYeild")) {
			String dividendYeildSearch = map.get("dividendYeild");
			String[] parts = dividendYeildSearch.split(":");

			if (parts[1].equalsIgnoreCase("all")) {

			} else if (parts[0].contentEquals("eq")) {
				bson = eq("dividendYeild", parts[1]);
			}

			System.out.println(Arrays.toString(parts));

		}


		try (MongoClient mc = new MongoClient("localhost", 27017);) {

			MongoDatabase db = mc.getDatabase("stockdb");
			MongoCollection<Document> collection = db.getCollection("sector");

			FindIterable<Document> list = collection.find(bson);

			for (Document document : list) {
				String json = document.toJson();
				DividendYeild sector = gson.fromJson(json, DividendYeild.class);
				//dividendYeild.add(dividendYeild);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dividendYeild;
	}

	@Override
	public List<DividendYeild> findAll() {
		Map<String, String> map = new HashMap<>();
		return this.findBy(map);
	}

}
