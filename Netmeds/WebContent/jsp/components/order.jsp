<!DOCTYPE html>
<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page import="com.netmeds.dao.CheckOutDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.netmeds.dao.ProductDetails"%>
<html lang="en">

<head>
	<title>Order</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/netmeds.css">
	<script src="<%=request.getContextPath()%>/js/jquery-3.6.4.js"></script>	
</head>
<style>
      
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }
    
    .container {
      max-width: 600px;
      margin: 0 auto;
      background-color: #fff;
      padding: 30px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    
    h1 {
      text-align: center;
      color: #333;
    }
    
    p {
      margin-bottom: 20px;
    }
    
    .order-details {
      margin-top: 30px;
    }
    
    .order-details p {
      font-weight: bold;
      margin-bottom: 10px;
    }
    
    .order-details span {
      color: #888;
    }
    
    .back-btn {
      text-align: center;
      margin-top: 30px;
    }
    
    .back-btn a {
      display: inline-block;
      padding: 10px 20px;
      background-color: #333;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      transition: background-color 0.3s ease;
    }
    
    .back-btn a:hover {
      background-color: #555;
    }
    
    #thank{
        font-size: 20px;
 		font-weight: bolder;
    }
    

</style>
<body>
<div class="wrapper">	
    <!-- --------------------Header Start------------------ -->
    <jsp:include page="header.jsp" />
    <!-- --------------------Header Ends------------------ -->
    
    <% 
    	int cust = ((Integer) session.getAttribute("cust_id")).intValue();
	    ProductDetails orderdetails = new ProductDetails();
	    CheckOutDetails order=new CheckOutDetails();
			    
	    ArrayList deliveryAddress= order.pin(cust);
	    ArrayList cart = orderdetails.cartDetails(cust);
	    
		String totalBill = (String) session.getAttribute("totalPrice");
		String address= (String) deliveryAddress.get(2);
		
		ArrayList orderDetailsList= order.orderDetails(cust , totalBill , address);
    %>
    
     <div class="container">
	    <h1>Order Placed</h1>
		<br>
	    <img src="<%=request.getContextPath()%>/images/congratulation.png" style="margin-left: 244px;">
	    <br>
	    <br>
	    <p id="thank">Thank you for your Order! Your Order has been Successfully Placed.</p>
	    
	    <div class="order-details">
	   	  <p>Order Details: 
	    	<% for(int i=1;i<cart.size(); i+=6) { %>
	    	 <span><%= cart.get(i) %></span><% if (i < cart.size() - 1) { %>,<% } %>
	    	<%}%>
	      </p>
	      <p>Order ID: <span><%= orderDetailsList.get(0) %></span></p>
	      <%
	      String date = (String) orderDetailsList.get(1);
	      String[] dateParts = date.split(" ");

	      String part1 = dateParts[0]; 
	      String part2 = dateParts[1];
	      %>
	      <p>Order Date: <span><%= part1 %></span></p>
	      <p>Shipping Charges: <span> 0.00</span></p>
	      <p>Total Amount: <span><%= orderDetailsList.get(2) %></span></p>
	      <p>Shipping Address: <span><%= orderDetailsList.get(3) %></span></p>
	    </div>
	    
	    <div class="back-btn">
	      <a href="<%=request.getContextPath()%>/jsp/netmeds.jsp">Back to Home</a>
	    </div>
 	 </div>

	<!-- -----------------------Footer Start-------------------- -->
    <jsp:include page="footer.jsp" />
    <!-- -----------------------Footer End--------------------- -->
</div>
	<script src="<%=request.getContextPath()%>/js/netmeds.js"></script>
</body>
</html>