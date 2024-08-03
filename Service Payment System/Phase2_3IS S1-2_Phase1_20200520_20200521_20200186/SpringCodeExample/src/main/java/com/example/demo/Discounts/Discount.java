package com.example.demo.Discounts;
import com.example.demo.Services.Services;

// make discounts on services
public abstract class Discount extends Services
{
	protected double percentage;
	protected Services service;
	
	public Discount(double percentage,Services service) 
	{
		this.percentage = percentage;
		this.service = service;
	}
	
	public void setPercentage (double percentage)
	{
		this.percentage = percentage;
	}
	
	
	public void setService (Services service)
	{
		this.service = service;
	}
	
}
