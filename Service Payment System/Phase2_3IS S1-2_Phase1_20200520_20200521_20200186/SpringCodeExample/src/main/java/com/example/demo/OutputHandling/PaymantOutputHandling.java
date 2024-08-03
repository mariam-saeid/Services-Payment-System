package com.example.demo.OutputHandling;

import java.util.ArrayList;
import com.example.demo.ServiceProvider.Form;
import com.example.demo.ServiceProvider.ServiceProvider;
import com.example.demo.Services.Services;
import com.example.demo.Controller.InitialData;

public class PaymantOutputHandling 
{
	public String printServicestoChoose(ArrayList<Services> services) 
	{
		String string = "";
		string+="Services:\n";
		for (int i=0;i<services.size();i++)  // loop print service on system data
		{
			string+= Integer.toString(i+1)+") "+services.get(i).getServiceName()+"\n";
		}
		
		string+="\n go to url (post --> /chooseservice) "
				+ "and enter service num you want to pay for in request body";
		
		return string;
	}
	
	public String chooseInternetAndMoblieProvider(ArrayList<ServiceProvider> sp,InitialData data)
	{
		 //choose which service provider user wants
		String string = "";
		 System.out.println("The provider for this service:");
		 for (int i=0; i<sp.size();i++)
		 {
			 if (sp.get(i)==data.e) 
			 {
				 string+="Enter e for Etisalat \n";
			}
			 else if (sp.get(i)==data.o) 
			 {
				 string+="Enter o for Orange \n";
			}
			 else if (sp.get(i)==data.w) 
			 {
				 string+="Enter w for We \n";
			}
			 else if (sp.get(i)==data.v) 
			 {
				 string+="Enter v for Vodafone \n";
			}
		 }
		 
		 string+="\n go to url (post --> /chooseserviceprovider) "
					+ "and enter service provider char in requset body";
		 
		 return string;
	}
	
	public String chooseLandlineProvider()
	{
		String string="";
		
		string+="The receipt for this service: \n";
		string+="Enter m for Monthly Receipt \n";
		string+="Enter q for Quarter Receipt \n";
		
		string+="\n go to url (post --> /chooseserviceprovider) "
				+ "and enter service provider char in requset body";
		
		return string;
	}
	
	public String chooseDonationsProvider()
	{
		String string="";
		string+="The organization for this service: \n";
		string+="Enter s for School \n";
		string+="Enter c for Cancer Hospital \n";
		string+="Enter n for NGOs  \n";
		
		string+="\n go to url (post --> /chooseserviceprovider) "
				+ "and enter service provider char in requset body";
		
		return string;
	}
	
	public String printForm(Form form) 
	{
		String string = "";
		string +="The Form \n";
		
		string+="amount\n";
		for(int i=1;i<form.fields.size();i++)
		{
			string+=form.fields.get(i)+"\n";
		}
		
		string+="\n go to url (post --> /handleform) and enter form fields in requset body";
		
		return string;
	}
	
	public String payMenu(Services choosenService)
	{
		String string = "";
		
		string+="Payment Mnue:\n";
		string+="1) Credit Card\n";
		string+="2) Wallet\n";
		if (choosenService.getAcceptCash()==true) 
		{
			string+="3) Cash On Delivery\n";
		}
		
		string+="\n go to url (post --> /pay) and enter pay option num in requset body";
		
		return string;
	}
}
