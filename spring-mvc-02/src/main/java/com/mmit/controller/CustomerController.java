package com.mmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")//link start this name every method
public class CustomerController {
	
	@GetMapping
	public String viewCustomers()
	{
		return "customers";
	}
	
	@GetMapping("add")
	public String addCustomer()
	{
		return "customer-add";
	}
	@RequestMapping("public")
	public String commonRoute()
	{
		return "home";
	}

}
