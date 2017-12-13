package com.fit.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Orders {

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue
	
	private int orderId;
	@ManyToOne
	@JoinColumn(name="email")
	
	private User user;
	private double total;
	
	private String payment;
	
	public int getOrderId() 
	{
		return orderId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	

	


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	
	
}
