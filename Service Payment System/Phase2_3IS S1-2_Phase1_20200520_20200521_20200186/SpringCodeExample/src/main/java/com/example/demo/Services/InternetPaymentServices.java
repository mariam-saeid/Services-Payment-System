package com.example.demo.Services;

public class InternetPaymentServices extends Services 
{	
	public InternetPaymentServices() 
	{
		serviceName = "Internet Payment Services";
	}
	
	// decorator method implementation
	public double cost()
	{
		return 20;
	}
}
