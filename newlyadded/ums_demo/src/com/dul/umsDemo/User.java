package com.dul.umsDemo;

public abstract class User {

	public String firstName;
	public String lastName;
	public String username;
	public String password;
	public String email;
	private String report;
	private Object profile;
	public Supervisor supervisor;
	public Employee employee;
	public Admin admin;

	abstract Object view_Schedule();
	abstract boolean make_Report();
	abstract boolean request_Time_Off();
	abstract Object view_Report();

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
