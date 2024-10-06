package com.inventory_service.dto;

public class Inventorydto {
	
	
	private String skucode;
	private double price;
	private int quantity;
	public String getSkucode() {
		return skucode;
	}
	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Inventorydto(String skucode, double price, int quantity) {
		super();
		this.skucode = skucode;
		this.price = price;
		this.quantity = quantity;
	}
	public Inventorydto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
