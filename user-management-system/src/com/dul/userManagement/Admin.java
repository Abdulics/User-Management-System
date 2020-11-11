package com.dul.userManagement;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {

	public String password = "password";
	private final String[] PREV = { "SUP", "EMP" };
	private ArrayList<Object> supList = new ArrayList<>();
	//private ArrayList<Employee> empList = new ArrayList<>();

	/*
	 * Return the list of newly added users, employees, supervisors and admins.
	 */
	public ArrayList<Object> getSupList() {
		return supList;
	}

	public Admin() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public String[] getPREV() {
		return PREV;
	}

	private void add_supervisor(String firsname, String lastname, String username, String email, String address) {
		Supervisor supervisor = new Supervisor();
		supervisor.setFirstName(firsname);
		supervisor.setLastName(lastname);
		supervisor.setUsername(username);
		supervisor.setAddress(address);
		supervisor.setEmail(email);
		supervisor.setPassword(this.password);
		System.out.println("Inside add supp " + supervisor.toString());
		supList.add(supervisor);
		System.out.println("Size of sup is: " + supList.size());
	}

	private void add_employee(String firsname, String lastname, String username, String email, String address) {

		Employee employee = new Employee();
		employee.setFirstName(firsname);
		employee.setLastName(lastname);
		employee.setUsername(username);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(this.password);
		System.out.println("Inside add empl " + employee.toString());
		supList.add(employee);
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
		this.lastName = lastName;

	}

	String getAddress() {
		return Address;
	}

	void setAddress(String address) {
		this.Address = address;

	}

	String getEmail() {

		return email;
	}

	void setEmail(String email) {
		this.email = email;

	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", Address="
				+ Address + ", email=" + email + "]";
	}

	@Override
	String[] getProfile() {
		
		return null;
	}

	@Override
	boolean addUser(Object obj, String firsname, String lastname, String username, String email, String address) {
		if (obj instanceof Employee) {
			add_employee(firsname, lastname, username, email, address);
			System.out.println("Added employee....");
		} else if (obj instanceof Supervisor) {
			add_supervisor(firsname, lastname, username, email, address);
			System.out.println("Added supervisor......");
		} else {
			System.out.println("nothing was added");
			return false;
		}
		return true;
	}
}
