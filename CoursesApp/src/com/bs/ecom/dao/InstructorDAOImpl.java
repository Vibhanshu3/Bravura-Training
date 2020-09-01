package com.bs.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bs.ecom.beans.Instructor;
import com.bs.ecom.beans.InstructorCourseInfo;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public class InstructorDAOImpl implements InstructorDAO {

	Connection con;
	PreparedStatement ps;

	public InstructorDAOImpl() throws ClassNotFoundException, SQLException {
		con = DAOUtil.getConnection();
	}

	@Override
	public List<Instructor> validateInstructor(int instructorCode, String instructorName) throws SQLException {
		String query = "select * from instructor where instructorcode = ? and name = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, instructorCode);
		ps.setString(2, instructorName);

		ResultSet rs = ps.executeQuery();

		List<Instructor> instructor = new ArrayList<>();

		if (rs.next()) {
			int code = rs.getInt(1);
			String name = rs.getString(2);
			int salary = rs.getInt(3);
			int year = rs.getInt(4);

			instructor.add(new Instructor(code, name, salary, year));
			return instructor;

		} else {
			return instructor;

		}
	}

	@Override
	public List<InstructorCourseInfo> getCourses(int instructorCode) throws SQLException {
		String query = "select * from instructorcourseinfo where instructorcode = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, instructorCode);

		ResultSet rs = ps.executeQuery();

		List<InstructorCourseInfo> courses = new ArrayList<>();

		while(rs.next()) {
			int icinfoid = rs.getInt(1);
			String coursename = rs.getString(2);
			int iccode = rs.getInt(3);
			
			courses.add(new InstructorCourseInfo(icinfoid, coursename, iccode));
		}
		
		return courses;
		
	}
}
