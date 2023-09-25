package com.ot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ot.dto.Customer;

public class CustomerDao {

	public void saveCustomer(Customer customer) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		System.out.println("Saved.");
	}

	public Customer getCustomerById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public void getAllCustomer() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select c from Customer c";
		Query query = entityManager.createQuery(jpql);
		List<Customer> list = query.getResultList();
		if (list.size() > 0) {
			for (Customer customer : list) {
				System.out.println(customer);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void getCustomerByEmail(String email) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select c from Customer c where c.email=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		List<Customer> list = query.getResultList();
		if (list.size() > 0) {
			System.out.println(list);
		} else {
			System.out.println("NULL");
		}
	}

	@SuppressWarnings("unchecked")
	public void getCustomerByPhoneNumber(long phoneNumber) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select c from Customer c where c.phoneNumber=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, phoneNumber);
		List<Customer> list = query.getResultList();
		if (list.size() > 0) {
			System.out.println(list);
		} else {
			System.out.println("NULL");
		}
	}

	public void getDeleteById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.remove(customer);
			entityTransaction.commit();
			System.out.println("Deleted.");
		} else {
			System.out.println("Customer Id Is Not Available.");
		}
	}

	public void getUpdateCustomerById(Customer customer) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Customer customer1 = entityManager.find(Customer.class, customer.getId());
		if (customer1 != null) {
			entityTransaction.begin();
			customer1.setEmail(customer.getEmail());
			customer1.setName(customer.getName());
			customer1.setPhoneNumber(customer.getPhoneNumber());
			entityTransaction.commit();
			System.out.println("Updated Successfully.");
		} else {
			System.out.println("Invalid Customer Id.");
		}
	}
}
