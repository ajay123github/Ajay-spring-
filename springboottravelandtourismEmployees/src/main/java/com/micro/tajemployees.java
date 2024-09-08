package com.micro;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tajemployees")
public class tajemployees {
	@Id
	@Column
	private String id;
	@Column
	private String name;
	@Column
	private String job;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private int salary;
	@Column
	private String department;
	@Column
	private Date joiningdate;
	@Column
	private String homeplace;
	@Column
	private String nativeplace;
	@Column
	private String mobile;
	@Column
	private String state;
	@Column
	private String country;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	public String getHomeplace() {
		return homeplace;
	}
	public void setHomeplace(String homeplace) {
		this.homeplace = homeplace;
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	
	
	public tajemployees(String id, String name, String job, String gender, int age, int salary, String department,
			Date joiningdate, String homeplace, String nativeplace, String mobile, String state, String country) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.department = department;
		this.joiningdate = joiningdate;
		this.homeplace = homeplace;
		this.nativeplace = nativeplace;
		this.mobile = mobile;
		this.state = state;
		this.country = country;
	}
	
	
	public tajemployees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "tajemployees [id=" + id + ", name=" + name + ", job=" + job + ", gender=" + gender + ", age=" + age
				+ ", salary=" + salary + ", department=" + department + ", joiningdate=" + joiningdate + ", homeplace="
				+ homeplace + ", nativeplace=" + nativeplace + ", mobile=" + mobile + ", state=" + state + ", country="
				+ country + "]";
	}
	
	
	
	
}
