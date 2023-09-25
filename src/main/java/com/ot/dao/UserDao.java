package com.ot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ot.dto.User;

public class UserDao {

	public void saveUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		System.out.println("User Saved.");
	}

	public void getUserById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("NULL");
		}
	}

	@SuppressWarnings("unchecked")
	public User getValidateUserByEmailAndPassword(String email, String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select u from User u where u.email=?1 and u.password=?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> list = query.getResultList();
		if (list.size() > 0) {
			for (User user : list) {
				return user;
			}
		}
		return null;
	}

	public void deleteUserById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			System.out.println("Deleted.");
		} else {
			System.out.println("User Id Is Not Available.");
		}
	}

	public void updateUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		User user1 = entityManager.find(User.class, user.getId());
		if (user1 != null) {
			entityTransaction.begin();
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setPhoneNumber(user.getPhoneNumber());
			user1.setRole_ADMIN(user.getRole_ADMIN());
			entityTransaction.commit();
			System.out.println("Updated Successfully.");
		} else {

		}
	}
}
