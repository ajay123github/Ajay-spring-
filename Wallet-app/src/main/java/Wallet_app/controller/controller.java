package Wallet_app.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import Wallet_app.document.Transactions;
import Wallet_app.dto.Transactiondto;
import Wallet_app.repository.TransactionRepository;
import Wallet_app.service.service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/wallet")
public class controller {
	
	@Autowired
	service transactionservice;
	
	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/create-csvfile")
	public String createFileInFolder(@RequestParam String foldername,@RequestParam String filename) {
		return transactionservice.writeCSVFile(foldername,filename);
	}
	
	@PostMapping("/transactions")
	public String uploadCSVFile() {
		return transactionservice.saveCSVFile();
	}
	
	@GetMapping("/login")
	public ModelAndView getLoginForm() {
		ModelAndView mv=new ModelAndView("main.html");
		return mv;
	}
	
	@GetMapping("/MainPage")
	public List<Transactiondto> getTransactions() {
		return transactionservice.getTransactionsDetails();
	}
	
	@PostMapping("/menu")
	public ModelAndView getAll(@RequestParam("userid") String userid) {
		List<Transactions> id= transactionservice.getByUserId(userid);
		ModelAndView mv=null;
		
	if(!(id.isEmpty())) {
		mv=new ModelAndView("menu.html");
		mv.addObject("id", id);
		
	}else {
		mv=new ModelAndView("result.html");
		mv.addObject("message", "UserNanme is not Found");
	}
	return mv;
	}
	
	@GetMapping("/transactions/analyse")
	public List<Transactiondto> getTransaction(@RequestParam String category) {
		if(category.equals("all")) {
			return transactionservice.getTransactionsDetails();
		}else {
			return transactionservice.getTransactionsDetailsByCategory(category);
		}
	}
	
	
	@GetMapping("/transaction/time")
	public List<Transactiondto> getTime(@RequestParam String time){
		return transactionservice.findByTime(time);
	}
	
	//@GetMapping("/transaction/date")
	//public List<Transactions> getDate(@RequestParam String date){
//		LocalDate localDate= LocalDate.parse(date);
//		 LocalDateTime startOfDay = localDate.atStartOfDay(ZoneId.of("UTC")).toLocalDateTime();
//		 LocalDateTime endofDay= localDate.atTime(23, 59, 59, 999999999).atZone(ZoneId.of("UTC")).toLocalDateTime();
//		return transactionservice.findByDate(startOfDay,endofDay);
		
		//transactionservice.findByDate()
	//}


	@GetMapping("/transaction/date")
	public List<Transactiondto> getDate(@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date){
		return transactionservice.findByDate(date);
	}
}
