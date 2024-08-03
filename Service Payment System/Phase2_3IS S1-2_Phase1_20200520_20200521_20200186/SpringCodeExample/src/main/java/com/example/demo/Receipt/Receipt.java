package com.example.demo.Receipt;

import com.example.demo.ServiceProvider.Form;
import com.example.demo.Services.Services;

//Receipt for landline
public abstract class Receipt 
{
	public Form form;
	public Services service;
	
	// factory method
	public abstract void createService (String serviceName);
	
	// form for receipt
	public void addForm (Form f) 
	{
		form = f;
	}
	
	public Form getForm() 
	{
		return form;
	}
	
	// service for organizations
	public Services getService ()
	{
		return service;
	}
}
