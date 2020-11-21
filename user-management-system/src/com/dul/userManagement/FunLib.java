package com.dul.userManagement;

public interface FunLib {

	Supervisor add_supervisor();
	Supervisor add_employee();
	Supervisor add_admin();
	Supervisor addUsser();
	boolean approveTime();
	boolean make_Schedule();
	Object view_Schedule();
	boolean make_Report();
	boolean request_Time_Off();
	Object view_Report();
}
