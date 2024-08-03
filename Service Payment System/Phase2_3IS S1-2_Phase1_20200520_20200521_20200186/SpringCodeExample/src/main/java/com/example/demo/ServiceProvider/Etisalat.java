package com.example.demo.ServiceProvider;

import java.util.ArrayList;
import com.example.demo.Services.InternetPaymentServices;
import com.example.demo.Services.MobileRechargeServices;
import com.example.demo.Services.Services;

public class Etisalat extends ServiceProvider
{
	public Etisalat() 
	{
		service = new ArrayList<Services>();
	}
	// factory method implementations
	public void createService (String serviceName)
	{
		if (serviceName.equals("Mobile Recharge Services"))
		{
			service.add(new MobileRechargeServices());
		}
		else if (serviceName.equals("Internet Payment Services"))
		{
			service.add(new InternetPaymentServices());
		}
	}
}
