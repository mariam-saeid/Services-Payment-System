package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OutputHandling.DiscountsOutputHandling;

@RestController
public class DiscountsController 
{
	DiscountsOutputHandling discountsOutputHandling;
	InitialData data;
	
	public DiscountsController() 
	{
		discountsOutputHandling = new DiscountsOutputHandling();
		data = InitialData.getInstance();
	}
	
	@GetMapping(value = "/showdiscounts")
	public String getDiscounts()
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		return discountsOutputHandling.showDiscounts(data);
	}
}
