package com.example.demo.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OutputHandling.SearchOutputHandling;
import com.example.demo.Search.Search;
import com.example.demo.Services.Services;

@RestController
public class SearchController 
{
	SearchOutputHandling searchOutputHandling;
	InitialData data;
	Search ser;
	
	public SearchController()
	{
		searchOutputHandling =new SearchOutputHandling();
		data = InitialData.getInstance();
		ser = new Search();
	}
	
	@GetMapping(value = "/search/{name}")
	public String handleSerach(@PathVariable("name") String name)
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		else 
		{
			ArrayList<Services> match = ser.serach(name,data.services);
			
			String string=searchOutputHandling.printSearch(match);
			
			return string;
		}
		
		
	}
}
