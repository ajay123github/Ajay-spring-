package com.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory_service.entity.Inventory;

public interface inventoryrepository extends JpaRepository<Inventory, Long>{

	

}
