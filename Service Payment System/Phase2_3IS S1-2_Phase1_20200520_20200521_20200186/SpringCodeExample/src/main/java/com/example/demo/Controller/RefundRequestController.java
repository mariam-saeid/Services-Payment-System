package com.example.demo.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OutputHandling.RefundRequestOutputHandling;
import com.example.demo.Payment.RefundRequest;
import com.example.demo.Transaction.PaymentTransaction;

@RestController
public class RefundRequestController 
{
	RefundRequestOutputHandling refundRequestOutputHandling;
	RefundRequest refundRequest;
	InitialData data;
	boolean show = false;
	
	public RefundRequestController() 
	{
		refundRequestOutputHandling = new RefundRequestOutputHandling();
		refundRequest = new RefundRequest();
		data=InitialData.getInstance();
	}
	
	@GetMapping(value = "/showtransactions")
	public String getTransactions()
	{
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		
		int counter = 0;
		//check num of payment transaction
		for (int i=0;i<data.userController.getTransactions().size();i++)
		{
			if (data.userController.getTransactions().get(i) instanceof PaymentTransaction) 
			{
				counter++;
			}	
		}
		// if there are any payment transactions to refund
		if (counter>0) 
		{
			String string = refundRequestOutputHandling.printTransactions(data.userController.getTransactions());
			show = true;
			return string;
		}
		// no payment transactions to refund
		else 
		{
			return "No Payment Transactions to Refund";
		}
		
	}
	
	@PostMapping(value = "/askforrefund")
	public String handleRefund(@RequestBody String n)
	{
		int tranNum = Integer.parseInt(n);
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		
		if (show==false)
		{
			return "show transactions first using url (get --> /showtransactions)";
		}
		
		if (tranNum>data.userController.getTransactions().size())
		{
			return "Invaild num";
		}
		
		if (data.userController.getTransactions().get(tranNum-1) instanceof PaymentTransaction) 
		{
			// set selected transaction info to refund request info
			refundRequest.service = data.userController.getTransactions().get(tranNum-1).getService();
			refundRequest.amount = data.userController.getTransactions().get(tranNum-1).getMenoy();
			refundRequest.unique = String.valueOf(data.userController.getRefundRequests().size()) + data.userController.getName();
			refundRequest.user = data.userController.user;
			
			// add request to user list
			data.userController.userAddRequest(refundRequest);
			// add request to admin list
			data.adminController.addRufundRequest(refundRequest);
			
			return "Successful Refund Request";
		}
		else 
		{
			return "Invaild paymant transaction num";
		}
		
		
	}
}
