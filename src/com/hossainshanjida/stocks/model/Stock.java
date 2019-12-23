package com.hossainshanjida.stocks.model;

public class Stock {

	private String symbol, name, category, sector, frequency, exchange;
	private float price, netIncome, dividendYield;


	public Stock(String symbol, String name, String category, String sector, String frequency, String exchange,
			float price, float netIncome, float dividendYield) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.category = category;
		this.sector = sector;
		this.frequency = frequency;
		this.exchange = exchange;
		this.price = price;
		this.netIncome = netIncome;
		this.dividendYield = dividendYield;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(float netIncome) {
		this.netIncome = netIncome;
	}

	public float getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(float dividendYield) {
		this.dividendYield = dividendYield;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", name=" + name + ", category=" + category + ", sector=" + sector
				+ ", frequency=" + frequency + ", exchange=" + exchange + ", price=" + price + ", netIncome="
				+ netIncome + ", dividendYield=" + dividendYield + "]";
	}



}
