package com.ot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private double qauntity;
	private double cost;

	@ManyToOne
	@JoinColumn
	private FoodOrder foodOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQauntity() {
		return qauntity;
	}

	public void setQauntity(double qauntity) {
		this.qauntity = qauntity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", name=" + name + ", qauntity=" + qauntity + ", cost=" + cost + "]";
	}

}