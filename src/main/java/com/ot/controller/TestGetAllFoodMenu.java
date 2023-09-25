package com.ot.controller;

import com.ot.dao.FoodMenuDao;

public class TestGetAllFoodMenu {
	public static void main(String[] args) {

		FoodMenuDao foodMenuDao = new FoodMenuDao();
		foodMenuDao.getAllFoodMenu();
	}
}
