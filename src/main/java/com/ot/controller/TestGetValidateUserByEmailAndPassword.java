package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.UserDao;
import com.ot.dto.User;

public class TestGetValidateUserByEmailAndPassword {
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter User E-mail :");
		String email=sc.next();
		System.out.println("Enter User Password :");
		String password=sc.next();
		
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDao userDao=new UserDao();
		
		System.out.println(userDao.getValidateUserByEmailAndPassword(email, password));
		sc.close();
	}
}
