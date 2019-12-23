package com.hossainshanjida.stocks.dao;

import java.io.IOException;

public class Water implements java.io.Closeable {
	
	
	public Water() {
		System.out.println("Water is turned on!");
	}

	@Override
	public void close() throws IOException {	
		System.out.println("The water resource is closed");
		
	}

}
