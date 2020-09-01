package com.bs.ecom.beans;

public class InstructorCourseInfo {
	@Override
	public String toString() {
		return "InstructorCourseInfo [icInfoId=" + icInfoId + ", courseName=" + courseName + ", instructorCode="
				+ instructorCode + "]";
	}

	private int icInfoId;
	private String courseName;
	private int instructorCode;

	public InstructorCourseInfo() {
		super();
	}

	public InstructorCourseInfo(int icInfoId, String courseName, int instructorCode) {
		super();
		this.icInfoId = icInfoId;
		this.courseName = courseName;
		this.instructorCode = instructorCode;
	}

	public int getIcInfoId() {
		return icInfoId;
	}

	public void setIcInfoId(int icInfoId) {
		this.icInfoId = icInfoId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getInstructorCode() {
		return instructorCode;
	}

	public void setInstructorCode(int instructorCode) {
		this.instructorCode = instructorCode;
	}

}
