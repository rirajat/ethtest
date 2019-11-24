package com.ethocaTest.service;

import java.util.List;

import com.ethocaTest.model.*;

public interface IShoppingCart {
	ShoppingCart find(int id);
	ShoppingCart create(ShoppingCart cart);
	ShoppingCart add(int id, LineItem item);
	ShoppingCart update(int id, LineItem item);
	boolean remove(int id, int itemId);
}
