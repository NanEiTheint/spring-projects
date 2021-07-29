package com.mmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index()
	{
		return "redirect:/customers";//redirect call "customers" route (no view)
	}

}
