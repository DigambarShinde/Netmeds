package com.netmeds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.netmeds.utilities.dbConnection;
import com.sun.org.apache.bcel.internal.generic.Select;

public class ProductDetails {
	
	static int primaryKey;
	String queryString;
	static String price;
	
	public  ArrayList<Object> getProductDetailsById(int id) 
	{
		String selectproduct="select product_id,images,product_name,description,manufacturer,price,stock from Product where product_id= ?";
		ArrayList<Object> list=new ArrayList<Object>();
		ResultSet resultset=null;
		primaryKey=id;
		Connection con= dbConnection.openConnection();
		try 
		{
			
			
	  		PreparedStatement ps=(PreparedStatement) con.prepareStatement(selectproduct);
	  		ps.setInt(1, id);
			resultset =ps.executeQuery();
			
			while (resultset.next()) 
			{
				list.add(resultset.getString("images"));
				list.add(resultset.getString("product_name"));
				list.add(resultset.getString("description"));
				list.add(resultset.getString("manufacturer"));
				list.add(resultset.getString("price"));
				list.add(resultset.getString("stock"));
		    }
			String priceofProduct = (String) list.get(4);
			price=priceofProduct;
			
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
	
	
	public void addToCart(int cust_id)
	{
	    String query = "SELECT specific_item_quantity, product_id FROM Add_to_Cart WHERE product_id=? AND customer_id=?";
	    ResultSet resultSet = null;
	    Connection con = dbConnection.openConnection();
	    try 
	    {
	        
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
	        ps.setInt(1, primaryKey);
	        ps.setInt(2, cust_id);

	        resultSet = ps.executeQuery();

	        if (resultSet.next())
	        {
	            int stock = resultSet.getInt("specific_item_quantity");
	            int specific_item_quantity = stock + 1;

	            // If the entry already exists, update the specific_item_quantity
	            String updateSql = "UPDATE Add_to_Cart SET specific_item_quantity = ?, is_active = ?   WHERE product_id = ? AND customer_id = ?";
	            PreparedStatement updateStatement = (PreparedStatement) con.prepareStatement(updateSql);
	            updateStatement.setInt(1, specific_item_quantity);
	            updateStatement.setString(2, "Y");
	            updateStatement.setInt(3, primaryKey);
	            updateStatement.setInt(4, cust_id);
	            updateStatement.executeUpdate();
	        }
	        else 
	        {
	            // If the entry does not exist, add a new entry
	            String insertSql = "INSERT INTO Add_to_Cart (specific_item_quantity, product_id, customer_id, specific_item_price, is_active) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement insertStatement = (PreparedStatement) con.prepareStatement(insertSql);
	            insertStatement.setInt(1, 1);
	            insertStatement.setInt(2, primaryKey);
	            insertStatement.setInt(3, cust_id);
	            insertStatement.setString(4, price);
	            insertStatement.setString(5, "Y");
	            insertStatement.executeUpdate();
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
	}
	
	public ArrayList<Object> cartDetails(int cust_id) {
	    ArrayList<Object> cartList = new ArrayList<Object>();

	    String query = "select p.images, p.product_name, p.manufacturer, p.price, a.specific_item_quantity, p.product_id "
	            + "from Product p INNER JOIN Add_to_Cart a "
	            + "ON p.product_id = a.product_id "
	            + "WHERE a.customer_id = "+cust_id+" and a.is_active ='Y'";

	    Connection con = dbConnection.openConnection();
	    try {
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
	        ResultSet resultSet = ps.executeQuery();

	        while (resultSet.next()) {
	            cartList.add(resultSet.getString("images"));
	            cartList.add(resultSet.getString("product_name"));
	            cartList.add(resultSet.getString("manufacturer"));
	            cartList.add(resultSet.getString("price"));
	            cartList.add(resultSet.getString("specific_item_quantity"));
	            cartList.add(resultSet.getString("product_id"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return cartList;
	}
	
	public void deleteFromCart(int product_id,int customer_id) 
	{
		String query="UPDATE Add_to_Cart SET is_active = 'N', specific_item_quantity = 0 WHERE  customer_id = "+customer_id+" and product_id = "+product_id;
		
		Connection con = dbConnection.openConnection();
		try 
		{
			Statement statement= (Statement) con.createStatement();
	        boolean resultSet= statement.execute(query);
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