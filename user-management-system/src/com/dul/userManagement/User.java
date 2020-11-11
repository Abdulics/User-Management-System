package com.dul.userManagement;

public abstract class User {
		public static String username;
		public static String password;
		public static String firstName;
		public static String lastName;
		public static String Address;
		public static String email;
		
		protected User() {};
		abstract String getUsername();
		abstract void setUsername(String username);
		abstract String getPassword();
		abstract void setPassword(String password);
		abstract String getFirstName();
		abstract void setFirstName(String firstName);
		abstract String getLastName();
		abstract void setLastName(String lastName);
		abstract String getAddress();
		abstract void setAddress(String address);
		abstract String getEmail();
		abstract void setEmail(String email);
		
		@Override
		public abstract String toString();

		
}
