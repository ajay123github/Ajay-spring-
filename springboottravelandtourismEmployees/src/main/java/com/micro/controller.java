package com.micro;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@RestController
@RequestMapping("/employee")
public class controller {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	service service;
	
	@Autowired
	imagerepository repository3;
	
	@Autowired
	tajremployeesrepository repository1;
	
	@Autowired
	packagesrepository repository2;
	
	@GetMapping("/emplog")

	public ModelAndView setLogin() {
		ModelAndView mv = new ModelAndView("log.html");
		return mv;
	}
	
	@GetMapping("/addemployeesform")
	
	public ModelAndView setEmp() {
		ModelAndView mv = new ModelAndView("addform.html");
		return mv;
	}
	
	@PostMapping("/addemployees")
	
	public ModelAndView setDetails(@RequestParam("id") String id
		,@RequestParam("name") String name,@RequestParam("job") String job,
		@RequestParam("gender") String gender,@RequestParam("age") int age,
		@RequestParam("salary") int salary,@RequestParam("department") String department,
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @RequestParam("joiningdate")  Date joiningdate ,
		@RequestParam("homeplace") String homeplace,
	@RequestParam("nativeplace") String nativeplace,@RequestParam("mobile") String mobile,
	@RequestParam("state") String state,@RequestParam("country") String country) {
		
		tajemployees employees=new tajemployees();
		employees.setId(id);
		employees.setName(name);
		employees.setJob(job);
		employees.setGender(gender);
		employees.setAge(age);
		employees.setSalary(salary);
		employees.setDepartment(department);
		employees.setJoiningdate(joiningdate);
		employees.setHomeplace(homeplace);
		employees.setNativeplace(nativeplace);
		employees.setMobile(mobile);
		employees.setState(state);
		employees.setCountry(country);
		
		repository1.save(employees);
		
		ModelAndView mv=new ModelAndView("result.html");
		mv.addObject("message", "Details are recorded successfully");
		
		return mv;
	}
	
@GetMapping("/permits")
	
	public ModelAndView setPermit() {
		ModelAndView mv = new ModelAndView("permit.html");
		return mv;
	}
	
@PostMapping("/menubar")

public ModelAndView setMenu(@RequestParam("id") String id) {
	
	Optional<tajemployees> empid= repository1.findById(id);
	
	ModelAndView mv=null;
	
	if(empid.isPresent()) {
		mv = new ModelAndView("menu.html");
	}else {
		mv=new ModelAndView("result.html");
		mv.addObject("message", "Sorry,Invalid Cerdentials");
	}
	return mv;
}

@GetMapping("/view")

public ModelAndView setViews() {
	ModelAndView mv = new ModelAndView("viewlogin.html");
	return mv;
}

@GetMapping("/menu")

public ModelAndView setMenubar() {
	ModelAndView mv = new ModelAndView("menu.html");
	return mv;
}

@PostMapping("/viewemployees")

public ModelAndView viewEmployees(@RequestParam("id") String id) {
	tajemployees employees=repository1.findById(id).get();
	ModelAndView mv=null;
	if(employees.getId().contentEquals("TJ105")) {
		List<tajemployees> allemp=repository1.findAll();
		mv = new ModelAndView("viewemployeedetails.html");
		mv.addObject("allemp", allemp);
	}else {
		mv=new ModelAndView("result.html");
		mv.addObject("message", "Sorry,Invalid Credentials");
	}
	
	return mv;
}
	
@GetMapping("/package")

public ModelAndView setPackage() {
	ModelAndView mv = new ModelAndView("PackageLogin.html");
	return mv;
}

@PostMapping("/pack")

public ModelAndView setPack(@RequestParam("user") String id) {
	
	Optional<tajemployees> empid= repository1.findById(id);
	tajemployees te= empid.get();
	ModelAndView mv = null;
	if(te.getId().contentEquals("TJ101")) {
		mv = new ModelAndView("Package.html");
	}else {
		mv=new ModelAndView("result.html");
		mv.addObject("message", "Sorry,Invalid Credentials");
	}
	
	return mv;
}

@PostMapping("/uploadpackage")

public ModelAndView setPackages(@RequestParam("id") String id
	,@RequestParam("type") String type,@RequestParam("days") int days
	,@RequestParam("nights") int nights,@RequestParam("assistance") String assistance
	,@RequestParam("service") String service,@RequestParam("specialoffer") String specialoffer
	,@RequestParam("guide") String guide,@RequestParam("packagetype") String packagetype
	,@RequestParam("packagecost") int packagecost,@RequestParam("image") MultipartFile image) {
	
	packages us=null;
	
	packages ps=new packages();
	
	ps.setId(id);
	ps.setType(type);
	ps.setDays(days);
	ps.setNights(nights);
	ps.setAssistance(assistance);
	ps.setService(service);
	ps.setSpecialoffer(specialoffer);
	ps.setGuide(guide);
	ps.setPackagetype(packagetype);
	ps.setPackagecost(packagecost);
	byte[] images;
	try {
		images = image.getBytes();
		ps.setImage(images);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	us = repository2.save(ps);
	
	ModelAndView mv=null;
	
	if(us!=null) {
		mv=new ModelAndView("result.html");
		mv.addObject("message", "package recorded successfully");
	}
	
	return mv;
}




/*
This RestAPI Service is for accessing an HTML form from an
springboottravelandtourism(which is called as PRODUCER PROJECT for this 
current RestAPI Communication only)
*/   
@GetMapping("/setPacs")

public ModelAndView setPacs() {
	
	//Making a request to Producer Project(springboottravelandtourism) to get the url should connect.
	
	//String response=new RestTemplate().getForObject("http://localhost:8009/travel/log", String.class);
	
	String url="http://localhost:8009/travel/log";
	RestTemplate resttemplate = new RestTemplate();
	String response =resttemplate.getForObject(url, String.class);
	
	//Now Setting the response to ModelAndView to display the result from rt
	
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("template2");
	mv.addObject("formHTML", response);
	
	return mv;
}

@GetMapping("/viewpackageimage1")

public ResponseEntity<byte[]> views1() {
	Optional<packages> entity=repository2.findById("Package-1");

		packages image = entity.get();
	byte[] images =image.getImage();
ResponseEntity<byte[]> img= ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(images);
	return img;
}

@GetMapping("/viewpackageimage2")

public ResponseEntity<byte[]> views2() {
	Optional<packages> entity=repository2.findById("Package-2");

		packages image = entity.get();
	byte[] images =image.getImage();
ResponseEntity<byte[]> img= ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(images);
	return img;
}

@GetMapping("/viewpackageimage3")

public ResponseEntity<byte[]> views() {
	Optional<packages> entity=repository2.findById("Package-3");

		packages image = entity.get();
	byte[] images =image.getImage();
ResponseEntity<byte[]> img= ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(images);
	return img;
}


@GetMapping("/Package-1")

public packagesdto getpackage1() {
	Optional<packages> image= repository2.findById("Package-1");
	packages packages=image.get();
	
	packagesdto dto=new packagesdto();
	dto.setId(packages.getId());
	dto.setDays(packages.getDays());
	dto.setAssistance(packages.getAssistance());
	dto.setGuide(packages.getGuide());
	dto.setNights(packages.getNights());
	dto.setPackagecost(packages.getPackagecost());
	dto.setPackagetype(packages.getPackagetype());
	dto.setService(packages.getService());
	dto.setSpecialoffer(packages.getSpecialoffer());
	dto.setType(packages.getType());
	
	return dto;

}

@GetMapping("/Package-2")

public packagesdto getpackage2() {
	Optional<packages> image= repository2.findById("Package-2");
	packages packages=image.get();
	
	packagesdto dto=new packagesdto();
	dto.setId(packages.getId());
	dto.setDays(packages.getDays());
	dto.setAssistance(packages.getAssistance());
	dto.setGuide(packages.getGuide());
	dto.setNights(packages.getNights());
	dto.setPackagecost(packages.getPackagecost());
	dto.setPackagetype(packages.getPackagetype());
	dto.setService(packages.getService());
	dto.setSpecialoffer(packages.getSpecialoffer());
	dto.setType(packages.getType());
	
	return dto;

}

@GetMapping("/Package-3")

public packagesdto getpackage3() {
	Optional<packages> image= repository2.findById("Package-3");
	packages packages=image.get();
	
	packagesdto dto=new packagesdto();
	dto.setId(packages.getId());
	dto.setDays(packages.getDays());
	dto.setAssistance(packages.getAssistance());
	dto.setGuide(packages.getGuide());
	dto.setNights(packages.getNights());
	dto.setPackagecost(packages.getPackagecost());
	dto.setPackagetype(packages.getPackagetype());
	dto.setService(packages.getService());
	dto.setSpecialoffer(packages.getSpecialoffer());
	dto.setType(packages.getType());
	
	return dto;

}

@GetMapping("/viewpackage")

public ModelAndView setviewpackage() {
	ModelAndView mv = new ModelAndView("ViewPackageLogin.html");
	return mv;
}

@PostMapping("/viewPackages")

public ModelAndView viewPackages(@RequestParam("id") String id) {
	tajemployees employees=repository1.findById(id).get();
	// byte[] img=packages.getImage();
	ModelAndView mv=null;
	if(employees.getId().contentEquals("TJ109")) {
		List<packages> packs=repository2.findAll();
		Object packages =entityManager.createQuery("select image from packages")
							.getResultList()
							.stream()
							.collect(Collectors.toList());
		mv=new ModelAndView("viewpackages.html");
		mv.addObject("packs", packs);
		mv.addObject("packages", packages);
	}else {
		mv=new ModelAndView("result.html");
		mv.addObject("message","Soory,Invalid Credentials");
	}
	
	return mv;
}

}
