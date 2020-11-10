package com.dul.userManagement;

import java.util.List;

public class Admin extends User {

	private final String[] PREV= {"SUP", "EMP"};
	private List<User> supervisors;

	private Admin() {
	}
	
}
