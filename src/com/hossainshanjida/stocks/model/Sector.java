package com.hossainshanjida.stocks.model;

public class Sector {
	private String sector, sectorDescription;

	public Sector(String sector, String sectorDescriptions) {
		super();
		this.sector = sector;
		this.sectorDescription = sectorDescriptions;

	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSectorDescriptions() {
		return sectorDescription;
	}

	public void setSectorDescriptions(String sectorDescriptions) {
		this.sectorDescription = sectorDescriptions;
	}

	@Override
	public String toString() {
		return "Sector [sectors=" + sector + ", sectorDescriptions=" + sectorDescription + "]";
	}

}
