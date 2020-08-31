package com.bs.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.ecom.service.UserService;
import com.bs.ecom.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService;

	public void init() throws ServletException {
		try {
			userService = new UserServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();

		try {
			boolean result = userService.registerUser(username, password);
			if (result) {
				out.println("<h2>" + "welcome " + username + "</h2>");
				
			} else {
				out.println("<h2>SOMETHING WENT WRONG</h2>");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
