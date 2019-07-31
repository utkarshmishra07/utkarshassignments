package com.mphasis.demo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.demo.dao.TrainerDao;
import com.mphasis.demo.entities.Trainer;
import com.mphasis.demo.exceptions.BusinessException;

@Service
public class TrainerBoImpl implements TrainerBo {
	
	@Autowired
	TrainerDao trainerDao;
	
	public List<Trainer> getTrainers() {
		List<Trainer> trainers=trainerDao.getTrainers();
		if(trainers.isEmpty()) {
			try {
				throw new BusinessException("No Trainer");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return trainers;
	}

	public Trainer getTrainerById(int id) {
		return trainerDao.getTrainerById(id);
	}

	public void addTrainer(Trainer trainer) {
		trainerDao.insertTrainer(trainer);
		
	}

	public void editTrainer(Trainer trainer) {
		trainerDao.updateTrainer(trainer);
		
	}

	public void removeTrainer(int id) {
		trainerDao.deleteTrainer(id);
		
	}


}
