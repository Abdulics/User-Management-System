package com.dul.userManagement;

public class Employee extends User {

	@Override
	String getUsername() {
		return username;
	}


	@Override
	void setUsername(String username) {
		Employee.username = username;
		
	}


	@Override
	String getPassword() {
		return password;
	}


	@Override
	void setPassword(String password) {
		Employee.password = password;
		
	}


	@Override
	String getFirstName() {
		return firstName;
	}


	@Override
	void setFirstName(String firstName) {
		Employee.firstName = firstName;
		
	}


	@Override
	String getLastName() {
		return lastName;
	}


	@Override
	void setLastName(String lastName) {
		Employee.lastName= lastName;
		
	}


	@Override
	String getAddress() {
		return Address;
	}


	@Override
	void setAddress(String address) {
		Employee.Address = address;
		
	}


	@Override
	String getEmail() {
		
		return email;
	}


	@Override
	void setEmail(String email) {
		Employee.email = email;
		
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address + ", email=" + email
				+ "]";
	}
}
