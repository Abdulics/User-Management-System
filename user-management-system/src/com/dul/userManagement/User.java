package com.dul.userManagement;

public abstract class User {
		public String username;
		public String password;
		public String firstName;
		public String lastName;
		public String address;
		public String email;
		public String report;
		
		abstract String[] getProfile();
		
}
