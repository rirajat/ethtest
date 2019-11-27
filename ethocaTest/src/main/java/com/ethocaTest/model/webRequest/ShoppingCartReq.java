package com.ethocaTest.model.webRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.ShoppingCart;

public class ShoppingCartReq extends ShoppingCart {

	private Integer id;
	private List<LineItemReq> lineItems;
	private Date created;

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	@Override
	public List<LineItem> getItems() {
		return new ArrayList<LineItem>(this.lineItems);
	}

	@Override
	public void setItems(List<LineItem> items) {
		this.lineItems = new ArrayList<LineItemReq>();
		for (int i = 0; i < items.size(); i++) {
			this.lineItems.add((LineItemReq) items.get(i));
		}
	}

	@Override
	public Date getCreated() {
		return this.created;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;

	}

}
