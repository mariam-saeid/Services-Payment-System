package com.example.demo.Services;


public class LandlineServices extends Services 
{	
	public LandlineServices()
	{
		serviceName = "Landline Services";
	}
	
	// decorator method implementation
	public double cost()
	{
		return 5;
	}
}
