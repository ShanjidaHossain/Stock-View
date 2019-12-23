package com.hossainshanjida.stocks.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoDatabase;

public class CategoryDAO implements IQuery<String> {

	@Override
	public List<String> findAll() {
		try (MongoClient mc = new MongoClient("localhost", 27017);) {

			MongoDatabase db = mc.getDatabase("stockdb");
			DistinctIterable<String> distinctCategories = db
					.getCollection("stocks")
					.distinct("category", String.class)
			;
			List<String> categories = new ArrayList<String>();

			for (String category : distinctCategories) {
				categories.add(category);
			}
			return categories;
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList();
	}

}
