package com.hossainshanjida.stocks.dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DriverMongoDB {
	
	public static void main(String[] args) {
		
		try (MongoClient mc =  new MongoClient("localhost", 27017);){
			
			MongoDatabase db = mc.getDatabase("stockdb");
			MongoCollection<Document> collection = db.getCollection("sectors");					
			
		    FindIterable<Document> stocks = collection.find();
		    
		    for (Document document : stocks) {
				System.out.println(document);
			}		    
		 
		 
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
