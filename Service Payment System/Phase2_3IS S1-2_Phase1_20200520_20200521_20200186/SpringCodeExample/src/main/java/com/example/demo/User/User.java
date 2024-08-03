package com.example.demo.User;

import java.util.ArrayList;
import com.example.demo.Payment.CreditCard;
import com.example.demo.Transaction.Transaction;
import com.example.demo.Payment.Wallet;
import com.example.demo.Payment.RefundRequest;

public class User
{
	// user info
	public String userName;
	public String password;
	public String email;
	public Registration registration;
	// user wallet
	public Wallet wallet;
	// user credit card
	public CreditCard card;
	// all user transactions
	public ArrayList<Transaction> transactions;
	// all user refund requests
	public ArrayList<RefundRequest> refundRequests;
	
    public User (Registration registration)
    {
    	this.registration = registration;
		wallet =  new Wallet();
		card = new CreditCard();
		transactions = new ArrayList<Transaction>();
		refundRequests = new ArrayList<RefundRequest>();
		userName = " ";
		password = " ";
		email = " ";
    }
    
	public boolean signup (String userName,String password,String email)
	{
		this.setUserName(userName);
		this.setPassword(password);
		this.setEmail(email);
		
		return registration.checkSignUp(userName,password,email);
	};
	
	
    public boolean signIn (String email,String passwprd)
    {
    	return registration.checkSignIn(email, passwprd);
    };
    
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
    
    public void addTransaction(Transaction transaction)
    {
    	transactions.add(transaction);
    }
    
    
    public void setUserName (String userName) 
    {
		this.userName = userName;
	}
    
    public String getUserName ()
    {
    	return userName;
    }
    
    public void setPassword (String password) 
    {
		this.password = password;
	}
    
    public String getPassword ()
    {
    	return password;
    }
    
    public void setEmail (String email) 
    {
		this.email = email;
	}
    
    public String getEmail ()
    {
    	return email;
    }
    
}