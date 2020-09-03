package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import db.MyDatabase;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	private boolean validUser(String username, String password) {
		if (username.equals("ramesh") && password.equals("123")) {
			return true;
		}

		return false;
	}

	private void createCookie(String username, String password, HttpServletResponse response) {
		Cookie cookie1 = new Cookie("username", username);
		cookie1.setMaxAge(1000 * 60 * 60 * 24 * 365);
		response.addCookie(cookie1);

		Cookie cookie2 = new Cookie("password", password);
		cookie2.setMaxAge(1000 * 60 * 60 * 24 * 365);
		response.addCookie(cookie2);
	}

	private void createSession(HttpServletRequest request, String username) {
		HttpSession session = request.getSession(true); // always create
		// new
		session.setAttribute("username", username);

		List<Product> cartList = new ArrayList<>();
		session.setAttribute("cart", cartList);
	}

	protected void doThings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean rememberme = request.getParameter("rememberMe") != null;

		if (validUser(username, password) && rememberme) {
			System.out.println("cookie remembered");

			createCookie(username, password, response);
			createSession(request, username);

			request.getRequestDispatcher("DisplayProductServlet").forward(request, response);

		} else if (validUser(username, password)) {
			System.out.println("cookie doesnt remembered");

			createSession(request, username);

			request.getRequestDispatcher("DisplayProductServlet").forward(request, response);

		} else {
			// for wrong users
			response.sendRedirect("LoginPage.html");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("---->> 1. inside doGet of Home servlet");

		// check for cookies
		Cookie arr[] = request.getCookies();

		if (arr != null) {
			System.out.println("cookie used");
			String uname = null;
			String pass = null;
			for (Cookie cookie : arr) {
				Cookie c = cookie;

				if (c.getName().equals("username")) {
					uname = c.getValue();
				}
				if (c.getName().equals("password")) {
					pass = c.getValue();
				}

			}
			System.out.println("asd");
			if (validUser(uname, pass)) {
				System.out.println("asdasda");
				createSession(request, uname);
				request.getRequestDispatcher("DisplayProductServlet").forward(request, response);
				
			} else {
				response.sendRedirect("LoginPage.html");
			}

		} else {
			response.sendRedirect("LoginPage.html");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---->> 1. inside dopost of Home Servlet");
		doThings(request, response);

	}

}
