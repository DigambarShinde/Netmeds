<%@page import="java.util.ArrayList"%>
<%@page import="com.netmeds.dao.ProductDetails"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Product Details</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/netmeds.css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.4.js"></script>
</head>
<body>


	 <%      // this is comming from home URL , getting the paramiter
              String productId = request.getParameter("Product_Id");
              String product_ID= productId.trim();
              
              Integer cust=(Integer)session.getAttribute("cust_id");
             
             // getting session for without login user can,t add product to card
              String userName=(String) session.getAttribute("Name");
              userName=userName==null ? "Hi Guest" : userName;
     %>


	<div class="wrapper">
		<!-- --------------------Header Start------------------ -->
		<jsp:include page="header.jsp" />
		<!-- --------------------Header Start------------------ -->

		<%
			int id = Integer.parseInt(request.getParameter("Product_Id"));
			ProductDetails productDetails = new ProductDetails();
			ArrayList product = productDetails.getProductDetailsById(id);
			
		%>

		<% for (int i = 0; i < product.size(); i += 6) { %>
			<div class="box_content">
				<img src="<%= request.getContextPath()%>/images/<%= product.get(0) %>" style="width: 250px; height: 250px; margin: 0 auto;">
			</div>
			<div id="product_info" >
				<p>Product Name: <%= product.get(1) %></p><br>
				<span>Description: <%= product.get(2) %></span><br>
				<span>Manufacturer: <%= product.get(3) %></span><br>
				<span>Price: <%= product.get(4) %></span><br>
				
			</div><br>
			<form id="add_to_cart" action="<%=request.getContextPath()%>/jsp/productInfo.jsp">
				<button class="Proceed-to-Cart" type="button" onclick="addToCart()">Procced To Add To Cart</button>
			</form>
		<% } %>
		

	<div id="popupOverlayProduct" class="overlayProduct">
        <div id="popupProduct" class="popupProduct">
            <span class="closebutton" onclick="closePopupProduct()">&times;</span>
           <h1>Add To Cart Page</h1>

          <% for (int i = 0; i < product.size(); i += 6) { %>
			<div class="box_content">
				<img src="<%= request.getContextPath()%>/images/<%= product.get(0) %>" style="width: 250px; height: 250px; margin: 0 auto;">
			</div>
			<div id="product_info" >
				<p>Product Name: <%= product.get(1) %></p><br>
				<span>Description: <%= product.get(2) %></span><br>
				<span>Manufacturer: <%= product.get(3) %></span><br>
				<span>Price: <%= product.get(4) %></span><br>
				
			</div><br>
			<form id="orderplace" action="<%=request.getContextPath()%>/loginRegistration" >
				<input type="hidden" name="checkForm" value="addToCart">
				<input type="hidden" name="customer_id" value="<%=cust%>">
				<button class="Proceed-to-Cart" type="submit">Add To Cart</button>
			</form>		
		<% } %>
		
           
        </div>
    </div>
 
         <!-------------------------------- Product POP Up End---------------------------------- -->

		<!-- -----------------------Footer Start-------------------- -->
		<jsp:include page="footer.jsp" />
		<!-- -----------------------Footer End--------------------- -->
	</div>
	
<script type="text/javascript">
	function addToCart() {
	  
	  var user = "<%=userName%>";
	 

	  if (user !== "Hi Guest") {
		 
          var user = "<%=userName%>"
    		
  		
      if (user != "Guest")
         {  
    	  
     $.post("ajex/ajexController.jsp",
     {
     action: "addtocart",
     
     },
     function(data) {
     console.log("Ok Number JS code Execues"+data);
     console.log("Ajax Successfully added");
     }
     )
     .fail(function() {
            console.log('AJAX request failed');
        });
     showPopup();
     document.getElementById("addToCardFrom").submit();
    
         }
      else
     {
        console.log("user is not log in so pls login fist then ");
        openLoginPage();
     }
	}
}
	
	</script>
</body>	 
<script src="<%=request.getContextPath()%>/js/netmeds.js"></script>
 		  
</html>
