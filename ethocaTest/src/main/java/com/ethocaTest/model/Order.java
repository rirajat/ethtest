package com.ethocaTest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public abstract  class Order {

	public abstract  int getId();
	public abstract  void setId(int id);
	public abstract  List<LineItem> getItems();
	public abstract  void setItems(List<LineItem> items);
	public abstract  Date getCreated();
	public abstract  void setCreated(Date created);
	
}
