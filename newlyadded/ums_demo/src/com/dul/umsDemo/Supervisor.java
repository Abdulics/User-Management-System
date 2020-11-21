package com.dul.umsDemo;

public class Supervisor extends User implements FunLib {

	public Supervisor(String firstName, String lastName, String username, String password, String email,
			Employee employee) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.employee = employee;
	}

	Supervisor() {
	}

	private Employee add_employee() {

		employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setEmail(email);
		employee.setPassword(this.password);
		System.out.println("Inside add empl in supervisor" + employee.toString());
		return employee;
	}

	@Override
	public boolean addUsser() {
		if (employee instanceof Employee) {
			add_employee();
			System.out.println("Supervisor added an employee....");
			return true;
		}
		return false;
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
