package com.ethocaTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ethocaTest.model.Product;
import com.ethocaTest.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping(produces = {"application/json"})
	public List<Product> getAllProducts() {
		return productService.findAll();
	}
}
