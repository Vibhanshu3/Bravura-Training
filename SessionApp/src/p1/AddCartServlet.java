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

public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doThings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in add car servlet");
		
		HttpSession session = request.getSession(false);
		String productName = request.getParameter("pname");

		Product p = MyDatabase.getProductByName(productName);

		if (session != null) {

			List<Product> cartList = (List<Product>) session.getAttribute("cart");
			cartList.add(p);
			System.out.println(" ---->> Product " + p + " added in CartList ");
			response.sendRedirect("DisplayProductServlet");

		} else {
			response.sendRedirect("LoginPage.html");
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doThings(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
