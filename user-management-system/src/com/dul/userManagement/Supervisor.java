package com.dul.userManagement;


public class Supervisor extends Admin{
	private Employee employee;// = new ArrayList<>();

	public Supervisor (Employee employee, String firsname, String lastname, String username, String email, String address) {
		this.employee = employee;
		this.firstName = firsname;
		this.lastName = lastname;
		this.username = username;
		this.email = email;
		this.address = address;
	}

	public Supervisor() {
	}

	String getUsername() {
		return username;
	}


	void setUsername(String username) {
		this.username = username;

	}


	private String getPassword() {
		return password;
	}


	void setPassword(String password) {
		this.password = password;

	}


	String getFirstName() {
		return firstName;
	}


	void setFirstName(String firstName) {
		this.firstName = firstName;

	}


	String getLastName() {
		return lastName;
	}


	void setLastName(String lastName) {
		this.lastName= lastName;

	}


	String getAddress() {
		return address;
	}


	void setAddress(String address) {
		this.address = address;

	}


	String getEmail() {

		return email;
	}


	void setEmail(String email) {
		this.email = email;

	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", Address=" + address + ", email=" + email
				+ "]";
	}


	@Override
	String[] getProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEmployee() {
		return employee;
	}
	
	@Override
	protected boolean addUser(/*Object obj, String firsname, String lastname, String username, String email, String address*/) {
		while(employee instanceof Employee) {
			employee = add_employee(/*firsname, lastname, username, email, address*/);
			System.out.println("Added employee inside supervisor....");
			return true;
		}
		return false;
	}

}
