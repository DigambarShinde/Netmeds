package com.netmeds.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.netmeds.utilities.dbConnection;

public class GetAddress {
	
	
	 public ArrayList<Object> getStates()
	   {
		   ArrayList<Object> listOfState=new ArrayList<Object>();

		   String select="SELECT DISTINCT stateName FROM States";
	   
	    Connection con= dbConnection.openConnection();
		try 
		{	
			Statement smt=(Statement) con.createStatement();
			ResultSet resultset =smt.executeQuery(select);
			
			while (resultset.next()) 
			{
				listOfState.add(resultset.getString("stateName"));
			}
			return listOfState;
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
				e.printStackTrace();
			}
		}
			return listOfState;
	}
	
   public ArrayList<Object> getCities(String state)
   {
	   ArrayList<Object> listOfCitiesArrayList=new ArrayList<Object>();

	   String select="SELECT States.stateName, Cities.cityName FROM States"
				+ " INNER JOIN Cities ON States.state_id = Cities.state_id "
				+ "WHERE States.stateName = ? ";
   
    Connection con= dbConnection.openConnection();
	try 
	{	
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(select);
  		ps.setString(1, state);
		ResultSet resultSet =ps.executeQuery();
		
		while (resultSet.next()) 
		{
			listOfCitiesArrayList.add(resultSet.getString("cityName"));
		}
		return listOfCitiesArrayList;
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
			e.printStackTrace();
		}
	}
		return listOfCitiesArrayList;
	}
}
