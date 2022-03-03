package com.nordex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nordex.model.Customer;
import com.nordex.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/emp/saveCus")
	public Object saveCustomer(@RequestBody Customer customer)
	{
		return (customerService.saveCustomer(customer));
	}
	
	@GetMapping(value="/emp/getEmps")
	public List<Customer> getCust()
	{
		return (customerService.getAllCustomer());
	}
	
	@GetMapping(value="/emp/getEmpById/{id}")
	public Customer getCustById(@PathVariable int id)
	{
		return (customerService.getCustById(id));
	}
	
	@PutMapping(value="/emp/updateEmp")
	public Object updateCustomer(@RequestBody Customer customer)
	{
		return (customerService.updateCustomer(customer));
	}
	
	@DeleteMapping(value="/emp/deleteEmp/{id}")
	public Object deleteCustomer(@PathVariable int id)
	{
		return (customerService.deleteCustomer(id));
	}
	

	
}



