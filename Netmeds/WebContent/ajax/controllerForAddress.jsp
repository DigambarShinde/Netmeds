<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.netmeds.dao.GetAddress"%>

<%!
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
	 
	    String state = request.getParameter("state_name");
	    
	    GetAddress cityName=new GetAddress();
	    ArrayList cityList=cityName.getCities(state);
	    
	    Gson gson=new Gson();
	    String json =gson.toJson(cityList);

	    return json;
	}
%>
<%=execute(request,response)%>