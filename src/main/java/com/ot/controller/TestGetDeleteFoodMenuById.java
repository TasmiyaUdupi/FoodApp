package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.FoodMenuDao;

public class TestGetDeleteFoodMenuById {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter FoodMenu Id :");
		int id = sc.nextInt();

		FoodMenuDao foodMenuDao = new FoodMenuDao();
		foodMenuDao.getDeleteFoodMenuById(id);
		sc.close();
	}
}
