package com.example.demo.Controller;
import java.util.ArrayList;
import com.example.demo.Admin.Admin;
import com.example.demo.Payment.RefundRequest;
import com.example.demo.Transaction.Transaction;

public class AdminController 
{
	public Admin admin;
	
	public AdminController(Admin admin)
	{
		this.admin=admin;
	}
	
	public void replyRufundRequest(String s,boolean accept)
	{
		admin.replyRequest(s, accept);
	}
	public void addRufundRequest(RefundRequest refundRequest)
	{
		admin.addRequest(refundRequest);
	}
	public void listUserTransactions(ArrayList<Transaction> transactions)
	{
		admin.listTransactions(transactions);
	}
	public ArrayList<RefundRequest> getRefundRequests()
	{
		return admin.refundRequests;
	}
	public ArrayList<Transaction> getTransactions()
	{
		return admin.transactions;
	}
}
