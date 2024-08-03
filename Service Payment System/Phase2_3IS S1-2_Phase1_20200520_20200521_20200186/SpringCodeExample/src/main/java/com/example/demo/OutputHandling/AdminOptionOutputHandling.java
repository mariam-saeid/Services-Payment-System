package com.example.demo.OutputHandling;
import java.util.ArrayList;
import com.example.demo.Payment.RefundRequest;
import com.example.demo.Transaction.AddToWalletTransaction;
import com.example.demo.Transaction.PaymentTransaction;
import com.example.demo.Transaction.RefundTransaction;
import com.example.demo.Transaction.Transaction;
import com.example.demo.User.User;

public class AdminOptionOutputHandling 
{	
	public String printUserInfo(User checkUser) 
	{
		String string = "User Info:\n";
		string += "UserName: "+checkUser.userName+"\n";
		string += "Email: "+checkUser.email+"\n";
		string += "Password: "+checkUser.password+"\n";
		string += "Money in wallet: "+Double.toString(checkUser.wallet.money)+"\n";
		string += "Money in credit card: "+Double.toString(checkUser.card.creditCardMoney)+"\n";
		string += "Num of Transtions: "+Integer.toString(checkUser.transactions.size())+"\n";
		for (int i=0;i<checkUser.transactions.size();i++)
		{
			if (checkUser.transactions.get(i) instanceof PaymentTransaction)
			{
				string += Integer.toString(i+1)+") Paymant Transaction\n";
				string += "Service = "+checkUser.transactions.get(i).getService().getServiceName()+"\n";
				string += "Money = "+ Double.toString(checkUser.transactions.get(i).getMenoy()) + "\n";
				string += "Paid via = "+ checkUser.transactions.get(i).getType() + "\n";
			}
			else if (checkUser.transactions.get(i) instanceof RefundTransaction)
			{
				string += Integer.toString(i+1)+") Refund Transaction\n";
				string += "Service = "+checkUser.transactions.get(i).getService().getServiceName()+"\n";
				string += "Money = "+ Double.toString(checkUser.transactions.get(i).getMenoy()) + "\n";
				string += "Paid via = "+ checkUser.transactions.get(i).getType() + "\n";
			}
			else if (checkUser.transactions.get(i) instanceof AddToWalletTransaction)
			{
				string += Integer.toString(i+1)+") Add To Wallet Transaction\n";
				string += "Money = "+ Double.toString(checkUser.transactions.get(i).getMenoy()) + "\n";
				string += "Paid via = "+ checkUser.transactions.get(i).getType() + "\n";
			}
		}
		
		return string;
	}
	
	public String printRefundRequest(ArrayList<RefundRequest> refundRequests)
	{
		String string = "";

		for (int i=0;i<refundRequests.size();i++)
		{
			string+="Uique name: " + refundRequests.get(i).unique + "\n"; 
		    string+="Service: " + refundRequests.get(i).service.getServiceName()+"\n";
		    string+="Amount: " + Double.toString(refundRequests.get(i).amount)+"\n";
		}
		
		string+="\n go to url (post --> /admin/listrufundrequsets "
				+ "and enter refund requset uique name as name for map key and "
				+ "y for accept or n for reject as flag for map key";

		return string;
	}	
	
	public String printTransactions(ArrayList<Transaction> transactions)
	{
		String string = "";
		for (int i=0;i<transactions.size();i++)
		{
			if (transactions.get(i) instanceof PaymentTransaction)
			{
				string += Integer.toString(i+1)+") Paymant Transaction\n";
				string += "Service = "+transactions.get(i).getService().getServiceName()+"\n";
				string += "Money = "+ Double.toString(transactions.get(i).getMenoy()) + "\n";
				string += "Paid via = "+ transactions.get(i).getType() + "\n";
			}
			else if (transactions.get(i) instanceof RefundTransaction)
			{
				string += Integer.toString(i+1)+") Refund Transaction\n";
				string += "Service = "+transactions.get(i).getService().getServiceName()+"\n";
				string += "Money = "+ Double.toString(transactions.get(i).getMenoy()) + "\n";
				string += "Paid via = "+ transactions.get(i).getType() + "\n";
			}
			else if (transactions.get(i) instanceof AddToWalletTransaction)
			{
				string += Integer.toString(i+1)+") Add To Wallet Transaction\n";
				string += "Money = "+ Double.toString(transactions.get(i).getMenoy()) + "\n";
				string += "Paid via = "+ transactions.get(i).getType() + "\n";
			}
			
			string +="\n";
		}
		
		return string;
	}
	
}
