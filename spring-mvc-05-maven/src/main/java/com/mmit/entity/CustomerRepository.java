package com.mmit.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

@Repository
@ApplicationScope
public class CustomerRepository {
	
	public List<Customer> customerList;
	
	public CustomerRepository()
	{
		customerList=new ArrayList<Customer>();
	}
	
	public List<Customer> findAll()
	{
		return customerList;
	}

	public void setCustomer(Customer customer)
	{
		customerList.add(customer);
	}
	
}
