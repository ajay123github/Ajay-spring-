package com.inventory_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventory_service.dto.Inventorydto;
import com.inventory_service.service.service;

@RestController
@RequestMapping("/inventory")
public class controller {
	
	@Autowired
	service service;
	
	@PostMapping("/generateproducts")
	public String productsToFile() {
		service.getProductsToDBS();
		return "Product data generated and saved";
	}
	
	@PostMapping("/setProducts")
	@ResponseStatus(HttpStatus.CREATED)
	
	public String insertProduct(@RequestBody Inventorydto inventorydtos) {
		
	service.setProduct(inventorydtos);
		
	return "Products Saved Successfully";
	
	}
	

	@GetMapping("/getProduct")
	@ResponseStatus(HttpStatus.OK)
	
	public List<Inventorydto> getProduct() {
		
		return service.getProducts();
		
	}
	
	@DeleteMapping("/delete/{id}")
	
	public String deleteInventory(@PathVariable("id") Long id) {
		service.deleteProduct(id);
		
		return "deleted Successfully";
	}
	
}
