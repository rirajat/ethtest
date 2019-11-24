package com.ethocaTest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public abstract class LineItem {

	public abstract  int getId();
	public abstract  void setId(int id);
	public abstract  Product getProduct();
	public abstract  void setProduct(Product product);
	public abstract  int getQuentity();
	public abstract  void setQuentity(int quentity);
}
