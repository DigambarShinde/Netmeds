package com.netmeds.helper;

import java.util.ArrayList;
import com.netmeds.dao.GetImages;


public class Images {
	
	GetImages getImagesObj=new GetImages();

	public ArrayList<Object> medicine() 
	{
		 ArrayList<Object> list=(ArrayList<Object>) getImagesObj.medicine();
		 return list;
	}
	
	public ArrayList<Object> wellness()
	{
		 ArrayList<Object> list=(ArrayList<Object>) getImagesObj.wellness();
		 return list;
	}
	
	public ArrayList<Object> beauty()
	{
		 ArrayList<Object> list=(ArrayList<Object>) getImagesObj.beauty();
		 return list;
	}
	
	public ArrayList<Object> healthCare()
	{
		 ArrayList<Object> list=(ArrayList<Object>) getImagesObj.healthCare();
		 return list;
	}
	
	public static ArrayList<Object> getHomeProducts()
	{
		 ArrayList<Object> listofAllProducts=(ArrayList<Object>) GetImages.getHomeProducts();
		 return listofAllProducts;
	}
}
