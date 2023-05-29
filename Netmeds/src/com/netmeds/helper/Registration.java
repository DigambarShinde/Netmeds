package com.netmeds.helper;

import java.util.ArrayList;
import com.netmeds.dao.RegistrationDao;


public class Registration {
	
		public boolean register(ArrayList<Object> registractionlist)
		{
			RegistrationDao registrationDao=new RegistrationDao();
			boolean check = registrationDao.registractionData(registractionlist);
			if (check == true) 
			{
				return true;
			}
			return false;
		}
	
}
