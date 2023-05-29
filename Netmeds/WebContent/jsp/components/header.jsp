<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.netmeds.dao.GetAddress"%>
<html lang="en">

<head>
    <title>Header</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/netmeds.css">
	<script src="<%=request.getContextPath()%>/js/jquery-3.6.4.js"></script>
	
</head>

<body>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"> 
    <div class="wrapper">
        <!-- --------------------login Page Start------------------ -->
        <div id="loginPage">
            <div id="overlayForLogIn" onclick="logInPopUp.logInPopUpOff()"></div>
            <div class="logInForm">
                <form id="loginForm" action="<%=request.getContextPath()%>/loginRegistration">
                    <h2>Login Form</h2>
                    <hr style="margin-bottom: 40px;">

                    <input id="userName" type="text" name="email" placeholder="Enter Email"
                        oninput="restrict.restrictForMail(this);Validation.mail()"></input>


                    <input id="userPassword" type="text" name="password" placeholder="Enter Password"></input><br> <span
                        id="incorrectData"></span><br>
                        
                    <input type="hidden" value="login" name="checkForm"></input>

                    <button class="logInFormBtn" onclick="logInPopUp.emptyData();">Log
                        In</button>
                    <button class="cancelFormBtnForLogin" onclick="logInPopUp.logInPopUpOff()">Cancel</button>
                    <div class="alreadyAccount">
                        <span>New User?</span><a href="#" onclick="logInPopUp.registrationPopUpviaLogin();Validation.resetdata();"><span>
                                Register Now</span></a>
                    </div>
                </form>
            </div>
        </div>
        <!-- ------------------------login Page End------------------------ -->

      <!-- --------------------Registration Page Start------------------ -->
<div id="registrationPage">
    <div id="overlayForRegistration" onclick="registractionPopUp.registrationPopUpOff()"></div>

    <div class="registrationForm">
        <form id="registerForm" action="<%=request.getContextPath()%>/loginRegistration">
            <h2>Registration Form</h2>
            <hr style="margin-bottom: 40px;">

            <input id="firstName" type="text" name="firstName" placeholder="Enter First Name"
                oninput="restrict.restrictNumbers(this);Validation.firstName();">
            <span id="firsterror"></span>
            <input id="last" type="text" name="lastName" placeholder="Enter Last Name"
                oninput="restrict.restrictNumbers(this);Validation.lastName(); "></input>
            <span id="lasterror"></span>
            <input id="mail" type="text" name="mail" placeholder="Enter Mail"
                oninput="restrict.restrictForMail(this);Validation.mail()"></input>
            <span id="mailerror"></span>
            <input id="phone" type="text" maxlength="10" name="phone" placeholder="Enter Phone Number"
                oninput="restrict.restrictAllAcptNumber(this); Validation.phone();"></input>

            <br>
            <span id="phoneerror"></span>

            <div class="form-group">
                <input type="text" id="address" name="address" placeholder="Enter your address">
            </div>
            <div class="form-group">
                <label for="state">State:</label>
              
              <select id="state" name="state" onchange="getCities(this.value)">
                 <option value="">Select state</option>
                <%
                	GetAddress statelist=new GetAddress();
                	ArrayList state= statelist.getStates();
                	for(int i=0;i<state.size();i++){%>
                	<option value="<%= state.get(i)%>"><%= state.get(i)%></option>
              <% } %>
                </select>
            </div>
            <div class="form-group city-dropdown">
                <label for="city">City:</label>
                <select id="cityDropDown" name="city" >
                    <option value="" selected>Select a city</option>
                    
                </select>
            </div>

            <div class="form-group">
                <label for="role">Role:</label>
                <select id="role" name="role" >
                   
                    <option value="User" selected>User</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>

            <input id="pin" type="text" name="pin" maxlength="6" placeholder="Pincode" oninput="restrict.restrictAllAcptNumber(this)"></input><br>
            <span id="pinerror"></span>

       
            <input id="password" type="text" name="password"
                placeholder="Password "
                oninput="Validation.password();"></input><br>
            <span id="passworderror"></span>
            <input id="confirm_Password" type="text" placeholder="Re-Enter Password"></input><br> <span
                id="confirm_Password_error"></span>
            <input type="hidden" value="registration" name="checkForm"></input>

            <button type="button" class="logInFormBtn" id="submitbtn"
                onclick="Validation.fillAllData();Validation.conformPassword();Validation.formSubmit();">Submit</button>
            <button class="reset" type="reset" id="reset" onclick="Validation.resetdata()">Reset</button>
            <button class="cancelFormBtn" onclick="registractionPopUp.registrationPopUpOff()"
                type="button">Cancel</button>

            <p id="result"></p>

            <div class="alreadyAccount">
                <span>Already Registered?</span><a href="#"
                    onclick="registractionPopUp.logInPopUpOnviaRegistration();Validation.resetdata();"><span>
                        Click here to login</span></a>
            </div>
        </form>
    </div>
</div>
<!-- --------------------Registration Page End------------------ -->



        <header class="navBar">

            <div class="pageWrap logo">
                <a href="<%=request.getContextPath()%>/jsp/netmeds.jsp"><img src="<%=request.getContextPath()%>/images/netmeds.png" /></a>
            </div>
            
           <div class="search">
					<input type="text" placeholder="Search for medicine & wellness products...	" class="src" >
			</div>
			<div class="src-btn">
  			 <button><img src="<%=request.getContextPath()%>/images/searchBtn.png" /></button>
			</div>


            <div class="boxoflogin">
                <div class="cartIconDiv invert" id="cart-logo">
                    <a href="<%=request.getContextPath()%>/jsp/components/addToCart.jsp" ><img src="<%=request.getContextPath()%>/images/cartIcon.png"/>
                        <p id="itemsInCart" style="color: beige;margin-right: 26px;margin-top: -5px;"></p>
                    </a>
                </div>
                
                <div class="loginDiv">

                    <a href="#" id="login" onclick="logInPopUp.logInPopUpOn()">Login /</a>
                    <a href="#" id="registration" onclick="registractionPopUp.registrationPopUpOn()">Registration</a>
        
       				<form id="logoutForm" action="<%=request.getContextPath()%>/loginRegistration">
					    <a href="#" id="logoutbtn" style="display: none" onclick="document.getElementById('logoutForm').submit();logout()">Log out</a>
					    <input type="hidden" value="logout" name="checkForm" />
					</form>
        
        			<%Object Name;
						if(session.getAttribute("Name")!=null && session.getAttribute("Name")!=" ")
						{
							Name= session.getAttribute("Name");
						}
						else
						{
							Name="Hi Guest";
						}
					%>
							<li id="customer_Name"><%=Name %></li>	 
                </div>
            </div>
            
            <%
				if(Name != "Hi Guest")
				{%>
					<script type="text/javascript">
					$("#logoutbtn").css("display","block");
					$("#login").css("display","none");
					$("#registration").css("display","none");
					$("#cart-logo").css("display","block");
					</script>
			<%	}%>
			<div class="clr"></div>
        </header>
        <div class="main_navigation">
            <div class="explorer_menu">
                <ul class="nav">
                   
                    <li>
                      
	                    <form id="medicine" action="<%=request.getContextPath()%>/loginRegistration">
	                        <a href="#" class="medicine" onclick="document.getElementById('medicine').submit()">Medicine</a>
	                        <input type="hidden" value="medicine" name="checkForm" />
						</form>    
                    </li>  
                    <li>
                        
	                     <form id="wellness" action="<%=request.getContextPath()%>/loginRegistration">
	                        <a href="#" class="medicine" onclick="document.getElementById('wellness').submit()">wellness</a>
	                     	<input type="hidden" value="wellness" name="checkForm" />
						</form>
                    </li>
                    <li>
                         
	                     <form id="beauty" action="<%=request.getContextPath()%>/loginRegistration">
	                        <a href="#" class="medicine" onclick="document.getElementById('beauty').submit()">Beauty</a>
	                     	<input type="hidden" value="beauty" name="checkForm" />
						</form>                   
					 </li>
                     <li>
                        
	                     <form id="healthCare" action="<%=request.getContextPath()%>/loginRegistration">
	                        <a href="#" class="medicine" onclick="document.getElementById('healthCare').submit()">Health Care</a>
	                     	<input type="hidden" value="healthCare" name="checkForm" />
						</form>                     
					 </li>
                </ul>
            </div>
        </div>
    </div>
</body>
<script src="<%=request.getContextPath()%>/js/netmeds.js"></script>

</html>