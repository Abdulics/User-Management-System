package com.dul.umsDemo;

public class Admin extends User implements FunLib {

	public Admin(String firstName, String lastName, String username, String password, String email, Admin admin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}

	public Admin(String firstName, String lastName, String username, String password, String email,
			Supervisor supervisor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.supervisor = supervisor;
	}

	public Admin(String firstName, String lastName, String username, String password, String email, Employee employee) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.employee = employee;
	}

	public Admin() {
	}

	private Supervisor add_supervisor() {
		supervisor = new Supervisor();
		supervisor.setFirstName(firstName);
		supervisor.setLastName(lastName);
		supervisor.setUsername(username);
		supervisor.setEmail(email);
		supervisor.setPassword(this.password);
		System.out.println("Inside add supp in Admin " + supervisor.toString());
		return supervisor;
	}

	private Employee add_employee() {

		employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setEmail(email);
		employee.setPassword(this.password);
		System.out.println("Inside add empl in admin" + employee.toString());
		return employee;
	}

	private Admin add_admin() {
		admin = new Admin();
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setUsername(username);
		admin.setEmail(email);
		admin.setPassword(this.password);
		System.out.println("Inside add admin in admin" + admin.toString());
		return admin;
	}

	@Override
	public boolean addUsser() {
		boolean boo;
		if (employee instanceof Employee) {
			add_employee();
			System.out.println("Added employee....");
			boo = true;
		} else if (supervisor instanceof Supervisor) {
			add_supervisor();
			System.out.println("Added supervisor......");
			boo = true;
		} else if (admin instanceof Admin) {
			add_admin();
			System.out.println("Added an admin......");
			boo = true;
		} else {
			System.out.println("nothing was added");
			boo = false;
		}
		return boo;
	}

	@Override
	public boolean approveTime() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean make_Schedule() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object view_Schedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean make_Report() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean request_Time_Off() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object view_Report() {
		// TODO Auto-generated method stub
		return null;
	}

}
