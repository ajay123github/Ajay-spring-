package com.order_service.dto;


public class orderitemdto {
	
	private String itemname;
	private int price;
	private double quantity;
	
	public orderitemdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orderitemdto(String itemname, int price, double quantity) {
		super();
		this.itemname = itemname;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	

}
