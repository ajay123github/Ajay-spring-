package com.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_service.entity.Order;
import com.order_service.repository.orderrepository;

import jakarta.transaction.Transactional;

@Service
public class orderservie {
	
	@Autowired
	orderrepository orderrepository;
	
	@Transactional
	public Order saveOrder(List<Order> order) {
		return orderrepository.save(order);
	}
		
	}


