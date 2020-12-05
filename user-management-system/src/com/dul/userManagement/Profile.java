package com.dul.userManagement;

import java.io.IOException;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
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
		Enumeration attrs =  session.getAttributeNames();
		RequestDispatcher dispatcher;
		if(session.getAttribute("edit") == null) {
				System.out.println("Edit attribute is created..");
				session.setAttribute("edit", true);
				dispatcher = request.getRequestDispatcher("/profile.jsp");
				dispatcher.forward(request, response);
		    } else {
		    	System.out.println("Edit attribute exist..");
    	 String fname = (String) request.getAttribute("fname");
		 String lname = (String) session.getAttribute("lname");
		 String email = (String) session.getAttribute("email");
		 int em_id = (int) session.getAttribute("em_id");
		 String pass = (String) session.getAttribute("pass");
    	msd.updateinfo(fname, lname, email, em_id, pass);
    	session.removeAttribute("edit");
		dispatcher = request.getRequestDispatcher("/profile.jsp");
		dispatcher.forward(request, response);
		
	}
		}

}







