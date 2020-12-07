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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Management_system_datasource msd;
	
	@Resource(name="jdbc/management-system")
	private DataSource dataSource;
	private User user;
	
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
		String theCommand = request.getParameter("command");
		
		// if the command is missing, then default to listing students
		
		switch (theCommand) {
		
		case "LOGIN":
			login(request, response);
			break;
			
		case "LOGOUT":
			logout(request, response);
			break;
			
		case "EDIT":
			editable(request, response);
			break;
			
		case "UPDATE":
			updateinfo(request, response);
			break;
			
		case "!EDIT":
			System.out.println("Not edit executed.");
			NotEditable(request, response);
			break;
			}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
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
	
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			session.removeAttribute("logged");
			session.invalidate();
			response.sendRedirect("in.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateinfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		try {
			 System.out.println("Edit attribute exist..");
			 String fname = request.getParameter("fname");
			 String lname =  request.getParameter("lname");
			 String email = request.getParameter("email");
			 int em_id = (Integer) session.getAttribute("em_id");
			 String pass = (String) session.getAttribute("pass");
			 System.out.println("em_d while editing: " + em_id);
			 msd.updateinfo(fname, lname, email, em_id, pass);
			session.removeAttribute("edit");
			dispatcher = request.getRequestDispatcher("/profile.jsp");
			dispatcher.forward(request, response);
		
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void editable(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		try {
			if(session.getAttribute("edit") == null) {
				System.out.println("Edit attribute is created..");
				System.out.println("em_d before editing is : " + session.getAttribute("em_id"));
				session.setAttribute("edit", true);
				dispatcher = request.getRequestDispatcher("/profile.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void NotEditable(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		try {
			session.removeAttribute("edit");
			dispatcher = request.getRequestDispatcher("/profile.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void cheker(HttpServletRequest request, HttpServletResponse response, HttpSession session, String page, boolean boo) {
		String str = "";
		try {
			if(boo = true) {
				 System.out.println("This first if was passed " + boo);
				 String name = msd.getUser().firstName;
				 String lname = msd.getUser().lastName;
				 String email = msd.getUser().email;
				 String uname = msd.getUser().username;
				 int em_id = msd.getUser().em_id;
				 String pass = msd.getUser().password;
				 session.setAttribute("logged",boo);
				 session.setAttribute("name",name);
				 session.setAttribute("lname",lname);
				 session.setAttribute("email",email);
				 session.setAttribute("uname",uname);
				 session.setAttribute("pass",pass);
				 session.setAttribute("em_id",em_id);
				 response.sendRedirect(page);
				 //RequestDispatcher dispatcher = request.getRequestDispatcher("/"+page);
				 //dispatcher.forward(request, response);
			 } 
			  if(boo = false) {
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
