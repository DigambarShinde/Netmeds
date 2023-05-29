<!DOCTYPE html>
<%@page import="com.netmeds.dao.CheckOutDetails"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.netmeds.dao.ProductDetails"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">

<head>

	<title>Check Out</title>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/netmeds.css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.4.js"></script>
	
<style>
body 
{
    background-color: #f0f0f0;
}

.order-review-heading 
{
    background-color: black;
    color: white;
    padding: 10px;
    text-align: center;
    width: 672px;
    margin-left: 414px;
    border-radius: 5px;
}
.deliver-to 
{
	    font-weight: bold;
	    display: inline-block;
	    margin-left: 416px;
	    color: #888;
	    letter-spacing: 1px;
	    font-family: system-ui;
	    background: white;
	    width: 671px;
	    border-radius: 10px;
	    padding: 12px;
}
    .add-address-button {
      	margin-top: 10px;
	    background-color: #4CAF50;
	    border: none;
	    color: white;
	    padding: 10px 20px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 16px;
	    cursor: pointer;
	    border-radius: 8px;
    }
    .cart-list {
      margin-top: 20px;
    }
    .cart-item {
      margin-bottom: 10px;
      padding: 10px;
      background-color: white;
    }
    .productLebal{
        letter-spacing: 3px;
	    margin-left: 415px;
	    font-size: 23px;
    }

  </style>
	
	
</head>
<body>
<div class="wrapper">
	<!-- --------------------Header Start------------------ -->
    <jsp:include page="header.jsp" />
    <!-- --------------------Header Ends------------------ -->
    <%
	    int cust = ((Integer) session.getAttribute("cust_id")).intValue();
		ProductDetails cartdetails = new ProductDetails();
		CheckOutDetails checkOut=new CheckOutDetails();
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		
		ArrayList cart = cartdetails.cartDetails(cust);
		ArrayList deliveryAddress= checkOut.pin(cust);		
   %>
   <% 	
   		double total; 
        double totalPrice=0;
        int quantity;
       
   %>
    		<div class="order-review-heading">
			  <h2>Order Summary</h2>
			</div>
    		<span class="productLebal">Products </span>
    	 <% for(int i=0; i < cart.size(); i+=6){ %>
            <div class="cart-container">
                <div class="product">
                    <img class="product-image" src="<%= request.getContextPath() %>/images/<%= cart.get(i) %>">
                    <div class="product-details">
                        <h3 class="product-title">Name: <%= cart.get(1+i) %></h3>
                        <p class="product-price">Manufacture: <%= cart.get(2+i) %></p>
                        <p class="product-price">Quantity: <%= cart.get(4+i)%> <%quantity= Integer.parseInt(cart.get(4+i).toString());%></p>
                        <h4 class="product-price">MRP: <%= cart.get(3+i) %></h4>
                        <% if(quantity > 1) { %>
                            <% total= Double.parseDouble(cart.get(3+i).toString()); %>
                            <% total*=quantity; %>
                            <% totalPrice += total; %>
                        <% } else { %>
                            <% total= Double.parseDouble(cart.get(3+i).toString()); %>
                            <% totalPrice += total; %>
                        <% } %>
                    </div>
                </div>
                <!-- Add more product items as needed -->
            </div>
        <%}%>
        
        <div class="total-price">
      		  Total Payable: <span id="totalPrice"><%= decimalFormat.format(totalPrice) %></span>
   		 </div><br>
        
        
		<div class="deliver-to">
			<span>DELIVERY ADDRESS</span><br><br>
			<span>Name: <%= deliveryAddress.get(0) %>&nbsp;<%= deliveryAddress.get(1) %></span><br><br>
			<span >Address: <%= deliveryAddress.get(2)%></span><br>
			<span >State: <%= deliveryAddress.get(3)%></span><br>
			<span >City: <%= deliveryAddress.get(4)%></span><br>
			<span style="display: block;">DeliverTo (pin): <%= deliveryAddress.get(5)%></span><br>
			<span >Phone: +91 &nbsp;<%= deliveryAddress.get(6)%></span><br>
			  
			<button class="add-address-button" onclick="addressPopUp()">+ Add New Address</button>
			
		<%--
			<form id="order" style="display: inline-block"  action="<%=request.getContextPath()%>/loginRegistration">
			    <button class="add-address-button" style="margin-left: 367px">Order Now</button>
			    <input type="hidden" value="order" name="checkForm"></input>
			</form>
		--%>
			<% 
			 String totalPay= decimalFormat.format(totalPrice);
			 request.getSession().setAttribute("totalPrice", totalPay);
			 %>
			<a href="<%= request.getContextPath() %>/jsp/components/order.jsp">
    			<button class="add-address-button" style="margin-left: 367px">Order Now</button>
			</a>
	
		</div>
    
    
      <div class="form-container" id="addressForm" >
        <h2>DELIVERY ADDRESS</h2><br><br>
        <form>
            <div class="form-group">
                <label for="phone">Recipient Phone Number:</label>
                <input type="tel" id="phone" name="phone" maxlength="10" oninput="restrict.restrictAllAcptNumber(this)" required>
            </div>
            <div class="form-group">
                <label for="state">State:</label>
                <input type="text" id="state" name="state" required>
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" id="city" name="city" required>
            </div>
            <div class="form-group">
                <label for="pin">Pin:</label>
                <input type="text" id="pin" name="pin" maxlength="6" required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
        </form>
    </div>
    
   

    <!-- -----------------------Footer Start-------------------- -->
    <jsp:include page="footer.jsp" />
    <!-- -----------------------Footer End--------------------- -->
    
</div>
</body>
	<script src="<%=request.getContextPath()%>/js/netmeds.js"></script>
</html>