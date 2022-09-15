package com.fujitsu.model;

import java.sql.Date;

public class Student{
	private int studentId;
	private String studentName;
	private int studentAge;

	public Student() {
	}

	private Date studentDOB;

	public void setStudentName(String studentName){
		this.studentName = studentName;
	}

	public String getStudentName(){
		return studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public Student(String studentName, int studentAge) {
		this.studentName = studentName;
		this.studentAge = studentAge;
		//this.studentDOB = studentDOB;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
}