package com.dul.userManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private Management_system_datasource msd;
	
	@Resource(name="jdbc/management-system")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our ums db util ... and pass in the conn pool / datasource
		try {
			msd = new Management_system_datasource(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * Servlet for signing up
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String employeeid = request.getParameter("employeeid");
		LinkedList<String> list = new LinkedList<String>();
		list.add(0,fname);
		list.add(1,lname);
		list.add(2,email);
		list.add(3,employeeid);
		list.add(4,uname);
		list.add(5,pass);
		boolean boo = msd.signup(fname, lname, uname, pass, email, Integer.parseInt(employeeid));
		if (boo) {
			try {
				response.setContentType("text/html");
				PrintWriter writer = response.getWriter();
				writer.println("<html><body>");
					writer.println("Thanks for signing up");
					writer.println("<br>");
					writer.println("Here is the data you submitted");
					Enumeration names = session.getAttributeNames();
					System.out.println(names.toString());
					int index = 0;
					String name = (String) names.toString();
					String value = list.get(index);
					writer.println("Firstname: "+list.get(0) +"<br>");
					writer.println("LastName: "+list.get(1)+"<br>");
					writer.println("Username: "+list.get(4)+"<br>");
					writer.println("Email: "+list.get(2)+"<br>");
					writer.println("Password: "+list.get(5)+"<br>");
					writer.println("Employee id: "+list.get(3)+"<br>");
					
				writer.println("<p><a href=\"in.html\">Return" + "</a> to login page");
				writer.println("</body></html>");
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
