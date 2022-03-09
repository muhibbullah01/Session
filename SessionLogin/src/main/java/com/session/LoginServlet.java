package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String userName = req.getParameter("userName").trim();
		String password = req.getParameter("password").trim();
		
		if(userName == null || userName.equals("") || 
				password == null || password.equals("")) {
			
			out.print("Please Enter Your Username & Password <br/>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}
		else if(userName.equals("bob") && password.equals("bob")) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			out.println("Logged in Succesfully!<br/>");
			out.println("Click the link bellow to see the User Info.<br/>");
			out.println("<a href='UserInfo'>" + "Click here<a/>");
			out.close();
		}
		else {
			out.print("Wrong Username or Password. <br/>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}
	}

}
