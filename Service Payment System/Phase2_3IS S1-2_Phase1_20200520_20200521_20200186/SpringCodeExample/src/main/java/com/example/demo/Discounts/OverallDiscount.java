package com.example.demo.Discounts;
import com.example.demo.Services.Services;

//discount for any service

public class OverallDiscount extends Discount
{
	public OverallDiscount(double percentage,Services service) 
	{
		super(percentage, service);
	}
	
	// decorator pattern function  
	public double cost()
	{
		return service.cost()-(service.cost()*percentage/100);
	}
}
