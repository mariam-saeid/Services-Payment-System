package com.example.demo.Transaction;

import com.example.demo.Services.Services;

public class AddToWalletTransaction implements Transaction
{
	// transaction service
	public Services ser;
	// transaction money
	public double money;
	//payment way
	public String type;

	public void setMoney(double m)
	{
		money = m;
	}
	
	public double getMenoy()
	{
		return money;
	}
	
	public void setService(Services s)
	{
		ser = s;
	}
	
	public Services getService()
	{
		return ser;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	public String getType()
	{
		return type;
	}
	
}
