package com.example.demo.OutputHandling;

import java.util.ArrayList;
import com.example.demo.Transaction.PaymentTransaction;
import com.example.demo.Transaction.Transaction;


public class RefundRequestOutputHandling 
{
	
	public String printTransactions(ArrayList<Transaction> transactions)
	{
		String string="";
		string+= "All Transactions:\n";  // print all user transactions
		for (int i=0;i<transactions.size();i++)
		{
			if (transactions.get(i) instanceof PaymentTransaction) 
			{
				string+= "num = "+ Integer.toString(i+1)+"\n";
				string+="service: " +transactions.get(i).getService().getServiceName()+ "\n";
				string+= "money = "+Double.toString(transactions.get(i).getMenoy())+"\n";
				string += "Paid via = "+transactions.get(i).getType() + "\n";
			}
			
		}
		
		string+="\n go to url (post --> /askforrefund "
				+ "and enter transaction num you want to refund in requset body";
		
		return string;
	}
}
