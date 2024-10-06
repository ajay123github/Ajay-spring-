package com.inventory_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_seq")
	@SequenceGenerator(name="order_seq",sequenceName="order_seq",allocationSize = 1)
	@Column(name="id")
	private Long id;
	
	@Column(name="skucode")
	private String skucode;
	@Column(name="price")
	private double price;
	@Column(name="quantity")
	private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Inventory(Long id, String skucode, double price, int quantity) {
		super();
		this.id = id;
		this.skucode = skucode;
		this.price = price;
		this.quantity = quantity;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
