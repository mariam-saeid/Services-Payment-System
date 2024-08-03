package com.example.demo.Search;

import java.util.ArrayList;
import com.example.demo.Services.Services;

// Search for Service
public class Search 
{	
	// function return all services that match the user query 
	public ArrayList<Services> serach (String name,ArrayList<Services> servicesList)
	{
		ArrayList<Services> servicesMatch = new ArrayList<Services>();
		
		name = name.toLowerCase();
		
		for (int i=0;i<servicesList.size();i++)
		{
			String n = servicesList.get(i).getServiceName().toLowerCase();
			
			if(n.indexOf(name)!=-1)
			{
				servicesMatch.add(servicesList.get(i));
			}
		}
		
		return servicesMatch;
	}
}


