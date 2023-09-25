package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.CustomerDao;
import com.ot.dto.Customer;

public class TestGetUpdateCustomerById {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Id :");
		int id = sc.nextInt();
		System.out.println("Enter Customer E-mail :");
		String email = sc.next();
		System.out.println("Enter Customer Name :");
		String name = sc.next();
		System.out.println("Enter Customer Phone Number :");
		long phoneNumber = sc.nextLong();

		Customer customer = new Customer();
		customer.setId(id);
		customer.setEmail(email);
		customer.setName(name);
		customer.setPhoneNumber(phoneNumber);

		CustomerDao customerDao = new CustomerDao();
		customerDao.getUpdateCustomerById(customer);
		sc.close();
	}
}
