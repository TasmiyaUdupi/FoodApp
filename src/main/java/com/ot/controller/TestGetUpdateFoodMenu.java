package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.FoodMenuDao;
import com.ot.dto.FoodMenu;

public class TestGetUpdateFoodMenu {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Food Menu Id :");
		int id = sc.nextInt();
		System.out.println("Enter Food Cost :");
		double cost = sc.nextDouble();
		System.out.println("Enter Food Description :");
		String description = sc.next();
		System.out.println("Enter Food Name :");
		String name = sc.next();

		FoodMenu foodMenu = new FoodMenu();
		foodMenu.setId(id);
		foodMenu.setCost(cost);
		
		foodMenu.setName(name);
		foodMenu.setDescription(description);

		FoodMenuDao foodMenuDao = new FoodMenuDao();
		foodMenuDao.getUpdateFoodMenu(foodMenu);
		sc.close();
	}
}
