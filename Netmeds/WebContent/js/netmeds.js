//---------------------------------------Pop Up for Login------------------------------------------
var logInPopUp = new loginPopUpFunction();
function loginPopUpFunction() {

this.logInPopUpOn = logInPopUpOn;
function logInPopUpOn() {
  document.getElementById('loginPage').style.display = "block";
  document.getElementById('overlayForLogIn').style.display = "block";
}

this.logInPopUpOff = logInPopUpOff;
function logInPopUpOff() {
  document.getElementById('loginPage').style.display = "none";
  Validation.resetdata();
  
}

this.registrationPopUpviaLogin = registrationPopUpviaLogin;
function registrationPopUpviaLogin() {
  document.getElementById('loginPage').style.display = "none";
  document.getElementById('registrationPage').style.display = "block";
  document.getElementById('overlayForRegistration').style.display = "block";
}
//--------------------------------------------to Check wheather fields are empty or not------------------------------------------
this.emptyData = emptyData;
function emptyData() {

  var userName = document.getElementById('userName').value;
  var userPassword = document.getElementById('userPassword').value;

  if (userName == "" || userPassword == "") {
	  
    document.getElementById('incorrectData').innerHTML = "Please Fill Out Required Field";
  }else{
	  
  }
  
}
//--------------------------------Regex Validation for User Name-------------------------------------
this.userNamereg=userNamereg;
function userNamereg(){

  var firstreg = /^[a-zA-Z]+$/;
  var firstname = document.getElementById("userName").value;

  if (firstreg.test(firstname)) {
    document.getElementById("userNameError").innerHTML = " ";
  }
  else {
    document.getElementById("userNameError").innerHTML = "*Please Enter valid First Name";
    document.getElementById("userNameError").style.color = 'red';
  }
}
}
//---------------------------------------Pop Up for Login End's------------------------------------------
//---------------------------------------Pop Up for Registraction------------------------------------------
var registractionPopUp = new registractionPopUpFunction();
function registractionPopUpFunction() {

this.registrationPopUpOn = registrationPopUpOn;
function registrationPopUpOn() {
  document.getElementById('registrationPage').style.display = "block";
  document.getElementById('overlayForRegistration').style.display = "block";
}

this.registrationPopUpOff = registrationPopUpOff;
function registrationPopUpOff() {
  document.getElementById('registrationPage').style.display = "none";
  Validation.resetdata();
}

this.logInPopUpOnviaRegistration = logInPopUpOnviaRegistration;
function logInPopUpOnviaRegistration() {
  document.getElementById('registrationPage').style.display = "none";
  document.getElementById('loginPage').style.display = "block";
  document.getElementById('overlayForLogIn').style.display = "block";
}

}
//--------------------------------------------Validation Start-----------------------------------------------
var Validation = new registractionValidation();
function registractionValidation() {

var date = new Date();
//------------------------------------------------For Blank Spaces ---------------------------------- 
this.fillAllData = fillAllData;
function fillAllData() {

  var firstName = document.getElementById('firstName').value;
  var lastName = document.getElementById('last').value;
  var mail = document.getElementById('mail').value;
  var phone = document.getElementById('phone').value;
  var password = document.getElementById('password').value;
  var confirm_password = document.getElementById('confirm_Password').value;

  if (firstName == "") {
    document.getElementById("firsterror").innerHTML = "Please Fill Out This Field";
    document.getElementById("firsterror").style.color = 'red';
  } else if (lastName == "") {
    document.getElementById("lasterror").innerHTML = "Please Fill Out This Field";
    document.getElementById("lasterror").style.color = 'red';
  } else if (mail == "") {
    document.getElementById("mailerror").innerHTML = "Please Fill Out This Field";
    document.getElementById("mailerror").style.color = 'red';
  }
  else if (phone == "") {
    document.getElementById("phoneerror").innerHTML = "Please Fill Out This Field";
    document.getElementById("phoneerror").style.color = 'red';
  }
  else if (password == "") {
    document.getElementById("passworderror").innerHTML = "Please Fill Out This Field";
    document.getElementById("passworderror").style.color = 'red';
  } else if (confirm_password == "") {
    document.getElementById("confirm_Password_error").innerHTML = "Please Fill Out This Field";
    document.getElementById("confirm_Password_error").style.color = 'red';
  } else {
    return true;
  }
}
//---------------------------------First Name Validation------------------------------
this.firstName = firstName;
function firstName() {
  var firstreg = /^[a-zA-Z]+$/;
  var firstname = document.getElementById("firstName").value;

  if (firstreg.test(firstname)) {
    document.getElementById("firsterror").innerHTML = " ";
    return true;
  }
  else {
    document.getElementById("firsterror").innerHTML = "*Please Enter valid First Name";
    document.getElementById("firsterror").style.color = 'red';
  }
}
//---------------------------------Last Name Validation------------------------------
this.lastName = lastName;
function lastName() {
  var lastreg = /^[a-zA-Z]+$/;
  var lastname = document.getElementById('last').value;

  if (lastreg.test(lastname)) {
    document.getElementById("lasterror").innerHTML = " ";
    return true;
  } else {
    document.getElementById("lasterror").innerHTML = "*Please Enter valid Last Name";
    document.getElementById("lasterror").style.color = 'red';
  }
}
//---------------------------------Mail Validation------------------------------
this.mail = mail;
function mail() {
  var mailreg = /^[a-zA-Z_0-9.+-]{3,}@{1}[a-zA-Z]{2,}[.]{1}[a-z]{1,}$/;
  var mail = document.getElementById('mail').value;

  if (mailreg.test(mail)) {
    document.getElementById("mailerror").innerHTML = " ";
    return true;
  } else {
    document.getElementById("mailerror").innerHTML = "*Please Enter valid Mail Id";
    document.getElementById('mailerror').style.color = 'red';
  }
}
//---------------------------------Phone Validation------------------------------
this.phone = phone;
function phone() {

  var phonereg = /^([6-9]{1})([0-9]{9})$/;
  var phone = document.getElementById('phone').value;

  if (phonereg.test(phone)) {
    document.getElementById("phoneerror").innerHTML = " ";
    return true;
  } else {
    document.getElementById("phoneerror").innerHTML = "*Please Enter valid Phone Number";
    document.getElementById('phoneerror').style.color = 'red';
  }
}
//---------------------------------Password Function------------------------------
this.password = password;
function password() {

  var password = document.getElementById('password').value;

  if (password == "") {
    document.getElementById("passworderror").innerHTML = "Please Fill Out This Field";
    document.getElementById('passworderror').style.color = 'red';
  } else {
    document.getElementById("passworderror").innerHTML = "";
    return true;
  }
}
//---------------------------------Confirm PassWord Function------------------------------
this.conformPassword = conformPassword;
function conformPassword() {

  var password = document.getElementById('password').value;
  var confirm_Password = document.getElementById('confirm_Password').value;

  if (password == confirm_Password) {
    return true;
  } else {
    document.getElementById("confirm_Password_error").innerHTML = "*Password is Incorrect!!Please Enter Correct Password";
    document.getElementById("confirm_Password_error").style.color = 'red';
  }
}
//---------------------------------Reset Form------------------------------
this.resetdata = resetdata;
function resetdata() {

  document.getElementById("firsterror").innerHTML = "";
  document.getElementById("lasterror").innerHTML = "";
  document.getElementById("mailerror").innerHTML = "";
  document.getElementById("phoneerror").innerHTML = "";
  document.getElementById("passworderror").innerHTML = "";
  document.getElementById("confirm_Password_error").innerHTML = "";
  

  document.getElementById("firstName").value= "";
  document.getElementById("last").value = "";
  document.getElementById("mail").value = "";
  document.getElementById("phone").value = "";
  document.getElementById("address").value = "";
  document.getElementById("state").value = "";
  document.getElementById("city").value = "";
  document.getElementById("pin").value = "";
  document.getElementById("landmark").value = "";
  document.getElementById("password").value = "";
  document.getElementById("confirm_Password").value ="";
  
  document.getElementById("userName").value= "";
  document.getElementById("userPassword").value= "";
  
  
  

}
//---------------------------------Submit form Validation------------------------------
this.formSubmit = formSubmit;
function formSubmit() {
  if (fillAllData() == true && mail() == true && phone() == true && password() == true && conformPassword() == true) {
    //var formid = document.getElementById("registerForm");
	  document.getElementById("registerForm").submit();
  //  document.getElementById('registrationPage').style.display = "none";
   // document.getElementById('outer_section').style.display = 'none';
   // document.getElementById('table').style.display = 'block';
   // submitData();

  } else {
    document.getElementById("result").innerHTML = "Please Fill Up Required Fields";
    document.getElementById("result").style.color = 'red';
  }
}
//---------------------------------Submit Data-------------------------
//this.submitData = submitData;
//function submitData() {
//
//  var firstName = document.getElementById('firstName').value;
//  var lastName = document.getElementById('last').value;
//  var dob = document.getElementById('dob').value;
//  var doj = document.getElementById('doj').value;
//  var mail = document.getElementById('mail').value;
//  var phone = document.getElementById('phone').value;
//
//  document.getElementById('tableFirstName').innerHTML = firstName;
//  document.getElementById('tableLastName').innerHTML = lastName;
//  document.getElementById('tabledob').innerHTML = dob;
//  document.getElementById('tabledoj').innerHTML = doj;
//  document.getElementById('tablemail').innerHTML = mail;
//  document.getElementById('tablephone').innerHTML = phone;
//
//}
}
//--------------------------------------------Validation End---------------------------------------------

//-----------------------------Restrication Part Start's------------------------------
var restrict = new restrication();
function restrication() {

this.restrictNumbers = restrictNumbers;
function restrictNumbers(element) {
  return element.value = element.value.replace(/[^a-zA-Z]+/, '');
}

this.restrictCharacter = restrictCharacter;
function restrictCharacter(element) {
  return element.value = element.value.replace(/[^0-9-]+/, '');
}

this.restrictForMail = restrictForMail;
function restrictForMail(element) {
  return element.value = element.value.replace(/[!#$%^&*()?'":;<>]+/, "");
}

this.restrictAllAcptNumber = restrictAllAcptNumber;
function restrictAllAcptNumber(element) {
  return element.value = element.value.replace(/[^\d]+/, '');
}
}
//-----------------------------Restrication Part End's------------------------------


//-------------------------------LogOut Functionality-----------------------------

function logout(){
	 $("#login").css("display","block");
	 $("#registration").css("display","block");
	 $("#logout").css("display","none");
	 
}


//-------------------------Add To Cart---------------------------------

function showPopup() {    
	var popupOverlay = document.getElementById("popupOverlayProduct");
	 var popup = document.getElementById("popupProduct");

	 
	   popupOverlay.style.display = "block";
	   popup.style.display = "block";

	}

	function closePopupProduct() {    
		var popupOverlay = document.getElementById("popupOverlayProduct");
		var popup = document.getElementById("popupProduct");

	 
		popupOverlay.style.display = "none";
		popup.style.display = "none";
	}
	
	
	function deleteFromCart(prod_id, Cust_id) {
		  var path = document.getElementById("contextPath").value;

		  $.post(path + "/ajax/ajaxController.jsp", {
		    Identifier: "deleteFromCart",
		    product_id: prod_id,
		    customer_id: Cust_id
		  }, function(data) {
		    if (data === "true") {
		      // Redirect to the desired page
		      window.location.href = path + "/jsp/components/addToCart.jsp";
		    }
		  });
	}
	
	
	function getCities(state) 
	{
		  var path = document.getElementById("contextPath").value;

		  $.post(path + "/ajax/controllerForAddress.jsp", {
		    Identifier: "state",
		    state_name: state,
		    
		  }, function(data) {
		    if (data != null) {
		      
		    var obj=JSON.parse(data);
		    var cityDrop=$("#cityDropDown");
		    cityDrop.empty();
		    var option = $("<option>").val("").text("Select City");
		    
		    cityDrop.append(option);
		    
			    for(var i=0;i<obj.length; i++){
			    	var city=obj[i];
			    	option = $("<option>").val(city).text(city);
			    	cityDrop.append(option);
		    	}
		    }
		  });
	}
	
	
	function addressPopUp()
	{
		document.getElementById("addressForm").style.display = "block";
		document.getElementById("proceed").classList.add("faint-button");
	}
	