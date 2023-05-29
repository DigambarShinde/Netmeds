package com.netmeds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.netmeds.utilities.dbConnection;

public class loginDao {
	
	public ArrayList<Object> loginData(String mail,String password)
	{
		ArrayList<Object> list=new ArrayList<Object>();
		
		
		String select="select email , password, role from Customer where email=? and password=?  ";
		Connection con= dbConnection.openConnection();
		try 
		{
			
			PreparedStatement smt=(PreparedStatement) con.prepareStatement(select);
			smt.setString(1, mail);
			smt.setString(2, password);
			
			 ResultSet resultset =smt.executeQuery();
			 
			 if(resultset.next())
			 { 
//				flag=true; 
				 list.add(resultset.getString("email"));
				 list.add(resultset.getString("password"));
				 list.add(resultset.getString("role"));				 
				 return list;
			 }
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
		//return flag;
	}
	
	
	
	public ArrayList<Object> getName(String mail) 
	{		
		ResultSet resultset = null ;	
		ArrayList<Object> list =new ArrayList<Object>();
		Connection con= dbConnection.openConnection();
		try 
		{
			
			PreparedStatement smt=(PreparedStatement) con.prepareStatement("Select customer_id, firstName from Customer where email =?");
	  		smt.setString(1, mail);
	  		resultset =smt.executeQuery();
			 
			 if(resultset.next())
			 {
				 list.add(resultset.getInt("customer_id"));
				 list.add(resultset.getString("firstName"));
			 }
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
}