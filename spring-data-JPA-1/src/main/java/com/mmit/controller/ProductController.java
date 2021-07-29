package com.mmit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmit.entity.Product;
import com.mmit.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	public ProductService service;
	
	@GetMapping
	public String index(ModelMap model)
	{
		List<Product> pList=service.findAll();
		model.addAttribute("productList",pList);
		return "home";
	}
	
	@GetMapping("product-add")
	public String add(ModelMap model)
	{
		model.addAttribute("product", new Product());
		return "add";
	}
	
	@GetMapping("product-edit/{id}")
	public String edit(@PathVariable String id,ModelMap model)
	{
		if(id!=null || id!="")
		{
			Product p=service.findById(Integer.parseInt(id));
			model.addAttribute("product",p );
		}
		return "add";
	}

	@PostMapping("/product-save")
	public String save(Product product)
	{
		service.saveProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/product-remove/{id}")
	public String remove(@PathVariable String id)
	{
		service.deleteById(Integer.parseInt(id));
		return "redirect:/";
	}
	
	@PostMapping("/product-search")
	public String serach(@RequestParam ("price") String price,ModelMap model)
	{
		List<Product> proList=service.findByPrice(Integer.parseInt(price));
		if(proList!=null && !proList.isEmpty())
		{
			model.addAttribute("productList",proList);
			model.addAttribute("price", price);
			return "home";
		}
		else
			return "redirect:/";
		
		
		
	}


}
