package com.nordex.service;

import java.util.List;

import com.nordex.model.Customer;

public interface CustomerService {
	
	public Object saveCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer getCustById(int id);
	public Object updateCustomer(Customer customer);
	
	public Object deleteCustomer(int id);
	


}
