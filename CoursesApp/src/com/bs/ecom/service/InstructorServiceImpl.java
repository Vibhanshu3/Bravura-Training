package com.bs.ecom.service;

import java.sql.SQLException;
import java.util.List;

import com.bs.ecom.beans.Instructor;
import com.bs.ecom.beans.InstructorCourseInfo;
import com.bs.ecom.dao.InstructorDAO;
import com.bs.ecom.dao.InstructorDAOImpl;
import com.bs.ecom.dao.UserDAO;
import com.bs.ecom.dao.UserDAOImpl;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.dao.ProductDAO;
import Day9.com.bs.ecom.dao.ProductDAOImpl;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public class InstructorServiceImpl implements InstructorService {
	
	InstructorDAO instructorDAO;
	
	public InstructorServiceImpl() throws ClassNotFoundException, SQLException {
		instructorDAO = new InstructorDAOImpl();
	}

	@Override
	public List<Instructor> validateInstructor(int instructorCode, String instructorName) throws SQLException {
		return instructorDAO.validateInstructor(instructorCode, instructorName);
	}

	@Override
	public List<InstructorCourseInfo> getCourses(int instructorCode) throws SQLException {
		return instructorDAO.getCourses(instructorCode);
	}

}
