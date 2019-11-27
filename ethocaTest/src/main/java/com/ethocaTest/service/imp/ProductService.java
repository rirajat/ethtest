package com.ethocaTest.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethocaTest.model.Product;
import com.ethocaTest.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductDbService dao;
	
	public List<Product> findAll() {
		return new ArrayList<Product>(dao.findAll());
	}

}
