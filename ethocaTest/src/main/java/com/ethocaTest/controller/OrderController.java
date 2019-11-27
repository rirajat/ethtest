package com.ethocaTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethocaTest.model.Order;
import com.ethocaTest.service.IOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/order")
@Api(tags = { "order" })
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@GetMapping("/{id}")
	@ApiOperation(value = "Get an Order.")
	public Order get(@PathVariable int id) {
		return orderService.find(id);
	}
}
