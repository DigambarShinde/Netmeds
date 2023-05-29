package com.netmeds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.netmeds.utilities.dbConnection;

public class GetImages {

	public  ArrayList<Object> medicine() 
	{
		
		ArrayList<Object> list=new ArrayList<Object>();
		ResultSet resultset=null;
		String selectImg="select product_id, images, product_name, manufacturer, price from Product where category_id = 1";
		Connection con= dbConnection.openConnection();
		
		try 
		{
			
	  		Statement smt=(Statement) con.createStatement();
			resultset =smt.executeQuery(selectImg);
			
			while (resultset.next()) 
			{
				list.add(resultset.getString("product_id"));
				list.add(resultset.getString("images"));
				list.add(resultset.getString("product_name"));
				list.add(resultset.getString("manufacturer"));
				list.add(resultset.getString("price"));
			}
			return list;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public  ArrayList<Object> wellness() 
	{
		
		ArrayList<Object> list=new ArrayList<Object>();
		ResultSet resultset=null;
		String selectImg="select product_id, images, product_name, manufacturer, price from Product where category_id = 2";
		Connection con= dbConnection.openConnection();
		try 
		{
			
	  		Statement smt=(Statement) con.createStatement();
			resultset =smt.executeQuery(selectImg);
			
			while (resultset.next()) 
			{
				list.add(resultset.getString("product_id"));
				list.add(resultset.getString("images"));
				list.add(resultset.getString("product_name"));
				list.add(resultset.getString("manufacturer"));
				list.add(resultset.getString("price"));
			}
			return list;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		return list;
	}
	
	public  ArrayList<Object> beauty() 
	{
		
		ArrayList<Object> list=new ArrayList<Object>();
		ResultSet resultset=null;
		String selectImg="select product_id, images, product_name, manufacturer, price from Product where category_id = 3";
		Connection con= dbConnection.openConnection();
		try 
		{
			
	  		Statement smt=(Statement) con.createStatement();
			resultset =smt.executeQuery(selectImg);
			
			while (resultset.next()) 
			{
				list.add(resultset.getString("product_id"));
				list.add(resultset.getString("images"));
				list.add(resultset.getString("product_name"));
				list.add(resultset.getString("manufacturer"));
				list.add(resultset.getString("price"));
			}
			return list;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public  ArrayList<Object> healthCare() 
	{
		
		ArrayList<Object> list=new ArrayList<Object>();
		ResultSet resultset=null;
		String selectImg="select product_id, images,product_name,manufacturer,price from Product where category_id = 4";
		Connection con= dbConnection.openConnection();
		try 
		{
			
	  		Statement smt=(Statement) con.createStatement();
			resultset =smt.executeQuery(selectImg);
			
			while (resultset.next()) 
			{
				list.add(resultset.getString("product_id"));
				list.add(resultset.getString("images"));
				list.add(resultset.getString("product_name"));
				list.add(resultset.getString("manufacturer"));
				list.add(resultset.getString("price"));
			}
			return list;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public static  ArrayList<Object> getHomeProducts() 
	{
		ArrayList<Object> listofAllProducts=new ArrayList<Object>();
		ResultSet resultset=null;
		String selectImg="select product_id, images,product_name,manufacturer,price from Product";
		Connection con= dbConnection.openConnection();
		try 
		{
			
	  		Statement smt=(Statement) con.createStatement();
			resultset =smt.executeQuery(selectImg);
			
			while (resultset.next()) 
			{
				listofAllProducts.add(resultset.getString("product_id"));
				listofAllProducts.add(resultset.getString("images"));
				listofAllProducts.add(resultset.getString("product_name"));
				listofAllProducts.add(resultset.getString("manufacturer"));
				listofAllProducts.add(resultset.getString("price"));
			}
			return listofAllProducts;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listofAllProducts;
	}
}
