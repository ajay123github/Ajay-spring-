package com.order_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order_service.entity.Order;

@Repository
public interface orderrepository extends JpaRepository<Order, Long>{

	Order save(List<Order> order);

	
}
