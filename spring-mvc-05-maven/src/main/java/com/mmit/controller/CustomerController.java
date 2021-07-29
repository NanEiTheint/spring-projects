package com.mmit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmit.entity.Customer;
import com.mmit.entity.Customer.Gender;
import com.mmit.entity.CustomerRepository;

@Controller
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired //like @Inject
	private CustomerRepository repo;
	
	@GetMapping()
	public String allCustomers(ModelMap model)
	{
		model.addAttribute("custList", repo.findAll());
		return "home";
	}
	
	@GetMapping("add")
	public String addCustomer(ModelMap model)
	{
		//model.addAttribute("cust", new Customer());
		//go to commmon obj model attribute for create object if not use above statement
		
		model.addAttribute("genders", Gender.values());
		return "add";
	}
	@PostMapping("save")
	public String saveCustomer(Customer customer)
	{
		repo.setCustomer(customer);
		return "redirect:/customers";//go route
	}
	
	//commmon obj model attribute
	@ModelAttribute("cust")
	public Customer customer()
	{
		return new Customer();
	}
}
