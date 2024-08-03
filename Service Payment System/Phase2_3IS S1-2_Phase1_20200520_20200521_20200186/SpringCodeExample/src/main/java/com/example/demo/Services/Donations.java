package com.example.demo.Services;

public class Donations extends Services 
{
	public Donations() 
	{
		serviceName = "Donations";
	}
	
	// decorator method implementation
	public double cost()
	{
		return 10;
	}
}
