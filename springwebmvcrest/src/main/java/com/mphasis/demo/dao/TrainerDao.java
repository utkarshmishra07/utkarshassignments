package com.mphasis.demo.dao;

import java.util.List;

import com.mphasis.demo.entities.Trainer;

public interface TrainerDao {
	public List<Trainer> getTrainers();
	public Trainer getTrainerById(int id);
	public void insertTrainer(Trainer trainer);
	public void updateTrainer(Trainer trainer);
	public void deleteTrainer(int id);
}
