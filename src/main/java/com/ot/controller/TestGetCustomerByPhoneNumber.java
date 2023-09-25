package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.CustomerDao;

public class TestGetCustomerByPhoneNumber {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Customer Phone Number :");
		long phoneNumber=sc.nextLong();
		
		CustomerDao customerDao=new CustomerDao();
		customerDao.getCustomerByPhoneNumber(phoneNumber);
		sc.close();
	}
}
