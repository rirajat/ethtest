package com.ethocaTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Columns;

public abstract class Product {
	
	public abstract  int getId();
	public abstract  double getPrice();
	public abstract  String getName();
	public abstract  String getDescription();
}
