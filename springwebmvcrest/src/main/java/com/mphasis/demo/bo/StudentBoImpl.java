package com.mphasis.demo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.demo.dao.StudentDao;
import com.mphasis.demo.entities.Student;
import com.mphasis.demo.exceptions.BusinessException;

@Service
public class StudentBoImpl implements StudentBo {
	
	@Autowired
	StudentDao studentDao;
	
	public List<Student> getStudents() {
		List<Student> students=studentDao.getStudents();
		if(students.isEmpty()) {
			try {
				throw new BusinessException("No Student");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return students;
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	public void addStudent(Student student) {
		studentDao.insertStudent(student);
	}

	public void editStudent(Student student) {
		studentDao.updateStudent(student);

	}

	public void removeStudent(int id) {
		studentDao.deleteStudent(id);

	}

}
