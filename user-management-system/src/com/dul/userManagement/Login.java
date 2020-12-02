package com.dul.userManagement;

import java.io.IOException;

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
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
		String page;
		boolean boo;
		if(uname.equalsIgnoreCase("admin")) {
			page = "welcome.jsp";
			boo = msd.adminsignin(uname, pass);
			cheker(request, response, session, page, boo);
		} else {
		page = "emp_welcom.jsp";
		boo = msd.signin(uname, pass);
		System.out.println("Boo is " + boo);
		cheker(request, response, session, page, boo);
		}
	}
	
	private void cheker(HttpServletRequest request, HttpServletResponse response, HttpSession session, String page, boolean boo) {
		String str = "";
		try {
			if(boo == true) {
				 System.out.println("This first if was passed " + boo);
				 //str = "Logged in suceesfully....";
				 //request.setAttribute("msg",str);
				 session.setAttribute("logged",boo);
				 response.sendRedirect(page);
				 //RequestDispatcher dispatcher = request.getRequestDispatcher("/"+page);
				 //dispatcher.forward(request, response);
			 } 
			  if(boo != true) {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/in.html");
				 dispatcher.forward(request, response);
			  }
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
