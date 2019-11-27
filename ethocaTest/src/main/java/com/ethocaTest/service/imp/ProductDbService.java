package com.ethocaTest.service.imp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethocaTest.model.dao.ProductDao;

public interface ProductDbService extends JpaRepository<ProductDao, Integer> {

}
