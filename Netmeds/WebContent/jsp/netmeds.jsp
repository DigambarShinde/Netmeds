<%@page import="com.netmeds.helper.Images"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Netmeds Clone</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/netmeds.css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.4.js"></script>
</head>

<body>
    <div class="wrapper">
        <!-- --------------------Header Start------------------ -->
        <jsp:include page="components/header.jsp" />
        <!-- --------------------Header Start------------------ -->

        <div class="image_wrapper">
            <img class="slider_image" src="<%=request.getContextPath()%>/images/slider1.jpg">
            <img class="slider_image" src="<%=request.getContextPath()%>/images/slider2.jpg">
            <img class="slider_image" src="<%=request.getContextPath()%>/images/slider3.jpg">
        </div>

        <% ArrayList list = (ArrayList)Images.getHomeProducts();%>

        <% int id = 0; %>
        <div id="outer_section">
            <!-- -------------------------Inner Section Start--------------------- -->
            <div class="inner_section">
                <!-- -------------------------Boxes div start--------------------- -->
                <div class="boxes">
                    <% for (int i = 0; i < list.size(); i++) {
                        Object item = list.get(i);
                        for (int j = 0; j <= list.size(); j++) {
                            if (i == 0) {
                                id = i;
                                break;
                            } else if (i % 5 == 0) {
                                id = i;
                                break;
                            }
                        }

                        if (i % 5 == 1) { %>
                            <a href="<%=request.getContextPath()%>/jsp/components/productInfo.jsp?Product_Id=<%=list.get(id)%>">
                                <div class="box">
                                    <div class="box_content">
                                        <img src="<%= request.getContextPath()%>/images/<%= item %>" style="width: 250px; height: 250px; margin: 0 auto;">
                                   <br><br><br><br>
                        <% } else if (i % 5 == 2) { %>
                                     <p>Product Name: <%= item %></p>
                        <% } else if (i % 5 == 3) { %>
                                    <span>Manufacturer: <%= item %></span>
                        <% }
                       		 if (i % 5 == 4) { %>
                                    <span>Price: <%= item %></span>
                                </div>
                              </div>
                            </a> 
                            <!-- Closing div for box class -->
                        <% }      
                    } %>
                    <div class="clr"></div>
                </div>
                <!-- -------------------------Boxes div End--------------------- -->
            </div>
            <div class="clr"></div>
        </div>

        <!-- -----------------------Footer Start-------------------- -->
        <jsp:include page="components/footer.jsp" />
        <!-- -----------------------Footer End--------------------- -->
    </div>
</body>
<script src="<%=request.getContextPath()%>/js/netmeds.js"></script>

</html>
