package p1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import db.MyDatabase;

public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doThings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in remove cart servlet");
		
		HttpSession session = request.getSession(false);
		

		if (session != null) {
			String productName = (String)request.getParameter("pname");
			System.out.println(productName);
			Product p = MyDatabase.getProductByName(productName);
			
			List<Product> cartList = (List<Product>) session.getAttribute("cart");
			cartList.remove(p);
			System.out.println(" ---->> Product " + p + " removed from CartList ");
			response.sendRedirect("ViewCartServlet");

		} else {
			response.sendRedirect("LoginPage.html");

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doThings(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);

	}

}
