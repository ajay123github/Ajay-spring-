package com.order_service.dto;

import java.util.List;

public class orderdto {
	
	private List<orderitemdto> itemList;

	public orderdto(List<orderitemdto> itemList) {
		super();
		this.itemList = itemList;
	}

	public orderdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<orderitemdto> getItemList() {
		return itemList;
	}

	public void setItemList(List<orderitemdto> itemList) {
		this.itemList = itemList;
	}

	
	
	

}
