package com.nordex.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nordex.model.Customer;
import com.nordex.repository.CustomerRepo;
import com.nordex.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	@Transactional
	public Object saveCustomer(Customer customer) {
		Map<String, Object> map=new HashMap<String, Object>();
		if(customer.getName().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Name");
			}
		else if (customer.getContact().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Contact");
		}
		
		else if(customer.getAddress().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "Please the Address");
		}
		
		else if (customer.getDeliver_date().isEmpty()) {
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Delivery Date");
		}
		else if (customer.getOrder_date().isEmpty()) {
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Order Date");
		}
		else if (customer.getPay_mode().isEmpty()) {
			map.put("Status", "Error");
			map.put("Msg", "Please Select the Payyment Mode");
		}
		else if (customer.getTotal_amt()==0) {
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Total amount");
		}
		else
			{
				customerRepo.save(customer);
				map.put("Status", "Success");
				map.put("Msg", "Data Saved Successfully");
			}
		return map;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		
		return customerRepo.findAll();
		
		
	}

	@Override
	@Transactional
	public Customer getCustById(int id) {
		
		return customerRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Object updateCustomer(Customer customer) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		if(customer.getName().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Name");
			}
		else if (customer.getContact().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Contact");
		}
		
		else if(customer.getAddress().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "Please the Address");
		}
		
		else if (customer.getDeliver_date().isEmpty()) {
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Delivery Date");
		}
		else if (customer.getOrder_date().isEmpty()) {
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Order Date");
		}
		else if (customer.getPay_mode().isEmpty()) {
			map.put("Status", "Error");
			map.put("Msg", "Please Select the Payyment Mode");
		}
		else if (customer.getTotal_amt()==0) {
			map.put("Status", "Error");
			map.put("Msg", "Please Enter the Total amount");
		}
		else
			{
//				customerRepo.saveAndFlush(customer);
			customerRepo.saveAndFlush(customer);
				map.put("Status", "Success");
				map.put("Msg", "Updated Saved Successfully");
			}
		return map;
	}

	@Override
	public Object deleteCustomer(int id) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		if(id==0)
		{
			map.put("Status", "Error");
			map.put("Msg","Invalid ID");
			}
		else
		{
			customerRepo.deleteById(id);
			map.put("Status", "Success");
			map.put("Msg", "Data Deleted Successfully");
		}
		
		return map;	}

	

	


}
