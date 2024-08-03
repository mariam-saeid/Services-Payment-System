package com.example.demo.Discounts;
import com.example.demo.Services.Services;

// discount for specific service

public class SpecificDiscount extends Discount
{
	public SpecificDiscount(double percentage,Services service) 
	{
		super(percentage, service);
	}
	
	// decorator pattern function  
	public double cost()
	{
		return service.cost()-(service.cost()*percentage/100);
	}
}
