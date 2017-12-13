package com.fit.model;
import java.awt.Image;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Table(name="Product")
public class Product  implements Serializable
{
private static final long serialVersionUID= 1L;
@Id
@GeneratedValue
 
private int id;
private String pname;
private String pdescription;
private Float price;
private int stock;

@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="cid")
private Category category;

@ManyToOne
@JoinColumn(name="sid")
private Supplier supplier;

@Transient
MultipartFile pimage;
private String imgname;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPdescription() {
	return pdescription;
}
public void setPdescription(String pdescription) {
	this.pdescription = pdescription;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

public String getImgname() {
	return imgname;
}
public void setImgname(String imgname) {
	this.imgname = imgname;
}
public void setDescription(String d) {
	// TODO Auto-generated method stub
	
}
}

