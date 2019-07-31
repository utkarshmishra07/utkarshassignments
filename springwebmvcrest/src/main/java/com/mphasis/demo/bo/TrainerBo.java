package com.mphasis.demo.bo;

import java.util.List;

import com.mphasis.demo.entities.Trainer;

public interface TrainerBo {
	public List<Trainer> getTrainers();
	public Trainer getTrainerById(int id);
	public void addTrainer(Trainer trainer);
	public void editTrainer(Trainer trainer);
	public void removeTrainer(int id);
}
