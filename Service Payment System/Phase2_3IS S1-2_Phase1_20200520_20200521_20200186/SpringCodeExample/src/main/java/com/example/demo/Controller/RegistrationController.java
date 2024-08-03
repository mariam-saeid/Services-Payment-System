package com.example.demo.Controller;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.User.User;

@RestController
public class RegistrationController 
{
	 InitialData data;
	 UserController userController;
	 User user;
	 
	 public RegistrationController()
	 {
		 data = InitialData.getInstance();
		 user = new User(data.registration);
		 userController = new UserController(user);
	 }
	
	@PostMapping(value = "/signup")
	public String handleSignup(@RequestBody Map<String, String> map)
	{
		boolean result = false;
		
		String userName = map.get("userName");
		String email = map.get("email");
		String password = map.get("password");
		
		result = userController.userSignup(userName,password,email);
		
		if (result) {
			return "Successful SignUp";
		}
		else {
			return "UnSuccessful SignUp";
		}
	}
	
	@PostMapping(value = "/signin")
	public String handleSignin(@RequestBody Map<String, String> map)
	{
		
		String email = map.get("email");
		String password = map.get("password");
		
		boolean result = false;
		result = userController.userSignIn(email,password);
		
		if (result) 
		{
			data.userController.user = data.registration.selectedUser;
			data.userController.getWallet().money=100;
			data.userController.getCard().creditCardMoney=5000;
			return "Successful SignIn";
		}
		else 
		{
			return "UnSuccessful SignIn";
		}
	}
	
}
