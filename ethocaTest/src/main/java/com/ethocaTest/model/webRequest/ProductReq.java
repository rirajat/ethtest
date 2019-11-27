package com.ethocaTest.model.webRequest;

import com.ethocaTest.model.Product;

public class ProductReq extends Product {
	private Integer id;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
