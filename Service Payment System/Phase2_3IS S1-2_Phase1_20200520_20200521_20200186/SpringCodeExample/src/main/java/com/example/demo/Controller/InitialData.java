package com.example.demo.Controller;

import java.util.ArrayList;
import com.example.demo.Admin.Admin;
import com.example.demo.Organization.CancerHospita;
import com.example.demo.Organization.NGOs;
import com.example.demo.Organization.Organization;
import com.example.demo.Organization.School;
import com.example.demo.Receipt.MonthlyReceipt;
import com.example.demo.Receipt.QuarterReceipt;
import com.example.demo.Receipt.Receipt;
import com.example.demo.ServiceProvider.Etisalat;
import com.example.demo.ServiceProvider.Form;
import com.example.demo.ServiceProvider.Orange;
import com.example.demo.ServiceProvider.ServiceProvider;
import com.example.demo.ServiceProvider.Vodafone;
import com.example.demo.ServiceProvider.We;
import com.example.demo.Services.Donations;
import com.example.demo.Services.InternetPaymentServices;
import com.example.demo.Services.LandlineServices;
import com.example.demo.Services.MobileRechargeServices;
import com.example.demo.Services.Services;
import com.example.demo.User.Registration;
import com.example.demo.User.User;

public class InitialData 
{
	public ArrayList<Services> services;
	public ServiceProvider e;
	public ServiceProvider w;
	public ServiceProvider o;
	public ServiceProvider v;
	public Receipt mR;
	public Receipt qR;
	public Organization school;
	public Organization cancer;
	public Organization ngo;
	public Registration registration;
	public AdminController adminController;
	public UserController userController;
	private Admin admin;
	private User user;

	private InitialData() 
	{	
		registration = new Registration();
		admin = new Admin();
		adminController = new AdminController(admin);
		user = new User(registration);
		userController = new UserController(user);
		
		//create services
		services = new ArrayList<Services>();
		
		services.add(new MobileRechargeServices());
		services.add(new InternetPaymentServices());
		services.add(new LandlineServices());
		services.add(new Donations());
		
//		//create services provider etisalat
		e = new Etisalat();
		e.createService("Mobile Recharge Services");
		e.createService("Internet Payment Services");
		Form eForm = new Form();
		eForm.addField("amount");
		eForm.addField("mobile number");
		e.addForm(eForm);
		
		//add discounts for etisalat
		for (int i=0;i<e.service.size();i++)
		{
			e.service.get(i).discount = 15.0;
			e.service.get(i).setAcceptCash(true);
		}
		
		//create services provider we
		w = new We();
		w.createService("Mobile Recharge Services");
		w.createService("Internet Payment Services");
		Form wForm = new Form();
		wForm.addField("amount");
		wForm.addField("mobile number");
		w.addForm(wForm);
		
		//add discounts for we
		for (int i=0;i<w.service.size();i++)
		{
			w.service.get(i).discount = 10.0;
		}
		
		//create services provider orange
		o = new Orange();
		o.createService("Mobile Recharge Services");
		o.createService("Internet Payment Services");
		Form oForm = new Form();
		oForm.addField("amount");
		oForm.addField("phone number");
		o.addForm(oForm);
		
		//add discounts for orange
		for (int i=0;i<o.service.size();i++)
		{
			o.service.get(i).discount = 12.0;
		}
		
		//create services provider vodafone
		v = new Vodafone();
		v.createService("Mobile Recharge Services");
		v.createService("Internet Payment Services");
		Form vForm = new Form();
		vForm.addField("amount");
		vForm.addField("mobile number");
		v.addForm(vForm);
		
		//add discounts for vodafone
		for (int i=0;i<v.service.size();i++)
		{
			v.service.get(i).discount = 20.0;
			v.service.get(i).setAcceptCash(true);
		}
		
		//create monthly receipt
		mR = new MonthlyReceipt();
		mR.createService("Landline Services");
		Form mForm = new Form();
		mForm.addField("amount");
		mForm.addField("telephon number");
		mR.addForm(mForm);
		mR.service.discount = 7.0;
		
		
		//create quarter receipt
		qR = new QuarterReceipt();
		qR.createService("Landline Services");
		Form qForm = new Form();
		qForm.addField("amount");
		qForm.addField("telephon number");
		qR.addForm(qForm);
		qR.service.discount = 9.0;
		
		
		//create school organization
		school = new School();
		school.createService("Donations");
		Form sForm = new Form();
		sForm.addField("amount");
		sForm.addField("School name");
		sForm.addField("School address");
		school.addForm(sForm);
		school.service.discount = 10.0;
		
		
		//create cancer organization
		cancer = new CancerHospita();
		cancer.createService("Donations");
		Form cForm = new Form();
		cForm.addField("amount");
		cForm.addField("hospita name");
		cancer.addForm(cForm);
		cancer.service.discount = 7.0;
		
		
		//create ngo organization
		ngo = new NGOs();
		ngo.createService("Donations");
		Form nForm = new Form();
		nForm.addField("amount");
		nForm.addField("organization name");
		ngo.addForm(nForm);
		ngo.service.discount = 8.0;
		
	}
	
	private static InitialData instance = null;

    public static InitialData getInstance()
    {
        if (instance == null)
        {
            synchronized(InitialData.class)
            {
                if (instance == null)
                {
                    instance = new InitialData();
                }
            }
        }
        return instance;
    }
}
