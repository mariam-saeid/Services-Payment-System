package com.example.demo.OutputHandling;

import com.example.demo.Controller.InitialData;

public class DiscountsOutputHandling 
{
	public String showDiscounts(InitialData data)
	{
		String string = "";
		string+= "Etisalat\n";
		string+="---------\n";
		for (int i=0;i<data.e.service.size();i++)
		{
			string+= data.e.service.get(i).getServiceName()+"	";
			string+= Double.toString(data.e.service.get(i).getDiscount())+"%\n";
		}
		string+="\nOrange\n";
		string+="--------\n";
		for (int i=0;i<data.o.service.size();i++)
		{
			string+= data.o.service.get(i).getServiceName()+"	";
			string+= Double.toString(data.o.service.get(i).getDiscount())+"%\n";
		}
		string+="\nWe\n";
		string+="-----\n";
		for (int i=0;i<data.w.service.size();i++)
		{
			string+= data.w.service.get(i).getServiceName()+"	";
			string+= Double.toString(data.w.service.get(i).getDiscount())+"%\n";
		}
		string+="\nVodafone\n";
		string+="----------\n";
		for (int i=0;i<data.v.service.size();i++)
		{
			string+=data.v.service.get(i).getServiceName()+"	";
			string+= Double.toString(data.v.service.get(i).getDiscount())+"%\n";
		}
		string+="\nLandline for Monthly Receipt\n";
		string+="-----------------\n";
		string+="Discount = "+Double.toString(data.mR.service.getDiscount())+"%\n";
		
		string+="\nLandline for Quarter Receipt\n";
		string+="-----------------\n";
		string+="Discount = "+Double.toString(data.qR.service.getDiscount())+"%\n";
		
		string+="\nDonations for School\n";
		string+="-----------------------\n";
		string+="Discount = "+Double.toString(data.school.service.getDiscount())+"%";
		
		string+="\nDonations for Cancer Hospital\n";
		string+="-------------------------------\n";
		string+="Discount = "+Double.toString(data.cancer.service.getDiscount())+"%\n";
		
		string+="\nDonations for NGOs\n";
		string+="---------------------\n";
		string+="Discount = "+Double.toString(data.ngo.service.getDiscount())+"%\n";
		
		return string;
	}
}
