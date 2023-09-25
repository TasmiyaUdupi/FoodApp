package com.ot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ot.dto.FoodOrder;

public class FoodOrderDao {

	public void saveFoodOrder(FoodOrder foodOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		System.out.println("Saved.");
	}
}
