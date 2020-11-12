package com.dul.userManagement;

public class Admin extends User {

	private Admin admin;
	public String password = "password";
	private final String[] PREV = { "SUP", "EMP" };
	private Supervisor supervisor;
	private Employee employee;

	private Object add_supervisor(String firsname, String lastname, String username, String email, String address) {
		supervisor = new Supervisor();
		supervisor.setFirstName(firsname);
		supervisor.setLastName(lastname);
		supervisor.setUsername(username);
		supervisor.setAddress(address);
		supervisor.setEmail(email);
		supervisor.setPassword(this.password);
		System.out.println("Inside add supp in Admin" + supervisor.toString());
		return supervisor;
	}

	protected Object add_employee(String firsname, String lastname, String username, String email, String address) {

		employee = new Employee();
		employee.setFirstName(firsname);
		employee.setLastName(lastname);
		employee.setUsername(username);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(this.password);
		System.out.println("Inside add empl in Admin" + employee.toString());
		return employee;
	}

	private Object add_admin(String firsname, String lastname, String username, String email, String address) {
		admin = new Admin();
		admin.setFirstName(firsname);
		admin.setLastName(lastname);
		admin.setUsername(username);
		admin.setAddress(address);
		admin.setEmail(email);
		admin.setPassword(this.password);
		System.out.println("Inside add admin in Admin" + admin.toString());
		return admin;
	}

	@Override
	protected boolean addUser(Object obj, String firsname, String lastname, String username, String email,
			String address) {
		if (obj instanceof Employee) {
			add_employee(firsname, lastname, username, email, address);
			System.out.println("Added employee....");
		} else if (obj instanceof Supervisor) {
			add_supervisor(firsname, lastname, username, email, address);
			System.out.println("Added supervisor......");
		} else if (obj instanceof Admin) {
			add_admin(firsname, lastname, username, email, address);
			System.out.println("Added an admin......");
		} else {
			System.out.println("nothing was added");
			return false;
		}
		return true;
	}

	/*
	 * Return the newly added users, employees, supervisors and admins.
	 */
	public Object getSupervisor() {
		return supervisor;
	}

	public Object getAdmin() {
		return admin;
	}

	public Object getEmployee() {
		return employee;
	}

	public Admin() {

	}

	public String[] getPREV() {
		return PREV;
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
	String[] getProfile() {

		return null;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", Address="
				+ Address + ", email=" + email + "]";
	}
}
