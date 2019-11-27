package com.ethocaTest.model;

import java.util.Date;
import java.util.List;

public abstract class ShoppingCart {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract List<LineItem> getItems();

	public abstract void setItems(List<LineItem> items);

	public abstract Date getCreated();

	public abstract void setCreated(Date created);

}
