package com.netmeds.helper;

import java.util.ArrayList;

import com.netmeds.dao.loginDao;


public class login {
	
	loginDao loginDao=new loginDao();
	
//	public boolean checkLogIn(String mail,String password)
//	{
//			if (loginDao.loginData(mail, password)) 
//			{
//				return true;
//			}
//		return false;
//	}
	
	public ArrayList<Object> checkLogIn(String mail,String password)
	{
		loginDao loginDao=new loginDao();
		  return loginDao.loginData(mail, password);

	}
	
	public ArrayList<Object> getName(String mail)
	{
		return loginDao.getName(mail);
	}
	
	
	
}