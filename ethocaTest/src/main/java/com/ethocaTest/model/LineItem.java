package com.ethocaTest.model;

public abstract class LineItem {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract Product getProduct();

	public abstract void setProduct(Product product);

	public abstract int getQuentity();

	public abstract void setQuentity(int quentity);
}
