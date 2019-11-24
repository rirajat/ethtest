package com.ethocaTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.ShoppingCart;
import com.ethocaTest.model.webRequest.LineItemReq;
import com.ethocaTest.model.webRequest.ProductReq;
import com.ethocaTest.model.webRequest.ShoppingCartReq;
import com.ethocaTest.service.IShoppingCart;
import com.ethocaTest.service.imp.ShoppingCartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/shopping")
@Api(tags = {"shopping cart"})
public class ShoppingCartController {
	@Autowired
	private IShoppingCart shoppingCart;

	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a shopping cart.")
	public int create(@RequestBody ShoppingCartReq cart) {
		ShoppingCart s = shoppingCart.create(cart);
		return s.getId();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get shopping cart by id.")
	public ShoppingCart getShoppingCart(@PathVariable int id) {
		return shoppingCart.find(id);
	}
	
	@PutMapping(value = "/{id}/item", consumes={MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Add an item to shopping cart.")
	public void addToShoppingCart(@PathVariable int id,
			@RequestBody LineItemReq item) {
		shoppingCart.add(id, item);
	}
	
	@DeleteMapping("/{id}/item/{itemId}")
	@ApiOperation(value = "Delete an item from shopping cart.")
	public void deletItem(@PathVariable int id,
			@PathVariable int itemId) {
		shoppingCart.remove(id, itemId);
	}
	
	@PatchMapping("/{id}/item/{itemId}")
	@ApiOperation(value = "Update an item in shopping cart.")
	public void updateShoppingCart(@PathVariable int id, @PathVariable int itemId,
			@RequestBody LineItemReq item) {
		item.setId(itemId);
		shoppingCart.update(id, item);
	}
}
