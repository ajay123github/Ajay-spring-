package com.order_service.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitems")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitem_seq")
    @SequenceGenerator(name = "orderitem_seq", sequenceName = "orderitem_seq", allocationSize = 1)
	private Long id;
	private String itemname;
	private int price;
	private double quantity;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Long id, String itemname, int price, double quantity) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
