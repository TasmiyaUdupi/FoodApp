package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.CustomerDao;
import com.ot.dto.Customer;

public class TestSaveCustomer {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Customer Name :");
		String name=sc.next();
		System.out.println("Enter Customer E-mail :");
		String email=sc.next();
		System.out.println("Enter Customer Phone Number :");
		long phoneNumber=sc.nextLong();
		
		Customer customer=new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		
		CustomerDao customerDao=new CustomerDao();
		customerDao.saveCustomer(customer);
		sc.close();
	}
}
