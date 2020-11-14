package com.dul.userManagement;

public class App {

	public static void main(String[] args) {
// 		Supervisor s1 = new Supervisor();
// 		Employee e1 = new Employee();
// 		Admin a1 = new Admin();
		Admin a = new Admin(e,"employeeadmin", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		a.addUser();
		Admin b = new Admin(s,"supervisor", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		b.addUser();
		Admin c = new Admin(a,"admin", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		c.addUser();
		//User e = null;
		//System.out.println(e.toString());
//		a.add_supervisor("Abdul", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.add_supervisor("Abdu", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.add_supervisor("Abduly", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		System.out.println(s.toString());
//		System.out.println(a.toString());
//		System.out.println(u.toString());
		//System.out.println(e.toString());
//		a.addUser(e, "Abdul", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.addUser(s, "Abdu", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.addUser(a, "Abdul", "Omar123", "aomar1", "abdul@dul.com", "123 1 st");
//		s.addUser(e, "Ab", "Omar", "aomar", "abdul@dul.com", "123 1 st");
//		s.addUser(e, "Abcd", "Omar", "aomar1", "abdul@dul.com", "123456 1 st");
//		System.out.println(s.addUser(s, "Abbbb", "Omar", "aomar", "abdul@dul.com", "123 1 st"));
//		System.out.printf("Getting address for employee " + s.getAddress());
		System.out.println();
		System.out.println("Employees in Supervisor: ");
		System.out.println(s.getEmployee());
		System.out.println();
		System.out.println("Employees in Admin: ");
		System.out.println(a.getEmployee());
		System.out.println("Supervisors in Admin");
		System.out.println(b.getSupervisor());
		System.out.println();
		System.out.println("Admin in Admin: ");
		System.out.println(c.getAdmin());

	}

}
