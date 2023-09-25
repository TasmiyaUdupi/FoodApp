package com.ot.controller;

import com.ot.dao.CustomerDao;

public class TestGetAllCustomer {
	public static void main(String[] args) {

		CustomerDao customerDao=new CustomerDao();
		customerDao.getAllCustomer();
	}
}
