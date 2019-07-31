package com.mphasis.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.demo.entities.Trainer;

@Repository
public class TrainerDaoImpl implements TrainerDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<Trainer> getTrainers() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List <Trainer> trainers=session.createCriteria(Trainer.class).list(); 
		return trainers;
	}

	public Trainer getTrainerById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Trainer tt= (Trainer) session.get(Trainer.class, id);
		tr.commit();

		return tt;
	}

	public void insertTrainer(Trainer trainer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(trainer);
		tr.commit();
		
	}

	public void updateTrainer(Trainer trainer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(trainer);
		tr.commit();
		
	}

	public void deleteTrainer(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Trainer tt= (Trainer) session.get(Trainer.class, id);
		session.delete(tt);
		tr.commit();
		
	}

}
