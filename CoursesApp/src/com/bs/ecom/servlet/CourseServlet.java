package com.bs.ecom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.ecom.beans.InstructorCourseInfo;

public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CourseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(" inside CourseServlet");
		
		List<InstructorCourseInfo> courseList = (List<InstructorCourseInfo>) request.getAttribute("course_list");
		String inname = (String)request.getAttribute("instructor_name");
		
		PrintWriter out = response.getWriter();
		out.write("<b> Instructor Name " + inname + "</b><br/>");

		Iterator<InstructorCourseInfo> iterator = courseList.iterator();
		while (iterator.hasNext()) {
			InstructorCourseInfo course = iterator.next();
			String courseName = course.getCourseName();
			int instructorCode = course.getInstructorCode();
			int instructorInfoId = course.getIcInfoId();

			out.write("<b> Course " + courseName + "</b><br/>");
			out.write("<b> Instructor code: " + instructorCode + "</b><br/>");
			out.write("<b> Instructor info ID" + instructorInfoId + "</b><br/><br/>");

		}

	}

}
