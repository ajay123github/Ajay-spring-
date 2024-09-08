package com.micro;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


//@XmlRootElement(name="The packages")
public class packagesdto {

	//@XmlElement(required = true,name="id")
	private String id;
	
	//@XmlElement(required=true,name="type")
	private String type;
	
	//@XmlElement(required=true,name="days")
	private int days;
	
	//@XmlElement(required=true,name="nights")
	private int nights;
	
	//@XmlElement(required=true,name="assistance")
	private String assistance;
	
	//@XmlElement(required=true,name="service")
	private String service;
	
	//@XmlElement(required=true,name="specialoffer")
	private String specialoffer;
	
	//@XmlElement(required=true,name="guide")
	private String guide;
	
	//@XmlElement(required=true,name="packagetype")
	private String packagetype;
	
	//@XmlElement(required=true,name="packagecost")
	private int packagecost;
	
	
	private byte[] image;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getNights() {
		return nights;
	}
	public void setNights(int nights) {
		this.nights = nights;
	}
	public String getAssistance() {
		return assistance;
	}
	public void setAssistance(String assistance) {
		this.assistance = assistance;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSpecialoffer() {
		return specialoffer;
	}
	public void setSpecialoffer(String specialoffer) {
		this.specialoffer = specialoffer;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public String getPackagetype() {
		return packagetype;
	}
	public void setPackagetype(String packagetype) {
		this.packagetype = packagetype;
	}
	public int getPackagecost() {
		return packagecost;
	}
	public void setPackagecost(int packagecost) {
		this.packagecost = packagecost;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public packagesdto(String id, String type, int days, int nights, String assistance, String service,
			String specialoffer, String guide, String packagetype, int packagecost, byte[] image) {
		super();
		this.id = id;
		this.type = type;
		this.days = days;
		this.nights = nights;
		this.assistance = assistance;
		this.service = service;
		this.specialoffer = specialoffer;
		this.guide = guide;
		this.packagetype = packagetype;
		this.packagecost = packagecost;
		this.image = image;
	}
	public packagesdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "packagesdto [id=" + id + ", type=" + type + ", days=" + days + ", nights=" + nights + ", assistance="
				+ assistance + ", service=" + service + ", specialoffer=" + specialoffer + ", guide=" + guide
				+ ", packagetype=" + packagetype + ", packagecost=" + packagecost + ", image=" + Arrays.toString(image)
				+ "]";
	}
	
	
}
