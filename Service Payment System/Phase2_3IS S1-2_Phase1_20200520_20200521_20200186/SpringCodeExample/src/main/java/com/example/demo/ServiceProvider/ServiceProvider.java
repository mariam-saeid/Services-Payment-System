package com.example.demo.ServiceProvider;

import java.util.ArrayList;

import com.example.demo.Services.Services;

//Receipt for mobile recharge and internet payment
public abstract class ServiceProvider 
{
	public Form form;
	public ArrayList<Services> service;
	
	// factory method
	public abstract void createService (String serviceName);
	
	// form for service provider
	public void addForm (Form f) 
	{
		form = f;
	}
	
	public Form getForm() 
	{
		return form;
	}
	
	// services for service provider
	public ArrayList<Services> getService ()
	{
		return service;
	}
}
