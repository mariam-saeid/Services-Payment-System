package com.example.demo.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OutputHandling.AddingFundsOutputHandling;
import com.example.demo.Payment.AddingFunds;
import com.example.demo.Transaction.AddToWalletTransaction;
import com.example.demo.Transaction.Transaction;

@RestController
public class AddingFundsController 
{
	AddingFunds addingFunds;
	AddingFundsOutputHandling addingFundsOutputHandling;
	InitialData data;
	
	public AddingFundsController() 
	{
		addingFunds = new AddingFunds();
		addingFundsOutputHandling = new AddingFundsOutputHandling();
		data=InitialData.getInstance();
	}
	
	@PostMapping(value = "/addfunds")
	public String handleAddingFunds(@RequestBody String m)
	{		
		if (data.userController.getName().equals(" ") && data.userController.getUserEmail().equals(" ") &&
				data.userController.getUserPassword().equals(" ")) 
		{
			return "SignIn First";
		}
		else 
		{
			double money = Double.parseDouble(m);
			
			// check if there is enough money in credit card
			if (data.userController.getCard().checkMoney(money)==true) 
			{
				addingFunds.addFunds(data.userController.getCard(), data.userController.getWallet(), money);
				// make add to wallet transaction
				Transaction transaction = new AddToWalletTransaction();
				transaction.setMoney(money);
				transaction.setType("Credit Card");
				data.userController.userAddTransaction(transaction);
				
				// print money in wallet and card after adding
				return addingFundsOutputHandling.printMoney(data.userController.getWallet(), data.userController.getCard());
			}
			else 
			{
				return "No Enough Money in Credit Card";
			}
		}
		
	}
}
