package com.mmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index()
	{
		return "home";
	}
	
	@GetMapping("/demo/{name}")
	public String pathParamerer(@PathVariable(value = "name") String na,ModelMap model)
	{
		model.put("result", "Hello "+na);//carry value to view with model
		//or
		//model.addAttribute("result","Hello"+name);//carry value to view with model
		return "home";
	}
	
	@RequestMapping("/demo/query")
	public String queryVariable(ModelMap model,@RequestParam String name,@RequestParam int age)
	{
		model.addAttribute("result","Hello "+name+". Your age "+age);
		return "home";
	}

}
