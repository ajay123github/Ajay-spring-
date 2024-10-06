package com.inventory_service.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory_service.dto.Inventorydto;
import com.inventory_service.entity.Inventory;
import com.inventory_service.repository.inventoryrepository;
//import com.product_service.services.document.Product;

import ch.qos.logback.core.net.ObjectWriter;

@Service
public class service {
	
	@Autowired
	inventoryrepository inventoryrepository;

	public void setProduct(Inventorydto inventorydtos) {
		// TODO Auto-generated method stub
//	List<Inventory> entities= inventorydtos.stream().map(inventory->{
		Inventory entity=new Inventory();
		
		entity.setSkucode(inventorydtos.getSkucode());
		entity.setPrice(inventorydtos.getPrice());
		entity.setQuantity(inventorydtos.getQuantity());
		
//		return entity;
//		
//	}).collect(Collectors.toList());
			inventoryrepository.save(entity);
	}
	
	
	
	public List<Inventorydto> getProducts() {
		// TODO Auto-generated method stub
		
		List<Inventory> inventories= inventoryrepository.findAll();
		
		return inventories.stream().map(inventory->mapToInventorydto(inventory)).toList();
		
	}

	private  Inventorydto mapToInventorydto(Inventory inventory) {
		// TODO Auto-generated method stub
		
		Inventorydto dto=new Inventorydto();
		
		dto.setSkucode(inventory.getSkucode());
		dto.setPrice(inventory.getPrice());
		dto.setQuantity(inventory.getQuantity());
		
		return dto;
	}

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		inventoryrepository.deleteById(id);
		
		
		
	}

	public void getProductsToDBS() {
	    // TODO Auto-generated method stub
	    int noofProducts = 100000;
	    List<Inventorydto> inventory = new ArrayList<>();
	    Random random = new Random();

	    for (int i = 0; i < noofProducts; i++) {
	        String skucode = String.format("SKUCODE%05d", i + 1);
	        
	        // Correct the price calculation to generate a proper random double value
	        double price = Math.round((10.0 + (1000.0 - 10.0) * random.nextDouble()) * 100.0) / 100.0;
	        
	        int quantity = random.nextInt(500) + 1; // Ensure quantity is not excessively large

	        // Updated to ensure `price` is a double, but if `Inventorydto` expects `int`, cast it to `int`
//	        Inventorydto dto = new Inventorydto(skucode, (int) price, quantity);
//	        inventory.add(dto);
	        
	        Inventory inventoryEntity=new Inventory();
	        inventoryEntity.setSkucode(skucode);
	        inventoryEntity.setPrice(price);
	        inventoryEntity.setQuantity(quantity);
	        	
	        inventoryrepository.save(inventoryEntity);
	        
	    }
	   

	   

	    
	}


}
