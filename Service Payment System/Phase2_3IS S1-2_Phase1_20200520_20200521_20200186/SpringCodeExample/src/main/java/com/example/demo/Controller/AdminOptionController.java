package com.example.demo.Controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OutputHandling.AdminOptionOutputHandling;
import com.example.demo.User.User;

@RestController
public class AdminOptionController 
{
	public AdminOptionOutputHandling adminOptionView;
	public InitialData data;
	boolean show = false;
	
	public AdminOptionController() 
	{
		adminOptionView = new AdminOptionOutputHandling();
		data=InitialData.getInstance();
	}
	
	@GetMapping(value = "/user/check")
	public String checkUser(@RequestBody Map<String, String> map)
	{
		String email = map.get("email");
		String password = map.get("password");
		User checkUser = new User(data.registration);
		
		for (int i=0; i<data.registration.registerUsers.size();i++)
		{
			if (data.registration.registerUsers.get(i).email.equals(email) &&
					data.registration.registerUsers.get(i).password.equals(password)) 
			{
				checkUser = data.registration.registerUsers.get(i);
				break;
			}
		}
		
		if (checkUser.userName.equals(" ") && checkUser.email.equals(" ") && checkUser.password.equals(" ")) 
		{
			return "User Not Found";
		}
		
		return adminOptionView.printUserInfo(checkUser);
	}
	
	@GetMapping(value = "/admin/listusertransactions")
	public String handleTransactionsList()
	{
		if (data.userController.getName().equals("non") && data.userController.getUserEmail().equals("non") &&
				data.userController.getUserPassword().equals("non")) 
		{
			return "no user in system";
		}
		
		if (data.userController.getTransactions().size()==0)
		{
			return "no user transaction";
		}
		
		return adminOptionView.printTransactions(data.userController.getTransactions());
	}
	
	@GetMapping(value = "/admin/listrufundrequsets")
	public String getRefundRequestsList()
	{		
		// if there are refund requests in list
		if (data.adminController.getRefundRequests().size()!=0) 
		{
			show = true;
			return adminOptionView.printRefundRequest(data.adminController.getRefundRequests());
		}
		// if no refund request in list
		else 
		{
			return "No Refund Requests";
		}
	}
	
	@PostMapping(value = "/admin/chooserufundrequset")
	public String handleRefundRequestsList(@RequestBody Map<String, String> map) 
	{
		String name = map.get("name");
		String flag = map.get("flag");
		if (show==false)
		{
			return "show refund requests first using url (get --> /admin/listrufundrequsets)";
		}
		
		boolean found = false;
		for (int i=0;i<data.adminController.getRefundRequests().size();i++)
		{
			if (data.adminController.getRefundRequests().get(i).unique.equals(name)) 
			{
				found = true;
				break;
			}
		}
		
		if (found==false) 
		{
			return "wrong name";
		}
		if (flag.equals("y")) 
		{
			data.adminController.replyRufundRequest(name, true);
			return "Acceptsed Successfully";
		}
		if (flag.equals("n"))
		{
			data.adminController.replyRufundRequest(name, false);
			return "Rejected Successfully";
		}
		else 
		{
			return "wrong flag";
		}
	}
}
