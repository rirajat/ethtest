package com.ethocaTest.service;

import com.ethocaTest.model.Order;
import com.ethocaTest.model.ShoppingCart;

public interface IOrderService {

	Order save(ShoppingCart cart);

	Order getOrder(int id);

}
