package com.example.demo.Payment;


//pay for service by wallet
public class Wallet implements Payment
{
	public double money = 0;
	
	// function check if there is enough money or not to pay
	public boolean checkMoney(double price)
	{
		if (money>=price) 
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
    	// withdraw money from wallet
    	money-=price;
    };
}
