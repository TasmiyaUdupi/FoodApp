package com.ot.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ot.dto.User;

public class TestGetAllUser {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select u from User u";
		Query query = entityManager.createQuery(jpql);
		List<User> list = query.getResultList();
		if (list.size() > 0) {
			for (User user : list) {
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println(user.getPhoneNumber());
				System.out.println(user.getRole_ADMIN());
			}
		}
	}
}
