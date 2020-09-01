package com.bs.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.bs.ecom.beans.Instructor;
import com.bs.ecom.beans.InstructorCourseInfo;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public interface InstructorDAO {

	public List<Instructor> validateInstructor(int instructorCode, String instructorName) throws SQLException;

	public List<InstructorCourseInfo> getCourses(int instructorCode) throws SQLException;
}
