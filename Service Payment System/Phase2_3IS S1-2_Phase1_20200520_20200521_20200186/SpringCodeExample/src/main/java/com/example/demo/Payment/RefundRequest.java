package com.example.demo.Payment;

import com.example.demo.Services.Services;
import com.example.demo.User.User;

//User Refund Request
public class RefundRequest 
{
	// unique name for each request
	public String unique;
	// Request service
	public Services service;
	// Request money
	public double amount;
	// user who ask for this request
	public User user;
	
	public void setService (Services s)
	{
		service = s;
	}
	
	public void setAmount (double a)
	{
		amount = a;
	}
	
	public void setUser (User u)
	{
		user = u;
	}
	
	public void setUnique (String unique)
	{
		this.unique = unique;
	}
}
