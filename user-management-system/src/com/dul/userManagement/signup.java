package com.dul.userManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			msd = new Management_system_datasource(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
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
		boolean boo = msd.signup(fname, lname, uname, pass, email, employeeid);
		if (boo) {
		response.sendRedirect("emp_welcom.jsp");
		} else {
			session = request.getSession(false);
			try {
				response.setContentType("text/html");
				PrintWriter writer = response.getWriter();
				writer.println("<html><body>");
				if (session == null) {
					writer.println("You are not logged in");
				} else {
					writer.println("Thank you, you are already logged in");
					writer.println("Here is the data in your session");
					Enumeration names = session.getAttributeNames();
					while (names.hasMoreElements()) {
						String name = (String) names.nextElement();
						Object value = session.getAttribute(name);
						writer.println("<p>name=" + name + " value=" + value);
					}
				}
				writer.println("<p><a href=\"in.html\">Return" + "</a> to login page");
				writer.println("</body></html>");
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
