package com.bs.ecom.beans;

public class Instructor {
	private int instructor;
	private String name;
	private int salary;
	private int jobStartYear;
	
	public Instructor() {
		super();
	}

	public Instructor(int instructor, String name, int salary, int jobStartYear) {
		super();
		this.instructor = instructor;
		this.name = name;
		this.salary = salary;
		this.jobStartYear = jobStartYear;
	}

	public int getInstructor() {
		return instructor;
	}

	public void setInstructor(int instructor) {
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getJobStartYear() {
		return jobStartYear;
	}

	public void setJobStartYear(int jobStartYear) {
		this.jobStartYear = jobStartYear;
	}

}
