package com.example.demo.Admin;

import java.util.ArrayList;
import com.example.demo.Payment.RefundRequest;
import com.example.demo.Transaction.PaymentTransaction;
import com.example.demo.Transaction.RefundTransaction;
import com.example.demo.Transaction.Transaction;

// Admin for System
public class Admin 
{
	// refund requests list
	public ArrayList<RefundRequest> refundRequests;
	public ArrayList<Transaction> transactions;
	
	public Admin ()
	{
		refundRequests = new ArrayList<RefundRequest>();
	}
	
	// function to accept or reject request
	public void replyRequest (String s,boolean accept)
	{
		int i=0;
		// search about refund request in list using unique name
		for (;i<refundRequests.size();i++)
		{
			if (refundRequests.get(i).unique.equals(s)) 
			{
				// if admin accept request
				if (accept==true) 
				{
					// return money to user wallet 
					refundRequests.get(i).user.wallet.money += refundRequests.get(i).amount;
					
					// loop in user transactions list to find the transaction that user refunds and remove it
					for (int j=0;j<refundRequests.get(i).user.transactions.size();j++)
					{
						if (refundRequests.get(i).user.transactions.get(j) instanceof PaymentTransaction) 
						{
							if (refundRequests.get(i).user.transactions.get(j).getService()==refundRequests.get(i).service) 
							{
								if (refundRequests.get(i).user.transactions.get(j).getMenoy()==refundRequests.get(i).amount)
								{
									// make refund transaction
									Transaction transaction = new RefundTransaction();
									transaction.setMoney(refundRequests.get(i).amount);
									transaction.setService(refundRequests.get(i).service);
									transaction.setType("Wallet");
									
									// remove payment transaction
									refundRequests.get(i).user.transactions.remove(j);
									
									// add refund transaction to user
									refundRequests.get(i).user.transactions.add(transaction);
								
									// remove request from list
									refundRequests.remove(i);
									break;
								}
							}
						}
						
					}
				}
				// if admin reject request
				else if (accept==false)
				{
					// remove request from list
					refundRequests.remove(i);
				}
			}
		}
	}
	
	// function add request to list
    public void addRequest(RefundRequest refundRequest)
    {
    	boolean found = false;
    	// check if this refund request already exists so don't add it
    	for (int i=0;i<refundRequests.size();i++)
    	{
    		if (refundRequest.amount==refundRequests.get(i).amount) 
    		{
				if (refundRequest.service==refundRequests.get(i).service)
				{
					found = true;
					break;
				}
			}
    	}
    	// if not found in list, add it
    	if (found==false) 
    	{
			refundRequests.add(refundRequest);
		}
    }
    
    public void listTransactions(ArrayList<Transaction> transactions)
    {
    	this.transactions=transactions;
	}
}
