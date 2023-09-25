package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.CustomerDao;

public class TestGetDeleteCustomerById {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Id :");
		int id = sc.nextInt();

		CustomerDao customerDao = new CustomerDao();
		customerDao.getDeleteById(id);
		sc.close();
	}
}
