package com.netmeds.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netmeds.dao.ProductDetails;
import com.netmeds.helper.Admin;
import com.netmeds.helper.Images;
import com.netmeds.helper.login;
import com.netmeds.helper.Registration;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String hidden=request.getParameter("checkForm");

		 Images images=new Images();
		 RequestDispatcher rd;
			
		 if (hidden.equals("login"))
		 {
			    ArrayList<Object> list = new ArrayList<Object>();
			    response.setContentType("text/html");
			    String mail = request.getParameter("email");
			    String password = request.getParameter("password");

			    login loginhelper = new login();
			    list = loginhelper.checkLogIn(mail, password);

			    if (!list.isEmpty()) 
			    {
			        if (list.get(2).equals("User"))
			        {
			            ArrayList<Object> login = loginhelper.getName(mail);
			            HttpSession session = request.getSession();
			            session.setAttribute("Name", login.get(1));
			            session.setAttribute("cust_id", login.get(0));
			  
			            response.sendRedirect("jsp/netmeds.jsp");
			        }
			        else if (list.get(2).equals("Admin"))
			        {
			        	ArrayList<Object> login = loginhelper.getName(mail);
			            HttpSession session = request.getSession();
			            session.setAttribute("Name", login.get(1));
			            session.setAttribute("cust_id", login.get(0));
			           
			            response.sendRedirect("jsp/components/adminPannel.jsp");
			        } 
			        else 
			        {
			            response.getWriter().print("<h2>Invalid Credentials!! <br> Please Enter Valid Credentials<h2>");
			        }
			    } 
			    else 
			    {
			        response.getWriter().print("<h2>Invalid Credentials!! <br> Please Enter Valid Credentials<h2>");
			    }
			}
		 else if (hidden.equals("registration"))
		{
			response.setContentType("text/html");
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String mail=request.getParameter("mail");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String state=request.getParameter("state");
			String city=request.getParameter("city"); 
			String role=request.getParameter("role");
			String pin=request.getParameter("pin");
			String password=request.getParameter("password");
				
			ArrayList<Object> registractionlist=new ArrayList<Object>();
			registractionlist.add(firstName);
			registractionlist.add(lastName);
			registractionlist.add(mail);
			registractionlist.add(phone);
			registractionlist.add(password);
			registractionlist.add(address);
			registractionlist.add(state);
			registractionlist.add(city);
			registractionlist.add(role);
			registractionlist.add(pin);
					 
				
			Registration helperreg =new Registration();
			
			if (helperreg.register(registractionlist)) 
			{
				response.sendRedirect("jsp/netmeds.jsp");
			}else {
				response.getWriter().print("<h2>Registration Failed!!<br>Duplicate entry of Mail<h2>");
			}
		}
		 else if (hidden.equals("logout"))
		{
			HttpSession session = request.getSession();	 	
			session.invalidate(); 	
			response.sendRedirect("jsp/netmeds.jsp");
		 }
		 else if (hidden.equals("medicine")) 
		 {
			 ArrayList<Object> list= images.medicine();
			 request.setAttribute("medicine", list);
			 rd=request.getRequestDispatcher("jsp/components/medicine.jsp");
			 rd.forward(request, response);
		 }
		 else if (hidden.equals("wellness")) 
		 {
			 ArrayList<Object> list= images.wellness(); 
			 request.setAttribute("wellness", list);
			 rd=request.getRequestDispatcher("jsp/components/wellness.jsp");
			 rd.forward(request, response);	
		 }
		 else if (hidden.equals("beauty"))
		 {
			 ArrayList<Object> list= images.beauty(); 
			 request.setAttribute("beauty", list);
			 rd=request.getRequestDispatcher("jsp/components/beauty.jsp");
			 rd.forward(request, response);
		 }
		 else if (hidden.equals("healthCare"))
		 {
			 ArrayList<Object> list= images.healthCare(); 
			 request.setAttribute("healthCare", list);
			 rd=request.getRequestDispatcher("jsp/components/healthCare.jsp");
			 rd.forward(request, response);
		 }
		 else if(hidden.equals("addToCart"))
		 {
			
			int cust_id=Integer.parseInt(request.getParameter("customer_id"));
						
				
			response.setContentType("text/html");
			ProductDetails productDetails=new ProductDetails();
			
			productDetails.addToCart(cust_id);
			
			response.sendRedirect("jsp/components/addToCart.jsp");			
		}
		else if (hidden.equals("admin"))
		{
				response.setContentType("text/html");
				String image=request.getParameter("image");
				String productName=request.getParameter("product_name");
				String description=request.getParameter("description");
				String manufacturer=request.getParameter("manufacturer");
				String price=request.getParameter("price");
				String stock=request.getParameter("stock");
				int categories= Integer.parseInt(request.getParameter("categories"));
										
				ArrayList<Object> addproductDetails=new ArrayList<Object>();
				addproductDetails.add(image);
				addproductDetails.add(productName);
				addproductDetails.add(description);
				addproductDetails.add(manufacturer);
				addproductDetails.add(price);
				addproductDetails.add(stock);
				addproductDetails.add(categories);
			
				Admin admin =new Admin();
				
				admin.addProduct(addproductDetails);
				response.getWriter().print("<h2>Product Added to Cart Successfully<h2>");
		}
		else if(hidden.equals("checkOut"))
		{
			 response.setContentType("text/html");
			 rd=request.getRequestDispatcher("jsp/components/checkOut.jsp");
			 rd.forward(request, response);
		}
		else if (hidden.equals("order"))
		{
			 System.out.println("Servlet Getting Called");
			 response.setContentType("text/html");
			 response.sendRedirect("jsp/components/order.jsp");
		} 
	 }
}
