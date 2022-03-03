package com.nordex.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flipkart_tbl")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cid")
	private int id;
	
	@Column(name="cName" , length=30)
	private String name;
	
	@Column(name="contact" , length=10)
	private String contact;
	
	@Column(name="address" , length=50)
	private String address;
	
	@Column(name="mode", length=10)
	private String pay_mode;
	
	@Column(name="oder_date")
	private String order_date;
	
	@Column(name="deliver_date")
	private String deliver_date;
	
	@Column(name="total_amt", length=20)
	private double total_amt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPay_mode() {
		return pay_mode;
	}

	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getDeliver_date() {
		return deliver_date;
	}

	public void setDeliver_date(String deliver_date) {
		this.deliver_date = deliver_date;
	}

	public double getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(double total_amt) {
		this.total_amt = total_amt;
	}
	
	
	
	
	
	
	

}
