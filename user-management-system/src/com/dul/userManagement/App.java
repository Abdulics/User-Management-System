package com.dul.userManagement;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Admin a = new Admin();
		Supervisor s = new Supervisor();
		Employee u = new Employee();
		//User e = null;
		//System.out.println(e.toString());
//		a.add_supervisor("Abdul", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.add_supervisor("Abdu", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		a.add_supervisor("Abduly", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
//		System.out.println(s.toString());
//		System.out.println(a.toString());
//		System.out.println(u.toString());
		//System.out.println(e.toString());
		a.addUser(u, "Abdul", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		a.addUser(s, "Abdu", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		a.addUser(s, "Abdul", "Omar", "aomar1", "abdul@dul.com", "123 1 st");
		List<Object> list  = a.getSupList();
		
		System.out.println(s.toString());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+":" + list.get(i));
		}

	}

}
