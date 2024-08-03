package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Discounts.OverallDiscount;
import com.example.demo.Discounts.SpecificDiscount;
import com.example.demo.OutputHandling.PaymantOutputHandling;
import com.example.demo.Transaction.Transaction;
import com.example.demo.Payment.CacheOnDelivery;
import com.example.demo.Payment.Payment;
import com.example.demo.ServiceProvider.Form;
import com.example.demo.ServiceProvider.ServiceProvider;
import com.example.demo.Services.Services;
import com.example.demo.Transaction.PaymentTransaction;

@RestController
public class PaymantController 
{
	public InitialData data;
	public PaymantOutputHandling paymantOutputHandling;
	boolean showService = false;
	boolean showServiceProvider = false;
	boolean chooseProvider = false;
	boolean showForm = false;
	boolean enterForm = false;
	boolean showPay = false;
	private Services choosenService;
	private int choosenserviceNum = -1;
	private Form form;
	private double amount;
	
	public PaymantController() 
	{
		data = InitialData.getInstance();
		paymantOutputHandling = new PaymantOutputHandling();
	}
	
	
	@GetMapping(value ="/showservice")
	public String getService()
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		showService = true;
		return paymantOutputHandling.printServicestoChoose(data.services);
	}
	
	// choose service and service provider supports this service
	@PostMapping(value ="/chooseservice")
	public String chooseService(@RequestBody String n)
	{
		int serviceNum = Integer.parseInt(n);
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		if (showService == false) 
		{
			return "show services first using url (get --> /showservice)";
		}
		
		if(serviceNum>data.services.size())
			return "invaild service num";
		
		// choose service from printed services
		choosenService = data.services.get(serviceNum-1);
		choosenserviceNum = serviceNum;
		
		return "Chosen Successfully \n go to url (get --> /showserviceprovider) to show service provider";
	}
	
	@GetMapping(value ="/showserviceprovider")
	public String getServiceProvider()
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		if (choosenserviceNum == -1) 
		{
			return "choose service first using url (post --> /chooseservice)";
		}
		
		showServiceProvider = true;
		
		String string="";
		
		// choose internet or Mobile service provider
		if (choosenService.getServiceName().equals("Internet Payment Services") ||
				choosenService.getServiceName().equals("Mobile Recharge Services")) 
		{
			ArrayList<ServiceProvider> sp = InternetAndMoblieProvider(choosenserviceNum);
			string = paymantOutputHandling.chooseInternetAndMoblieProvider(sp,data);
		}
		// choose landline service provider
		else if (choosenService.getServiceName().equals("Landline Services"))
		{
			string = paymantOutputHandling.chooseLandlineProvider();
		}
		// choose donations service provider
		else if (choosenService.getServiceName().equals("Donations"))
		{
			string = paymantOutputHandling.chooseDonationsProvider();
		}
		
		return string;
		
	}
	
	
	@PostMapping(value ="/chooseserviceprovider")
	public String chooseServiceProvider(@RequestBody String ch)
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		if (showServiceProvider == false) 
		{
			return "show services first using url (get --> /showserviceprovider)";
		}
		
		form = new Form();
		
		chooseProvider = true;

		// check which service provider 
		 if (ch.equals("e") && choosenService.getServiceName().equals("Internet Payment Services") || 
				 choosenService.getServiceName().equals("Mobile Recharge Services"))
		 {
			 for(int i=0;i<data.e.service.size();i++)
			 {
				 if (data.e.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.e.service.get(i); // make choosen service = this service in Etisalat
					break;
				}
			 }
			 // Etisalat form
			 form = data.e.form;
		 }
		 
		 else if (ch.equals("o") && choosenService.getServiceName().equals("Internet Payment Services") || 
				 choosenService.getServiceName().equals("Mobile Recharge Services")) 
		 {
			 for(int i=0;i<data.o.service.size();i++)
			 {
				 if (data.o.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.o.service.get(i);  // make choosen service = this service in Orange
					break;
				}
			 }
			// Orange form
			 form = data.o.form;
		}
		 
		else if (ch.equals("w") && choosenService.getServiceName().equals("Internet Payment Services") || 
				 choosenService.getServiceName().equals("Mobile Recharge Services")) 
		{
			 for(int i=0;i<data.w.service.size();i++)
			 {
				 if (data.w.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.w.service.get(i);  // make choosen service = this service in We
					break;
				}
			 }
			// We form
			 form = data.w.form;
			
		}
		 else if (ch.equals("v") && choosenService.getServiceName().equals("Internet Payment Services") || 
				 choosenService.getServiceName().equals("Mobile Recharge Services")) 
		 {
			 for(int i=0;i<data.v.service.size();i++)
			 {
				 if (data.v.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.v.service.get(i);  // make choosen service = this service in Vodafone
				}
			 }
			// Vodafone form
			 form = data.v.form;
		}
		 
		 else if(ch.equals("m") && choosenService.getServiceName().equals("Landline Services"))
		 {
			 choosenService = data.mR.service; // make choosen service = this service in Monthly Receipt
			// Monthly Receipt form
			 form = data.mR.form;
		 }
		 
		 else if(ch.equals("q") && choosenService.getServiceName().equals("Landline Services"))
		 {
			 choosenService = data.qR.service; // make choosen service = this service in Quarter Receipt
			// display Quarter Receipt form
			 form = data.qR.form;
		 }
		 
		 else if(ch.equals("s")&& choosenService.getServiceName().equals("Donations"))
		 {
			 choosenService = data.school.service; // make choosen service = this service in Schools
			// display Schools form
			 form = data.school.form;
		 }
		 
		 else if(ch.equals("c")&& choosenService.getServiceName().equals("Donations"))
		 {
			 choosenService = data.cancer.service;  // make choosen service = this service in Cancer Hospital
			// display Cancer Hospital form
			 form = data.cancer.form;
		 }
		 
		 else if(ch.equals("n")&& choosenService.getServiceName().equals("Donations"))
		 {
			 choosenService = data.ngo.service;  // make choosen service = this service in NGOs
			// display NGOs form
			 form = data.ngo.form;
		 }
		 else {
			return "Invaild char";
		}
		 //***************************************************************************
		 return "Chosen Successfully \n go to url (get --> /showform) to show form for this service provider";
	}
	
	@GetMapping(value ="/showform")
	public String getForm()
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		
		if (chooseProvider == false) 
		{
			return "choose service provider first using url (post --> /chooseserviceprovider)";
		}
		
		showForm = true;
		String string = paymantOutputHandling.printForm(form);
		
		return string;
	}
	
	@PostMapping(value ="/handleform")
	public String handleForm(@RequestBody Map<String, String> map)
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		
		if (showForm == false) 
		{
			return "show form first using url (get --> /showform)";
		}
		
		enterForm = true;
		
		amount = Double.parseDouble(map.get("amount"));
		ArrayList<String> answers = new ArrayList<String>();
		for (int i=0;i<form.fields.size();i++)
		{
			answers.add(map.get(form.fields.get(i)));
		}
		
		return "Entering Successfully \n go to url (get --> /showpaymenu) to show options";
	}
	
	@GetMapping(value ="/showpaymenu")
	public String getPayMenu()
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		
		if (enterForm == false) 
		{
			return "enter form first using url (post --> /handleform)";
		}
		
		showPay = true;
		return paymantOutputHandling.payMenu(choosenService);
		 
	}
	
	//choose which way to pay 
	@PostMapping(value ="/pay")
	private String choosePayWay(@RequestBody String n)
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		
		if (showPay == false) 
		{
			return "show pay menu first using url (get --> /showpaymenu)";
		}
		
		int payNum = Integer.parseInt(n);
		
		if (payNum==1) 
		{
			// make new payment transaction
			Transaction t = new PaymentTransaction();
			t.setService(choosenService);
			t.setType("Credit Card");
			// apply decorator (add discounts)
			choosenService = new SpecificDiscount(choosenService.discount, choosenService);
			
			int counter = 0;
			//check num of payment transaction
			for (int i=0;i<data.userController.getTransactions().size();i++)
			{
				if (data.userController.getTransactions().get(i) instanceof PaymentTransaction) 
				{
					counter++;
				}	
			}
			
			// if it is user first transaction
			if (counter==0) 
			{
				choosenService = new OverallDiscount(7, choosenService);
			}
			
			// decorator function
			Double price = choosenService.cost();
			t.setMoney(price+amount);
			// check if there is enough money in credit card
			if (data.userController.getCard().checkMoney(price+amount)==true) 
			{
				data.userController.getCard().pay(price+amount);
				data.userController.userAddTransaction(t);
			}
			else 
			{
				return "No Enough Money in Credit Card";
			}
		}
		else if (payNum==2) 
		{
			// make new payment transaction
			Transaction t = new PaymentTransaction();
			t.setService(choosenService);
			t.setType("Wallet");
			// apply decorator (add discounts)
			choosenService = new SpecificDiscount(choosenService.discount, choosenService);
			
			int counter = 0;
			//check num of payment transaction
			for (int i=0;i<data.userController.getTransactions().size();i++)
			{
				if (data.userController.getTransactions().get(i) instanceof PaymentTransaction) 
				{
					counter++;
				}	
			}
			
			// if it is user first transaction
			if (counter==0) 
			{
				choosenService = new OverallDiscount(7, choosenService);
			}
			
			// decorator function 
			Double price = choosenService.cost();
			t.setMoney(price+amount);
			// check if there is enough money in wallet
			if (data.userController.getWallet().checkMoney(price+amount)==true) 
			{
				data.userController.getWallet().pay(price+amount);
				data.userController.userAddTransaction(t);
			}
			else {
				return "No Enough Money in Wallet";
			}

		}
		else if (payNum==3) 
		{
			if (choosenService.getAcceptCash()==false) 
			{
				return "invaild num";
			}
			
			// make new payment transaction
			Transaction t = new PaymentTransaction();
			t.setService(choosenService);
			t.setType("Cash On Delivery");
			// apply decorator (add discounts)
			choosenService = new SpecificDiscount(choosenService.discount, choosenService);
			
			int counter=0;
			//check num of payment transaction
			for (int i=0;i<data.userController.getTransactions().size();i++)
			{
				if (data.userController.getTransactions().get(i) instanceof PaymentTransaction) 
				{
					counter++;
				}	
			}
			
			// if it is user first transaction
			if (counter==0) 
			{
				choosenService = new OverallDiscount(7, choosenService);
			}
			
			// decorator function 
			Double price = choosenService.cost();
			t.setMoney(price+amount);
			Payment cash = new CacheOnDelivery(); 
			cash.pay(price+amount);
			data.userController.userAddTransaction(t);
		}
		
		else 
		{
			return "invaild num";
		}
		
		return "Sucessfull Payment";
}
	
	// internet or moblie service provider list
	private ArrayList<ServiceProvider> InternetAndMoblieProvider(int serviceNum)
	{
		ArrayList<ServiceProvider> sp = new ArrayList<ServiceProvider>();
		for (int i=0;i<data.e.getService().size();i++)  // loop check if Etisalat support this service
		 {
			// check if Etisalat has service whose name equal to choosen service name
			if (data.e.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
			{
				sp.add(data.e);
			}
		 }
		 
		 for (int i=0;i<data.o.getService().size();i++) // loop check if Orange support this service
		 {
			// check if Orange has service whose name equal to choosen service name
			if (data.o.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
			{
				sp.add(data.o);
			}
		 }
		 
		 for (int i=0;i<data.w.getService().size();i++)  // loop check if We support this service
		 {
			// check if We has service whose name equal to choosen service name
			if (data.w.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
			{
				sp.add(data.w);
			}
		 }
		 
		 for (int i=0;i<data.v.getService().size();i++)  // loop check if Vodafone support this service
		 {
			// check if Vodafone has service whose name equal to choosen service name
			if (data.v.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
			{
				sp.add(data.v);
			}
		 }
		 
		 return sp;
	}
	
}
