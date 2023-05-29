
package com.netmeds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.netmeds.utilities.dbConnection;

public class AdminDao {
	
	Connection con= dbConnection.openConnection();

	public void addProducts(ArrayList<Object> addproductDetails) 
	{
		
		String addproduct = "INSERT INTO Product(images, product_name, description, manufacturer, price, stock, category_id) values(?,?,?,?,?,?,?)";
		
		try 
		{
			
			 PreparedStatement stmt_Customer = (PreparedStatement) con.prepareStatement(addproduct);
	           
	            stmt_Customer.setString(1,(String) addproductDetails.get(0));
	            stmt_Customer.setString(2,(String) addproductDetails.get(1));
	            stmt_Customer.setString(3, (String)addproductDetails.get(2));
	            stmt_Customer.setString(4, (String)addproductDetails.get(3));
	            stmt_Customer.setString(5, (String) addproductDetails.get(4));
	            stmt_Customer.setString(6, (String) addproductDetails.get(5));
	            stmt_Customer.setInt(7, (Integer) addproductDetails.get(6));

	            stmt_Customer.executeUpdate();
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
	}
}
