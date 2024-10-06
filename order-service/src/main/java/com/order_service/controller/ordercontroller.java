package com.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.order_service.entity.Order;
import com.order_service.service.orderservie;

@RestController
@RequestMapping("/api/orders")
public class ordercontroller {
	
	@Autowired
	orderservie orderservie;

	@PostMapping("/placeorder")
	@ResponseStatus(HttpStatus.CREATED)
	public String createOrders(@RequestBody List<Order> order) {
		 orderservie.saveOrder(order);
		return "Orders saved successfully";
		
	}
	
	 @GetMapping("/orders")
	    public ModelAndView showOrderForm() {
		 
		 ModelAndView mv=new ModelAndView("orders.html");
//	        Order order = new Order();
//	        model.addAttribute("order", order);
	        return mv;  // Load the form view
	    }
	 
	 @GetMapping("/mainform")
	    public ModelAndView showMainForm() {
		 
		 ModelAndView mv=new ModelAndView("MainPage.html");
//	        Order order = new Order();
//	        model.addAttribute("order", order);
	        return mv;  // Load the form view
	    }
}
