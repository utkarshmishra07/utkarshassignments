package com.mphasis.demo.dao;

import java.util.List;

import com.mphasis.demo.entities.Assignment;

public interface AssignmentDao {
	
	public List<Assignment> getAssignments();
	public Assignment getAssignmentById(int id);
	public void insertAssignment(Assignment assignment);
	public void updateAssignment(Assignment assignment);
	public void deleteAssignment(int id);
	
}
