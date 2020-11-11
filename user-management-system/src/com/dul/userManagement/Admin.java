package com.dul.userManagement;

import java.util.List;

public class Admin extends User {
	
	public String password = "password";
	private final String[] PREV= {"SUP", "EMP"};
	private Supervisor supervisor;
	

	protected Admin() {
	}
	

//	public User getSupervisorList() {
//		return supervisors;
//	}


//	public void setSupervisorList(List<User> supervisors) {
//		this.supervisors = supervisors;
//	}


	public String[] getPREV() {
		return PREV;
	}
	
	@SuppressWarnings("static-access")
	public User add_supervisor(String firsname, String lastname, String username, String email, String address) {
//		boolean bool = false;
//		User newsup = new User();
//		newsup.setFirstName(firsname);
//		newsup.setLastName(lastname);
//		newsup.setUsername(username);
//		newsup.setAddress(address);
//		newsup.setEmail(email);
//		newsup.setPassword(this.password);
		
//		this.supervisors.add(newsup);
		supervisor = new Supervisor();
		supervisor.setFirstName(firsname);
		supervisor.setLastName(lastname);
		supervisor.setUsername(username);
		supervisor.setAddress(address);
		supervisor.setEmail(email);
		supervisor.setPassword(this.password);
		
		return supervisor;
	}


	@Override
	String getUsername() {
		return username;
	}


	@Override
	void setUsername(String username) {
		Admin.username = username;
		
	}


	@Override
	String getPassword() {
		return password;
	}


	@Override
	void setPassword(String password) {
		this.password = password;
		
	}


	@Override
	String getFirstName() {
		return firstName;
	}


	@Override
	void setFirstName(String firstName) {
		Admin.firstName = firstName;
		
	}


	@Override
	String getLastName() {
		return lastName;
	}


	@Override
	void setLastName(String lastName) {
		Admin.lastName= lastName;
		
	}


	@Override
	String getAddress() {
		return Address;
	}


	@Override
	void setAddress(String address) {
		Admin.Address = address;
		
	}


	@Override
	String getEmail() {
		
		return email;
	}


	@Override
	void setEmail(String email) {
		Admin.email = email;
		
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address + ", email=" + email
				+ "]";
	}
}
