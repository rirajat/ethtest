package com.ethocaTest.service;

import java.util.List;

import com.ethocaTest.model.Payment;

public interface IPaymentService {
	List<Payment> getPayments(int orderId);
	void save(Payment payment);
}
