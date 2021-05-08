package tn.rnu.isi.worldcup.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "image_model")
public class ImageModel {
	@Id @Column(name = "imageId") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	@Column(name = "name") 
	private String name; 
	@Column(name = "type") 
	private String type; 
	@Column(name = "picByte", length = 2000) 
	private byte[] picByte; 
	
	  public ImageModel() 
	  { super(); } 
	  
	  public ImageModel(String name, String type, byte[] picByte) 
	  { this.name = name; 
	  this.type = type; 
	  this.picByte = picByte; }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "ImageModel [id=" + id + ", name=" + name + ", type=" + type + ", picByte=" + Arrays.toString(picByte)
				+ "]";
	}
	  

	
	 
	  
}
