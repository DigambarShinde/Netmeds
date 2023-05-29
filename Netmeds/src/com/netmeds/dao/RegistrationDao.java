package com.netmeds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.netmeds.utilities.dbConnection;

public class RegistrationDao {
	
	public boolean registractionData(ArrayList<Object> registractionlist)
	{
		Connection con= dbConnection.openConnection();
		 ResultSet generatedKeys = null;
		 
		try 
		{
		//Insert data into Customer table   
			String insertCustomerQuery = "INSERT INTO Customer (firstName, lastName, email, number, password, created_by, is_active, role) VALUES (?, ?, ?, ?, ? ,?, ?, ?)";
            PreparedStatement stmt_Customer = (PreparedStatement) con.prepareStatement(insertCustomerQuery,Statement.RETURN_GENERATED_KEYS);
            
            String created_by=(String) registractionlist.get(0);
           
            stmt_Customer.setString(1,(String) registractionlist.get(0));
            stmt_Customer.setString(2,(String) registractionlist.get(1));
            stmt_Customer.setString(3, (String)registractionlist.get(2));
            stmt_Customer.setString(4, (String)registractionlist.get(3));
            stmt_Customer.setString(5, (String) registractionlist.get(4));
            stmt_Customer.setString(8, (String) registractionlist.get(8));
            stmt_Customer.setString(6, (String) registractionlist.get(8));
            stmt_Customer.setString(7, "Y");
            
            stmt_Customer.executeUpdate();
            
            generatedKeys = stmt_Customer.getGeneratedKeys();
            int customer_id = -1;
            if (generatedKeys.next()) {
            	customer_id = generatedKeys.getInt(1);
            }
                
         //Insert data into Address table    
            String insertAddressQuery = "INSERT INTO Address (customer_id ,address, created_by, is_active) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt_Address = (PreparedStatement) con.prepareStatement(insertAddressQuery,Statement.RETURN_GENERATED_KEYS);

            stmt_Address.setInt(1, customer_id);
            stmt_Address.setString(2, (String) registractionlist.get(5));
            stmt_Address.setString(3, (String) registractionlist.get(8));
            stmt_Address.setString(4, "Y");
            stmt_Address.executeUpdate();
            
            generatedKeys = stmt_Address.getGeneratedKeys();
            int address_id = -1;
            if (generatedKeys.next()) {
            	address_id = generatedKeys.getInt(1);
            }
            
            //Insert data into States table
            String insertStateQuery = "INSERT INTO States (address_id, stateName, created_by, is_active) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt_States = (PreparedStatement) con.prepareStatement(insertStateQuery,Statement.RETURN_GENERATED_KEYS);
            
            stmt_States.setInt(1, address_id);
            stmt_States.setString(2, (String) registractionlist.get(6));
            stmt_States.setString(3, (String) registractionlist.get(8));
            stmt_States.setString(4, "Y");
            stmt_States.executeUpdate();
            
            generatedKeys = stmt_States.getGeneratedKeys();
            int state_id = -1;
            if (generatedKeys.next()) {
            	state_id = generatedKeys.getInt(1);
            }
            
            //Insert data into Cities table
            String insertCityQuery = "INSERT INTO Cities (address_id, state_id, cityName, pin, created_by, is_active) VALUES (?, ?, ?, ?, ?, ?)";
           
            PreparedStatement stmt_Cities = (PreparedStatement) con.prepareStatement(insertCityQuery);
            
            stmt_Cities.setInt(1, address_id);
            stmt_Cities.setInt(2, state_id);
            stmt_Cities.setString(3, (String) registractionlist.get(7));
            stmt_Cities.setString(4, (String) registractionlist.get(9));
            stmt_Cities.setString(5, (String) registractionlist.get(8));
            stmt_Cities.setString(6, "Y");
            stmt_Cities.executeUpdate();

            return true;
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
		return false;
	}
}