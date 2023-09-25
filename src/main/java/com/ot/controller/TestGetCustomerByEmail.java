package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.CustomerDao;

public class TestGetCustomerByEmail {
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Customer E-mail :");
		String email=sc.next();
		
		CustomerDao customerDao=new CustomerDao();
		customerDao.getCustomerByEmail(email);
		sc.close();
	}
}
