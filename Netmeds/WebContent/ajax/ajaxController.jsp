<%@page import="com.netmeds.dao.ProductDetails"%>
<%@page import="com.netmeds.dao.GetImages"%>

<%!
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
	  String check = request.getParameter("Identifier");
	  
	  if (check.equals("deleteFromCart")) 
	  {
	    int product_id = Integer.parseInt(request.getParameter("product_id"));
	    int cust_id = Integer.parseInt(request.getParameter("customer_id"));

	    ProductDetails deleteFromCart = new ProductDetails();
	    deleteFromCart.deleteFromCart(product_id, cust_id);
	    return "true";
	  }
	  return "false";
	}
%>
<%=execute(request,response)%>