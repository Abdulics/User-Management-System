package com.dul.userManagement;

public abstract class User {
		public String username;
		public String password;
		public String firstName;
		public String lastName;
		public String Address;
		public String email;
		public String report;
		
		abstract String[] getProfile();
		abstract boolean addUser(Object obj, String firsname, String lastname, String username, String email, String address);

		
}
