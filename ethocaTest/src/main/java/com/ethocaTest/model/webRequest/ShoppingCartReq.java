package com.ethocaTest.model.webRequest;

import java.util.Date;
import java.util.List;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.ShoppingCart;

public class ShoppingCartReq extends ShoppingCart{

	private Date created;
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LineItem> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItems(List<LineItem> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getCreated() {
		return this.created;
	}

	@Override
	public void setCreated(Date created) {
		this.created=created;
		
	}

}
