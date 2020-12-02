package com.dul.userManagement;

public class User {

	public String firstName;
	public String lastName;
	public String username;
	public String password;
	public String email;
	private String report;
	private Object profile;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	Object view_Schedule() {
		return null;
	}
	boolean make_Report() {
		return false;
	}
	boolean request_Time_Off() {
		return false;
	}
	Object view_Report() {
		return null;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Object getProfile() {
		return profile;
	}

	public void setProfile(Object profile) {
		this.profile = profile;
	}

	
	@Override
	public String toString() {
		return  "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", email=" + email;
	}
	
}
