package com.ot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ot.dao.CustomerDao;
import com.ot.dao.FoodMenuDao;
import com.ot.dao.FoodOrderDao;
import com.ot.dto.FoodMenu;
import com.ot.dto.FoodOrder;
import com.ot.dto.OrderItems;

public class TestSaveFoodOrder {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		FoodOrder foodOrder = new FoodOrder();

		System.out.println("Enter Customer Id :");
		int id = scanner.nextInt();
		foodOrder.setCustomer(new CustomerDao().getCustomerById(id));

		boolean loop = true;

		List<OrderItems> items = new ArrayList<OrderItems>();
		double foodOrderCost = 0;

		TestGetAllFoodMenu.main(args);

		while (loop) {
			System.out.println("Press 1 : Select Food Items");
			System.out.println("Press 2 : Exit");
			int choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Enter The Food Id");
				int foodId = scanner.nextInt();
				System.out.println("Enter the Food Quantity");
				double quantity = scanner.nextDouble();

				FoodMenu foodMenu = new FoodMenuDao().getFoodMenuById(foodId);
				OrderItems orderItems = new OrderItems();
				orderItems.setCost(foodMenu.getCost());
				double cost = foodMenu.getCost();
				foodOrderCost += cost * quantity;
				orderItems.setCost(cost);
				orderItems.setName(foodMenu.getName());
				orderItems.setQauntity(quantity);
				orderItems.setFoodOrder(foodOrder);
				items.add(orderItems);
			} else {
				loop = false;
			}
		}

		foodOrder.setOrderItems(items);
		foodOrder.setStatus(true);
		foodOrder.setCost(foodOrderCost);

		FoodOrderDao foodOrderDao = new FoodOrderDao();
		foodOrderDao.saveFoodOrder(foodOrder);
		System.out.println("Food Order Is Saved For Customer Id " + id);
		scanner.close();
	}
}
