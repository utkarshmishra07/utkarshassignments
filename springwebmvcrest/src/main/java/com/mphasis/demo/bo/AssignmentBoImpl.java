package com.mphasis.demo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.demo.dao.AssignmentDao;
import com.mphasis.demo.entities.Assignment;
import com.mphasis.demo.exceptions.BusinessException;

@Service
public class AssignmentBoImpl implements AssignmentBo {
	
	@Autowired
	AssignmentDao assignmentDao;
	
	public List<Assignment> getAssignments() {
		List<Assignment> assignments=assignmentDao.getAssignments();
		if(assignments.isEmpty()) {
			try {
				throw new BusinessException("No Assignment");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return assignments;
	}

	public Assignment getAssignmentById(int id) {
		
		return assignmentDao.getAssignmentById(id);
	}

	public void insertAssignment(Assignment assignment) {
		if(assignment.getGrade()>60) {
			assignmentDao.insertAssignment(assignment);
		}else {
			throw new BusinessException("Aur mehnat karo");
		}
		
	}

	public void updateAssignment(Assignment assignment) {
		if(assignment.getGrade()>60) {
			assignmentDao.updateAssignment(assignment);
		}else {
			throw new BusinessException("Aur mehnat karo");
		}
		
		
	}

	public void deleteAssignment(int id) {
		
			assignmentDao.deleteAssignment(id);

	}
}
