package com.bs.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.ecom.beans.Instructor;
import com.bs.ecom.beans.InstructorCourseInfo;
import com.bs.ecom.service.InstructorService;
import com.bs.ecom.service.InstructorServiceImpl;
import com.bs.ecom.service.UserService;
import com.bs.ecom.service.UserServiceImpl;

public class InstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	InstructorService instructorService;

	public void init() throws ServletException {
		try {
			instructorService = new InstructorServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		int instructorCode = Integer.parseInt(request.getParameter("incode"));
		String instructorName = request.getParameter("inname");

		try {
			List<Instructor> instructor = instructorService.validateInstructor(instructorCode, instructorName);
			if (instructor.size() != 0) {
				// valid instructor
				int incode = instructor.get(0).getInstructor();
				String inname = instructor.get(0).getName();
				
				System.out.println(inname + " and " + incode);

				List<InstructorCourseInfo> courseList = instructorService.getCourses(instructorCode);
				
				request.setAttribute("instructor_name", inname);
				request.setAttribute("course_list", courseList);

				RequestDispatcher rd = request.getRequestDispatcher("course-servlet");
				rd.forward(request, response);

			} else {
				//invalid instructor
				response.sendRedirect("ValidateInstructor.html");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
