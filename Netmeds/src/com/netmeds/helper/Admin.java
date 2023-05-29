package com.netmeds.helper;

import java.util.ArrayList;

import com.netmeds.dao.AdminDao;

public class Admin {

	public void addProduct(ArrayList<Object> addproductDetails) 
	{	
		AdminDao adminDao=new AdminDao();
		adminDao.addProducts(addproductDetails);
	}
}
