package com.mphasis.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.demo.bo.TrainerBo;
import com.mphasis.demo.entities.Trainer;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	TrainerBo trainerBo;
	
	@RequestMapping(value="/trainers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Trainer> getAll(){
		return trainerBo.getTrainers();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void addTrainer(@RequestBody Trainer trainer){
		trainerBo.addTrainer(trainer);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateTrainer(@RequestBody Trainer trainer){
		Trainer st= trainerBo.getTrainerById(trainer.getId());
		if(st!=null)
			trainerBo.editTrainer(trainer);
		else
			trainerBo.addTrainer(trainer);
	}
	
	@RequestMapping(value="/add/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteTrainer(@PathVariable("id")int id){
			trainerBo.removeTrainer(id);
	}
	
	@RequestMapping(value="/trainer/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Trainer
	getTrainer(@PathVariable("id")int id){
		return trainerBo.getTrainerById(id);
	}
}
