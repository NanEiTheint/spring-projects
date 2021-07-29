package com.mmit.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index()
	{
		return "home";
	}

	@GetMapping("/string")
	public String stringReturnType(ModelMap model)
	{
	
		model.addAttribute("message","This is String Return Type.");
		return "string";
	}
	@GetMapping("/modelandview")
	public ModelAndView modelAndView(ModelMap model)
	{
		model.addAttribute("message", "This is model and view.");
		ModelAndView mv=new ModelAndView("model-view");
		return mv;
	}
	
	@GetMapping("/no-return-type")
	public void noReturnType(ModelMap model)
	{
		model.addAttribute("message", "This is no return type.");
	}
}
