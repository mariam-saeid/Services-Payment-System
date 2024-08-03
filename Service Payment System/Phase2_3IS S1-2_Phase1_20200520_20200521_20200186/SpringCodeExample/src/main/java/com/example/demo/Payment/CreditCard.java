package com.example.demo.Payment;


//pay for service by card
public class CreditCard implements Payment
{
	public long creditCardNumber;
	public double creditCardMoney;
	
	public void setCreditCardNum (long num)
	{
		creditCardNumber = num;
	}
	
	public void setcreditCardMoney (double m)
	{
		creditCardMoney = m;
	}
	
	// function check if there is enough money or not to pay
	public boolean checkMoney(double price)
	{
		if (creditCardMoney>=price) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
    public void pay (double price)
    {
    	// withdraw money from credit card
    	creditCardMoney -= price;
    };
    
  
}
