package com.ethocaTest.service.imp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ethocaTest.model.Product;
import com.ethocaTest.model.dao.ProductDao;
import com.ethocaTest.service.IProductService;

public interface ProductDbService extends JpaRepository<ProductDao, Integer> {

}
