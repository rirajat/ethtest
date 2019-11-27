package com.ethocaTest.service;

import com.ethocaTest.model.Order;

public interface IOrderService {
	Order save(int cartId);

	Order find(int id);
}
