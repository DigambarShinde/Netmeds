package com.netmeds.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	
	public static Connection con=null;
	
	public static Connection openConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://192.168.57.5/NT003","digambar.shinde","4(zGgJJA");
	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
			return con;
	}
	
	public static void closeConnection()
	{
		try 
		{
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}