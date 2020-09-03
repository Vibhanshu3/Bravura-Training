package p2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import db.MyDatabase;

public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayProductServlet() {
		super();
	}

	protected void doThings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in display product servlet");

		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		System.out.println(session);
		
		if (session != null) {
			String username = (String) session.getAttribute("username");

			List<Product> cartList = (List<Product>) session.getAttribute("cart");

			int cartSize = cartList.size();
			System.out.println(cartSize);

			List<Product> allProducts = new ArrayList<>();
			List<Product> listProducts = MyDatabase.getProductsByKeyword("Laptop");
			List<Product> listProducts2 = MyDatabase.getProductsByKeyword("Watch");

			allProducts.addAll(listProducts);
			allProducts.addAll(listProducts2);

			Iterator<Product> itr = allProducts.iterator();

			out.print("<HTML><BODY>");
			out.print("Welcome " + username + "<br/>");
			out.print("<hr/>");
			out.print("<b> Cart " + cartSize + "</b>");
			out.print("<hr/>");

			while (itr.hasNext()) {
				Product p = itr.next();
				out.print(p.getProductName() + " - " + p.getCost() + "<a href='AddCartServlet?pname="
						+ p.getProductName() + "'> Add to Cart </a>");
				out.print("<br/>");
			}

			out.print("<a href='ViewCartServlet'> Go to Cart </a>");

			out.print("</BODY></HTML>");

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
		doThings(request, response);
	}

}
