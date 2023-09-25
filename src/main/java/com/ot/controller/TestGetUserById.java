package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.UserDao;

public class TestGetUserById {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id :");
		int id = sc.nextInt();
		UserDao userDao = new UserDao();
		userDao.getUserById(id);
		sc.close();
	}
}
