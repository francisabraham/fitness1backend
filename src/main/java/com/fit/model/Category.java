package com.fit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import org.springframework.stereotype.Component;

@Entity
@Component

public class Category {
	@Id
	private int cid;
	private String cname;
	@OneToOne(targetEntity=Product.class, fetch=FetchType.EAGER,mappedBy="category")
	
	private Set<Product>product=new HashSet<Product>(0);

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
}