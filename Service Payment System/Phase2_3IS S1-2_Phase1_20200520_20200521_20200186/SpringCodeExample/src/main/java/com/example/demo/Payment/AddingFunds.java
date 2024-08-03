package com.example.demo.Payment;


// add funds from credit card to wallet
public class AddingFunds
{
    public void addFunds(CreditCard c,Wallet w,double amount)
    {
    	// withdraw money from credit card
    	c.creditCardMoney -= amount;
    	// add money to wallet
    	w.money += amount;
    }
}
