package com.example.demo.Transaction;

import com.example.demo.Services.Services;

public interface Transaction 
{
	public void setMoney(double m);
	public double getMenoy();
	
	public void setService(Services s);
	public Services getService();
	
	public void setType(String type);
	public String getType();
}
