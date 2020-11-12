package com.dul.userManagement;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Admin a = new Admin();
		Supervisor s = new Supervisor();
		Employee e = new Employee();
		//User e = null;
		//System.out.println(e.toString());
//		a.add_supervisor("Abdul", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.add_supervisor("Abdu", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.add_supervisor("Abduly", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		System.out.println(s.toString());
//		System.out.println(a.toString());
//		System.out.println(u.toString());
		//System.out.println(e.toString());
		a.addUser(e, "Abdul", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		a.addUser(s, "Abdu", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		a.addUser(a, "Abdul", "Omar123", "aomar1", "abdul@dul.com", "123 1 st");
		s.addUser(e, "Ab", "Omar", "aomar", "abdul@dul.com", "123 1 st");
		a.addUser(e, "Abcd", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		System.out.println(s.addUser(s, "Abbbb", "Omar", "aomar", "abdul@dul.com", "123 1 st"));
		System.out.println();
		System.out.println("Employees in Supervisor: ");
		System.out.println(s.getEmployee());
		System.out.println();
		System.out.println("Employees in Admin: ");
		System.out.println(a.getEmployee());
		System.out.println("Supervisors in Admin");
		System.out.println(a.getSupervisor());
		System.out.println();
		System.out.println("Admin in Admin: ");
		System.out.println(a.getAdmin().toString());

	}

}
