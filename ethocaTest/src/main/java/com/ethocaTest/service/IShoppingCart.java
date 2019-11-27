package com.ethocaTest.service;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.ShoppingCart;

public interface IShoppingCart {
	ShoppingCart find(int id);

	ShoppingCart create(ShoppingCart cart);

	ShoppingCart add(int id, LineItem item);

	ShoppingCart update(int id, LineItem item);

	void remove(int id, int itemId);
}
