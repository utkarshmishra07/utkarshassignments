package com.mphasis.demo.bo;

import java.util.List;

import com.mphasis.demo.entities.Student;

public interface StudentBo {
	
	public List<Student> getStudents();
	public Student getStudentById(int id);
	public void addStudent(Student student);
	public void editStudent(Student student);
	public void removeStudent(int id);
}
