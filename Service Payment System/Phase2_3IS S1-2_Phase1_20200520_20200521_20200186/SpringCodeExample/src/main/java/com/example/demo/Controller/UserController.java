package com.example.demo.Controller;
import java.util.ArrayList;
import com.example.demo.Payment.CreditCard;
import com.example.demo.Payment.RefundRequest;
import com.example.demo.Transaction.Transaction;
import com.example.demo.Payment.Wallet;
import com.example.demo.User.User;

public class UserController 
{
	public User user;
	
	public UserController(User user)
	{
		this.user = user;
	}
	
	public boolean userSignup(String userName,String password,String email)
	{
		return user.signup(userName, password, email);
	}
	
	public boolean userSignIn(String email,String passwprd)
	{
		return user.signIn(email, passwprd);
	}
	
	public void userAddRequest(RefundRequest refundRequest)
	{
		user.addRequest(refundRequest);
	}
	public void userAddTransaction(Transaction transaction)
	{
		user.addTransaction(transaction);
	}
    
    public void setName (String userName) 
    {
		user.setUserName(userName);
	}
    
    public String getName ()
    {
    	return user.getUserName();
    }
    
    public void setUserPassword (String password) 
    {
		user.setPassword(password);
	}
    
    public String getUserPassword ()
    {
    	return user.getPassword();
    }
    
    public void setUserEmail (String email) 
    {
		user.setEmail(email);
	}
    
    public String getUserEmail ()
    {
    	return user.getEmail();
    }
    
    public Wallet getWallet()
    {
    	return user.wallet;
    }
    
    public CreditCard getCard()
    {
    	return user.card;
    }
    
    public ArrayList<Transaction> getTransactions()
    {
    	return user.transactions;
    }
    
    public ArrayList<RefundRequest> getRefundRequests()
    {
    	return user.refundRequests;
    }
}
