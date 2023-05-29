package com.netmeds.beans;

public class Customer {
	
	String firstName;
	String lastName;
	String email;
	String number;
	String password;
	String address;
	String cityName;
	String stateName;
	String pin;
	String landmark;
	
	
	public Customer(String firstName, String lastName, String email,
			String number, String password, String address, String cityName,
			String stateName, String pin, String landmark) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.number = number;
		this.password = password;
		this.address = address;
		this.cityName = cityName;
		this.stateName = stateName;
		this.pin = pin;
		this.landmark = landmark;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", number=" + number + ", password="
				+ password + ", address=" + address + ", cityName=" + cityName
				+ ", stateName=" + stateName + ", pin=" + pin + ", landmark="
				+ landmark + "]";
	}	
}
