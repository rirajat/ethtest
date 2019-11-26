package com.ethocaTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethocaTest.model.Order;
import com.ethocaTest.model.ShoppingCart;
import com.ethocaTest.model.webRequest.ShoppingCartReq;
import com.ethocaTest.service.IOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/order")
@Api(tags = {"order"})
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get a Order.", notes = "Not Impleted.")
	public Order get(@PathVariable int id) {
		return orderService.find(id);
	}
}
