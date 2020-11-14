package com.dul.userManagement;

public class Admin extends User {

	public Admin(Supervisor supervisor, String firstName, String lastName, String username, String email, String address) {
		this.supervisor = supervisor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.address = address;
	}

	public Admin(Employee employee, String firstName, String lastName, String username, String email, String address) {
		this.employee = employee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.address = address;
	}

	public Admin(Admin admin, String firstName, String lastName, String username, String email, String address) {
		this.admin = admin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.address = address;
	}

	private Admin admin;
	public String password = "password";
	private final String[] PREV = { "SUP", "EMP" };
	private Supervisor supervisor;
	private Employee employee;

	private Supervisor add_supervisor(/*String firsname, String lastname, String username, String email, String address*/) {
		supervisor = new Supervisor();
		supervisor.setFirstName(firstName);
		supervisor.setLastName(lastName);
		supervisor.setUsername(username);
		supervisor.setAddress(address);
		supervisor.setEmail(email);
		supervisor.setPassword(this.password);
		System.out.println("Inside add supp in Admin " + supervisor.toString());
		return supervisor;
	}

	Employee add_employee(/*String firsname, String lastname, String username, String email, String address*/) {

		employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(this.password);
		System.out.println("Inside add empl in Admin " + employee.toString());
		return employee;
	}

	private Admin add_admin(/*String firsname, String lastname, String username, String email, String address*/) {
		admin = new Admin();
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setUsername(username);
		admin.setAddress(address);
		admin.setEmail(email);
		admin.setPassword(this.password);
		System.out.println("Inside add admin in Admin " + admin.toString());
		return admin;
	}

	protected boolean addUser(/*Object obj, String firtsname, String lastname, String username, String email,
			String address*/) {
		if (employee instanceof Employee) {
			add_employee(/*firtsname, lastname, username, email, address*/);
			System.out.println("Added employee....");
		} else if (supervisor instanceof Supervisor) {
			add_supervisor(/*firtsname, lastname, username, email, address*/);
			System.out.println("Added supervisor......");
		} else if (admin instanceof Admin) {
			add_admin(/*firtsname, lastname, username, email, address*/);
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
	String[] getProfile() {

		return null;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", Address="
				+ address + ", email=" + email + "]";
	}
}
