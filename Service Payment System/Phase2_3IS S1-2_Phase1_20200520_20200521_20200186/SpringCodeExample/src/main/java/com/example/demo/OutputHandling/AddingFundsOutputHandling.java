package com.example.demo.OutputHandling;
import com.example.demo.Payment.CreditCard;
import com.example.demo.Payment.Wallet;

public class AddingFundsOutputHandling
{
	
	public String printMoney(Wallet wallet,CreditCard card)
	{
		String string="";
		
		string+= "Successful Adding Funds\n";
		string+= "Money in Wallet = "+Double.toString(wallet.money) + "\n";
		string+= "Money in Credit Card = "+ Double.toString(card.creditCardMoney);
		
		return string;
	}
	
}
