package com.dul.userManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class Management_system_datasource {

	private DataSource dataSource;
	private User user;
	private String dusername = "";
	private String dpass = "";
	private String prev = "";
	private int em_id;
	int recurring = 0;
	private final String UPDATE = "update user_information " + "set firstname=?, lastname=?, email=? "
			+ "where em_id=?";

	public Management_system_datasource(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public User getUser() {
		return user;
	}

//	public List<Student> getStudents() throws Exception {
//		
//		List<Student> students = new ArrayList<>();
//		
//		Connection myConn = null;
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		
//		try {
//			// get a connection
//			myConn = dataSource.getConnection();
//			
//			// create sql statement
//			String sql = "select * from student order by last_name";
//			
//			myStmt = myConn.createStatement();
//			
//			// execute query
//			myRs = myStmt.executeQuery(sql);
//			
//			// process result set
//			while (myRs.next()) {
//				
//				// retrieve data from result set row
//				int id = myRs.getInt("id");
//				String firstName = myRs.getString("first_name");
//				String lastName = myRs.getString("last_name");
//				String email = myRs.getString("email");
//				
//				// create new student object
//				Student tempStudent = new Student(id, firstName, lastName, email);
//				
//				// add it to the list of students
//				students.add(tempStudent);				
//			}
//			
//			return students;		
//		}
//		finally {
//			// close JDBC objects
//			close(myConn, myStmt, myRs);
//		}		
//	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

//	public void addStudent(Student theStudent) throws Exception {
//
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		
//		try {
//			// get db connection
//			myConn = dataSource.getConnection();
//			
//			// create sql for insert
//			String sql = "insert into student "
//					   + "(first_name, last_name, email) "
//					   + "values (?, ?, ?)";
//			
//			myStmt = myConn.prepareStatement(sql);
//			
//			// set the param values for the student
//			myStmt.setString(1, theStudent.getFirstName());
//			myStmt.setString(2, theStudent.getLastName());
//			myStmt.setString(3, theStudent.getEmail());
//			
//			// execute sql insert
//			myStmt.execute();
//		}
//		finally {
//			// clean up JDBC objects
//			close(myConn, myStmt, null);
//		}
//	}
//
//	public Student getStudent(String theStudentId) throws Exception {
//
//		Student theStudent = null;
//		
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		ResultSet myRs = null;
//		int studentId;
//		
//		try {
//			// convert student id to int
//			studentId = Integer.parseInt(theStudentId);
//			
//			// get connection to database
//			myConn = dataSource.getConnection();
//			
//			// create sql to get selected student
//			String sql = "select * from student where id=?";
//			
//			// create prepared statement
//			myStmt = myConn.prepareStatement(sql);
//			
//			// set params
//			myStmt.setInt(1, studentId);
//			
//			// execute statement
//			myRs = myStmt.executeQuery();
//			
//			// retrieve data from result set row
//			if (myRs.next()) {
//				String firstName = myRs.getString("first_name");
//				String lastName = myRs.getString("last_name");
//				String email = myRs.getString("email");
//				
//				// use the studentId during construction
//				theStudent = new Student(studentId, firstName, lastName, email);
//			}
//			else {
//				throw new Exception("Could not find student id: " + studentId);
//			}				
//			
//			return theStudent;
//		}
//		finally {
//			// clean up JDBC objects
//			close(myConn, myStmt, myRs);
//		}
//	}
//
	public void updateStudent(User theuser) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create SQL update statement
			String sql = "update student " + "set first_name=?, last_name=?, email=? " + "where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theuser.getFirstName());
			myStmt.setString(2, theuser.getLastName());
			myStmt.setString(3, theuser.getEmail());
			myStmt.setInt(4, theuser.getEm_id());

			// execute SQL statement
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

//	public void deleteStudent(String theStudentId) throws Exception {
//
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		
//		try {
//			// convert student id to int
//			int studentId = Integer.parseInt(theStudentId);
//			
//			// get connection to database
//			myConn = dataSource.getConnection();
//			
//			// create sql to delete student
//			String sql = "delete from student where id=?";
//			
//			// prepare statement
//			myStmt = myConn.prepareStatement(sql);
//			
//			// set params
//			myStmt.setInt(1, studentId);
//			
//			// execute sql statement
//			myStmt.execute();
//		}
//		finally {
//			// clean up JDBC code
//			close(myConn, myStmt, null);
//		}	
//	}

	public boolean signin(String username, String password) {
		user = new User(username, password);
		boolean boo = false;
		System.out.println("Username and pass are: " + user.getUsername() + " and " + user.getPassword());
		fetchdata(username, password);
		System.out.println("Username and pass from database are: " + dusername + " " + dpass + " " + prev);
		if (dusername.equalsIgnoreCase(user.getUsername()) && dpass.equalsIgnoreCase(user.getPassword())) {
			boo = true;
		}
		return boo;

	}

	private void fetchdata(String username, String password) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "select * from login where username=? && password=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, user.getUsername());
			myStmt.setString(2, user.getPassword());
			// execute query
			System.out.println("Prepared statement is: " + myStmt);
			myRs = myStmt.executeQuery();
			System.out.println("Result set executed.......");
			// process result set
			while (myRs.next()) {
				System.out.println("Inside Result set while loop....");
				// retrieving data from result set row
				dusername = myRs.getString("username");
				dpass = myRs.getString("password");
				prev = myRs.getString("prev");
				em_id = myRs.getInt("em_id");
				System.out.println("employee id is: " + em_id);
				// setting to retrieve user informations later.
				user.setUsername(dusername);
				user.setPassword(dpass);
				profile(em_id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	//
	private User profile(int em_id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "select * from user_information where em_id=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, em_id);
			// execute query
			System.out.println("Prepared statement is: " + myStmt);
			myRs = myStmt.executeQuery();
			System.out.println("Result set executed.......");
			// process result set
			while (myRs.next()) {
				System.out.println("Inside Result set while loop....");
				// retrieving data from result set row
				user.setFirstName(myRs.getString("firstname"));
				user.setLastName(myRs.getString("lastname"));
				user.setEmail(myRs.getString("email"));
				user.setEm_id(em_id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return user;
	}

	public boolean adminsignin(String uname, String pass) {
		signin(uname, pass);
		if (prev.equals("admin")) {
			return true;
		}
		return false;
	}

	public boolean updateinfo(String fname, String lname, String email, int em_id2) {
		System.out.println("Update info called..");
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();
			myStmt = myConn.prepareStatement(UPDATE);
			myStmt.setString(1, fname);
			myStmt.setString(2, lname);
			myStmt.setString(3, email);
			// myStmt.setString(4, pass);
			myStmt.setInt(4, em_id2);
			System.out.println("Prepared statement inside update is: " + myStmt);
			// execute query
			myStmt.executeUpdate();
			System.out.println("Update info was executed....");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}

		return false;
	}

	public boolean signup(String fname, String lname, String uname, String pass, String email, int em_id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		String sql1 = "insert into user_information " + "(firstname, lastname, email, em_id) " + "values (?, ?, ?, ?)";
		String sql2 = "insert into login " + "(em_id, username, password) " + "values (?, ?, ?)";

		try {
			// get a connection
			myConn = dataSource.getConnection();
			myStmt = myConn.prepareStatement(sql1);
			myStmt.setString(1, fname);
			myStmt.setString(2, lname);
			myStmt.setString(3, email);
			myStmt.setInt(4, em_id);
			System.out.println("Prepared statement inside signup is: " + myStmt);
			// execute query
			myStmt.executeUpdate();
			close(myConn, myStmt, myRs);
			// Getting another connection
			myConn = dataSource.getConnection();
			myStmt = myConn.prepareStatement(sql2);
			myStmt.setInt(1, em_id);
			myStmt.setString(2, uname);
			myStmt.setString(3, pass);
			System.out.println("Prepared statement inside signup for login: " + myStmt);
			int boo = myStmt.executeUpdate();
			System.out.println("Value of boo is: " + boo);
			if (boo > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return false;
	}

	@SuppressWarnings("resource")
	public String updatePass(Integer employeeId, String username, String password) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String data = "";
		boolean validated = false;
		String sql = "";
		try {
			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			if (this.recurring == 0) {
				sql = "select * from login where username=? && em_id=?";

				myStmt = myConn.prepareStatement(sql);

				myStmt.setString(1, username);
				myStmt.setInt(2, employeeId);
				// execute query
				System.out.println("Prepared statement is: " + myStmt);
				myRs = myStmt.executeQuery();
				// process result set
				while (myRs.next()) {
					// retrieving data from result set row
					this.dusername = myRs.getString("username");
					this.dpass = myRs.getString("password");
					this.em_id = myRs.getInt("em_id");
					validated = validateData(employeeId, username);
				}
			}
			
			// create sql statement for udating the new password
			if (this.recurring == 1) {
				sql = "update login " + "set password=?"
						+ "where em_id=?";;

				myStmt = myConn.prepareStatement(sql);

				myStmt.setString(1, password);
				myStmt.setInt(2, employeeId);
				// execute query
				myStmt.executeUpdate();
				validated = false;
				data = password;
				
			}

			if (validated) {
				this.recurring = 1;
				close(myConn, myStmt, myRs);
				updatePass(employeeId, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return data;

	}

	// Checking if the passed parameter equals to what's on the database
	private boolean validateData(Integer employeeId, String username) {
		if ((employeeId == (em_id)) & (username.equals(dusername))) {
			return true;
		}
		return false;
	}
}
