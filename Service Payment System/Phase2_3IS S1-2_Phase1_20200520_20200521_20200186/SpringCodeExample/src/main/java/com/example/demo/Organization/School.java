package com.example.demo.Organization;

import com.example.demo.Services.Donations;

public class School extends Organization 
{
	// factory method implementations
	public void createService (String serviceName)
	{
		if (serviceName.equals("Donations"))
		{
			service = new Donations();
		}
	}
}
