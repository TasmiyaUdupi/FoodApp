package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.CustomerDao;

public class TestGetCustmerById {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Custmer Id :");
		int id = sc.nextInt();
		CustomerDao customerDao = new CustomerDao();
		System.out.println(customerDao.getCustomerById(id));
		sc.close();
	}
}
