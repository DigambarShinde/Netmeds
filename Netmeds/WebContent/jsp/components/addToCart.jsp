<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.netmeds.dao.ProductDetails"%>
<html lang="en">

<head>
<title>Add to Cart</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/netmeds.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.4.js"></script>
</head>

<body>

<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"> 

<div class="wrapper">	
    <!-- --------------------Header Start------------------ -->
    <jsp:include page="header.jsp" />
    <!-- --------------------Header Ends------------------ -->

    <% 
    	int cust = ((Integer) session.getAttribute("cust_id")).intValue();
        ProductDetails cartdetails = new ProductDetails();
        ArrayList cart = cartdetails.cartDetails(cust);
       
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    %>

    <% double total; 
        double totalPrice=0;
        int quantity;
     %>
	
	<div class="order-review-heading">
		<h2>Your Cart</h2>
	</div>
	
	<span class="productLebal">Products </span>
    <% if(cart.size() > 0){ %>
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
                    <button onclick="deleteFromCart(<%=cart.get(5+i)%>,<%=cust%>)" class="delete-button">Delete</button>
                </div>
                <!-- Add more product items as needed -->
            </div>
        <%}%>
         <div class="total-price">
      		  Total Payable: <span id="totalPrice"><%= decimalFormat.format(totalPrice) %></span>
   		 </div>
         <form id="checkOut" style="display: inline-block" action="<%=request.getContextPath()%>/loginRegistration">
		        <button id="proceed" class="buy-now-button">PROCEED</button>
		        <input type="hidden" value="checkOut" name="checkForm"></input>
   		 </form>
    <% } else {%>
	    <div class="total-price">
	        Total Payable: <span id="totalPrice"><%= decimalFormat.format(totalPrice) %></span>
	    </div>
        <form id="checkOut" style="display: inline-block" action="<%=request.getContextPath()%>/loginRegistration">
       		 <button id="proceed" class="buy-now-button" style=" opacity: 0.5">PROCEED</button>
        	 <input type="hidden" value="checkOut" name="checkForm"></input>
   		 </form>
        <script type="text/javascript">
            document.getElementById("proceed").disabled = true;
        </script>
    <% }%>
    <a href="<%= request.getContextPath() %>/jsp/netmeds.jsp">
        <button class="buy-now-button">Add More Items</button>
    </a>

    <!-- -----------------------Footer Start-------------------- -->
    <jsp:include page="footer.jsp" />
    <!-- -----------------------Footer End--------------------- -->
</div>

<script src="<%=request.getContextPath()%>/js/netmeds.js"></script>
</body>

</html>
