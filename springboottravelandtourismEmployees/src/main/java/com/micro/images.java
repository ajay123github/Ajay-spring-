package com.micro;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="images")
public class images {
	@Id
	@Column
	private String id; 
	@Lob
	@Column
	private byte[] image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public images(String id, byte[] image) {
		super();
		this.id = id;
		this.image = image;
	}
	public images() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "images [id=" + id + ", image=" + Arrays.toString(image) + "]";
	}
	
	
	
}
