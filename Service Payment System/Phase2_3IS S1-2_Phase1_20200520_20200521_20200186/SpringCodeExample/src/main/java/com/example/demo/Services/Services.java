package com.example.demo.Services;

// services which provided by system
public abstract class Services 
{
	// name for each service
	protected String serviceName;
	// discount of this service
	public double discount;
	// this service accepts cash or not
	protected boolean acceptCash = false;
	
	// decorator method
	public abstract double cost();
	
	public void addDiscount (Double d) 
	{
		discount = d;
	}
	
	public String getServiceName ()
	{
		return serviceName;
	}
	
	public double getDiscount()
	{
		return discount;
	}
	
	public void setAcceptCash (boolean a)
	{
		acceptCash = a;
	}
	
	public boolean getAcceptCash ()
	{
		return acceptCash;
	}
	
	
}
