package com.netmeds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.omg.Messaging.ORDER_ANY;

import com.mysql.jdbc.PreparedStatement;
import com.netmeds.utilities.dbConnection;

public class CheckOutDetails {
	
	ResultSet resultSet;
	
	public ArrayList<Object> pin(int customer)
	{
		ArrayList<Object> deleveraddress= new ArrayList<Object>();

		String query = "SELECT firstName, lastName, address, stateName, cityName, pin, number " +
	               "FROM Cities " +
	               "INNER JOIN States ON Cities.state_id = States.state_id " +
	               "INNER JOIN Address ON States.address_id = Address.address_id " +
	               "INNER JOIN Customer ON Address.customer_id = Customer.customer_id " +
	               "WHERE Customer.customer_id = ?";

		
		Connection con = dbConnection.openConnection();
		try 
		{
	  		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
	  		ps.setInt(1, customer);
			resultSet =ps.executeQuery();
			while (resultSet.next()) {
				deleveraddress.add(resultSet.getString("firstName"));
				deleveraddress.add(resultSet.getString("lastName"));
				deleveraddress.add(resultSet.getString("address"));
				deleveraddress.add(resultSet.getString("stateName"));
				deleveraddress.add(resultSet.getString("cityName"));
				deleveraddress.add(resultSet.getString("pin"));
				deleveraddress.add(resultSet.getString("number"));
				return deleveraddress;
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
		return deleveraddress;
	}
	
	public ArrayList<Object> orderDetails(int cust_id, String totalBill, String shippingAddress) {
	    ArrayList<Object> orderdetails = new ArrayList<Object>();

	    String insert = "INSERT INTO Orders(customer_id, totalBill, shipping_address, created_by) VALUES(?,?,?,?)";
	    Connection con = dbConnection.openConnection();
	    try {
	        PreparedStatement order = (PreparedStatement) con.prepareStatement(insert);
	        order.setInt(1, cust_id);
	        order.setString(2, totalBill);
	        order.setString(3, shippingAddress);
	        order.setString(4, "User");
	        order.executeUpdate();

	        String select = "SELECT order_id, order_date, totalBill, shipping_address FROM Orders WHERE customer_id = ? ORDER BY order_id DESC LIMIT 1";

	        PreparedStatement orderdetails_stmt = (PreparedStatement) con.prepareStatement(select);
	        orderdetails_stmt.setInt(1, cust_id);
	        resultSet = orderdetails_stmt.executeQuery();
	        if (resultSet.next()) {
	            orderdetails.add(resultSet.getInt("order_id"));
	            orderdetails.add(resultSet.getString("order_date"));
	            orderdetails.add(resultSet.getString("totalBill"));
	            orderdetails.add(resultSet.getString("shipping_address"));
	            return orderdetails;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    return orderdetails;
	}
}
