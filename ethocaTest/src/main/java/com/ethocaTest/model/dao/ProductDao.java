package com.ethocaTest.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ethocaTest.model.Product;

@Entity
@Table(name = "product")
public class ProductDao extends Product {
	@Id
	private Integer id;
	@Column
	private double price;
	@Column
	private String name;
	@Column
	private String description;

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
