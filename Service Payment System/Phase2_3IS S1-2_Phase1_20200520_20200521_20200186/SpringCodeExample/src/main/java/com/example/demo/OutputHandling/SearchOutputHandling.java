package com.example.demo.OutputHandling;

import java.util.ArrayList;
import com.example.demo.Services.Services;

public class SearchOutputHandling 
{	
	public String printSearch(ArrayList<Services> match)
	{
		if (match.size()==0) 
		{
			return "no services match";
		}
		String string="";
		for (int i=0;i<match.size();i++)
		{
			 string+= match.get(i).getServiceName()+"\n";
		}
		return string;
	}
}
