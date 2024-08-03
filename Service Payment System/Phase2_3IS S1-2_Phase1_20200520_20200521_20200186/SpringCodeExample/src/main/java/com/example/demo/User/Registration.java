package com.example.demo.User;

import java.util.ArrayList;

// Registration to check user signIn and signUp 
public class Registration 
{
	// list of all user in system
	public ArrayList <User> registerUsers;
	public User selectedUser;
	
	public Registration ()
	{
		registerUsers = new ArrayList<User>();
	}
	
	// check if user registered before return false and don't add this user 
	public boolean checkSignUp (String u,String p,String e)
	{
		for (int i=0;i<registerUsers.size();i++)
		{
			if (registerUsers.get(i).userName.equals(u)) 
			{
				return false;
			}
			if (registerUsers.get(i).email.equals(e)) 
			{
				return false;
			}
		}
		
		addRegisterUser(u,p,e);
		
		return true;
	};
	
	public void addRegisterUser (String u,String p,String e)
	{
		User user = new User(this);
		user.setUserName(u);
		user.setEmail(e);
		user.setPassword(p);
		
		registerUsers.add(user);
	}
	
	// check if user exist in system or not
	public boolean checkSignIn (String e,String p)
	{
		for (int i=0;i<registerUsers.size();i++)
		{
			// if email exist
			if (registerUsers.get(i).email.equals(e))
			{
				// check if password entered match password to this email
				if (registerUsers.get(i).password.equals(p)) 
				{
					selectedUser = registerUsers.get(i);
					return true;
				}
				else 
				{
					break;
				}
			}
		}
		
		return false;
	}
	
	public ArrayList<User> getRegisterUsers ()
	{
		return registerUsers;
	}

}
