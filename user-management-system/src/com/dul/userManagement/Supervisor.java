package com.dul.userManagement;

public class Supervisor extends User {

	@Override
	String getUsername() {
		return username;
	}


	@Override
	void setUsername(String username) {
		Supervisor.username = username;
		
	}


	@Override
	String getPassword() {
		return password;
	}


	@Override
	void setPassword(String password) {
		Supervisor.password = password;
		
	}


	@Override
	String getFirstName() {
		return firstName;
	}


	@Override
	void setFirstName(String firstName) {
		Supervisor.firstName = firstName;
		
	}


	@Override
	String getLastName() {
		return lastName;
	}


	@Override
	void setLastName(String lastName) {
		Supervisor.lastName= lastName;
		
	}


	@Override
	String getAddress() {
		return Address;
	}


	@Override
	void setAddress(String address) {
		Supervisor.Address = address;
		
	}


	@Override
	String getEmail() {
		
		return email;
	}


	@Override
	void setEmail(String email) {
		Supervisor.email = email;
		
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address + ", email=" + email
				+ "]";
	}

}
