package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import db.MyDatabase;

public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCartServlet() {
		super();
	}

	protected void doThings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		if (session != null) {

			List<Product> cartList = (List<Product>) session.getAttribute("cart");
			Iterator<Product> iterator = cartList.iterator();
			out.print("<HTML><BODY>");
			System.out.println(cartList.size());
			
			out.print("<ul>");
			while (iterator.hasNext()) {
				Product p = iterator.next();
				String productName = p.getProductName();
				out.print("<li>");
				out.print(productName);
				out.print(p.getCost());
				out.print("<a href='RemoveCartServlet?pname=" + productName + "'>Remove from cart</a>");
				out.print("</li>");

			}
			out.print("</ul>");
			out.print("<a href='DisplayProductServlet'>Return to home page</a>");
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
		doGet(request, response);
	}

}
