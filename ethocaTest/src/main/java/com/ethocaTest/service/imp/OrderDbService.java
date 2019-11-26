package com.ethocaTest.service.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ethocaTest.model.dao.OrdarDao;
import com.ethocaTest.model.dao.ProductDao;
import com.ethocaTest.model.dao.ShoppingCartDao;

public interface OrderDbService extends JpaRepository<OrdarDao, Integer> {
	@Query("SELECT o FROM OrdarDao o WHERE o.id = ?1")
	OrdarDao find(int id);
}
