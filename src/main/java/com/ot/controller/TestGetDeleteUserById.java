package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.UserDao;

public class TestGetDeleteUserById {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Id To Be Delete :");
		int id=sc.nextInt();
		UserDao userDao=new UserDao();
		userDao.deleteUserById(id);
		sc.close();
	}
}
