package com.mphasis.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.demo.bo.AssignmentBo;
import com.mphasis.demo.entities.Assignment;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	
	@Autowired
	AssignmentBo assignmentBo;
	
	@RequestMapping(value="/assignments", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Assignment> getAll(){
		return assignmentBo.getAssignments();
	}
	@RequestMapping(value="/add", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void addAssignment(@RequestBody Assignment assignment){
		assignmentBo.insertAssignment(assignment);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateAssignment(@RequestBody Assignment assignment){
		Assignment st= assignmentBo.getAssignmentById(assignment.getId());
		if(st!=null)
			assignmentBo.updateAssignment(assignment);
		else
			assignmentBo.insertAssignment(assignment);
	}
	
	@RequestMapping(value="/add/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteAssignment(@PathVariable("id")int id){
			assignmentBo.deleteAssignment(id);
	}
	
	@RequestMapping(value="/assignment/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Assignment getAssignment(@PathVariable("id")int id){
		return assignmentBo.getAssignmentById(id);
	}
}
