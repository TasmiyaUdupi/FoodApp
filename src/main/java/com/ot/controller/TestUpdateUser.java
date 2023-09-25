package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.UserDao;
import com.ot.dto.User;

public class TestUpdateUser {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Id : ");
		int id=sc.nextInt();
		System.out.println("Enter User Name :");
		String name = sc.next();
		System.out.println("Enter User E-mail :");
		String email = sc.next();
		System.out.println("Enter User Phone Number :");
		long phoneNumber = sc.nextLong();
		System.out.println("Enter User Password:");
		String password = sc.next();
		System.out.println("Enter User Role");
		String role = sc.next();

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(password);
		user.setRole_ADMIN(role);
		
		UserDao userDao=new UserDao();
		userDao.updateUser(user);
		sc.close();
	}
}
