package com.ethocaTest.service;

import com.ethocaTest.model.Order;
import com.ethocaTest.model.ShoppingCart;

public interface IOrderService {
	Order save(int cartId);
	Order find(int id);
}
