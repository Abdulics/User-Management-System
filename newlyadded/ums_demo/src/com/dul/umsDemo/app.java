package com.dul.umsDemo;

public class app {

	public static void main(String[] args) {
		Object ad;
		ad = new Admin();
		Admin a;
		a = new Admin("Yahya", "Dulli", "ydulli1", "yahyaPass","yahya@dul.com", (Admin) ad);
		System.out.println(a.addUsser());
		System.out.println(a.getFirstName());
		System.out.println(a.getLastName());
		System.out.println(a.getUsername());
		System.out.println(a.getPassword());
		System.out.println(a.getEmail());
		ad = new Supervisor();
		a = new Admin("Abdul", "Moha", "ydulli1", "yahyaPass","yahya@dul.com", (Supervisor)ad);
		System.out.println(a.addUsser());
		System.out.println(a.getFirstName());
		System.out.println(a.getLastName());
		System.out.println(a.getUsername());
		System.out.println(a.getPassword());
		System.out.println(a.getEmail());
		ad = new Employee();
		a = new Admin("Diney", "Dulli", "ydulli1", "yahyaPass","yahya@dul.com", (Employee)ad);
		System.out.println(a.addUsser());
		System.out.println(a.getFirstName());
		System.out.println(a.getLastName());
		System.out.println(a.getUsername());
		System.out.println(a.getPassword());
		System.out.println(a.getEmail());
		//ad = new Employee();
		Supervisor s;
		s = new Supervisor("Ruweida", "Dulli", "ydulli1", "yahyaPass","yahya@dul.com", (Employee)ad);
		System.out.println(s.addUsser());
		System.out.println(s.getFirstName());
		System.out.println(s.getLastName());
		System.out.println(s.getUsername());
		System.out.println(s.getPassword());
		System.out.println(s.getEmail());
		
	}

}
