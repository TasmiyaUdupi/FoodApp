package com.ot.controller;

import java.util.Scanner;

import com.ot.dao.FoodMenuDao;
import com.ot.dto.FoodMenu;

public class TestSaveFoodMenu {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Food Name :");
		String name = sc.next();
		System.out.println("Enter Food Description :");
		String description = sc.next();
		System.out.println("Enter Food Cost :");
		double foodcost = sc.nextDouble();

		FoodMenu foodMenu = new FoodMenu();
		foodMenu.setName(name);
		foodMenu.setDescription(description);
		foodMenu.setCost(foodcost);

		FoodMenuDao foodMenuDao = new FoodMenuDao();
		foodMenuDao.saveFoodMenu(foodMenu);
		sc.close();
	}
}
