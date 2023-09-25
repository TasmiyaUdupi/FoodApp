package com.ot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ot.dto.FoodMenu;

public class FoodMenuDao {

	public void saveFoodMenu(FoodMenu foodMenu) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodMenu);
		entityTransaction.commit();
		System.out.println("Saved.");
	}

	@SuppressWarnings("unchecked")
	public void getAllFoodMenu() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select f from FoodMenu f";
		Query query = entityManager.createQuery(jpql);
		List<FoodMenu> list = query.getResultList();
		if (list.size() > 0) {
			for (FoodMenu foodMenu : list) {
				System.out.println(foodMenu);
			}
		}
	}

	public FoodMenu getFoodMenuById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		FoodMenu foodMenu = entityManager.find(FoodMenu.class, id);
		if (foodMenu != null) {
			System.out.println(foodMenu);
			return foodMenu;
		} else {
			System.out.println("Invalid FoodMenu Id.");
			return null;
		}
	}

	public void getDeleteFoodMenuById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		FoodMenu foodMenu = entityManager.find(FoodMenu.class, id);
		if (foodMenu != null) {
			entityTransaction.begin();
			entityManager.remove(foodMenu);
			entityTransaction.commit();
			System.out.println("Deleted.");
		} else {
			System.out.println("Invalid FoodMenu Id.");
		}
	}

	public void getUpdateFoodMenu(FoodMenu foodMenu) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		FoodMenu foodMenu1 = entityManager.find(FoodMenu.class, foodMenu.getId());
		if (foodMenu1 != null) {
			entityTransaction.begin();
			foodMenu1.setCost(foodMenu.getCost());
			foodMenu1.setName(foodMenu.getName());
			foodMenu1.setDescription(foodMenu.getDescription());
			entityTransaction.commit();
			System.out.println("Updated Successfully.");
		} else {
			System.out.println("Invalid Food-Menu Id.");
		}
	}

}
