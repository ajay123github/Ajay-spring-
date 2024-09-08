package com.micro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="personalinfo")
public class personalinfo {
	@Id
	@Column
	private String username;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private String job;
	@Column
	private String city;
	@Column
	private String area;
	@Column
	private String state;
	@Column
	private String country;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public personalinfo(String username, String name, int age, String gender, String job, String city,
			String area, String state, String country) {
		super();
		this.username = username;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.job = job;
		this.city = city;
		this.area = area;
		this.state = state;
		this.country = country;
	}
	public personalinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "personaldetails [username=" + username + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", job=" + job + ", city=" + city + ", area=" + area + ", state=" + state + ", country=" + country
				+ "]";
	}
	
	
}
