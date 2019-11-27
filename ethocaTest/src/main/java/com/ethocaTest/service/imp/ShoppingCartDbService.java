package com.ethocaTest.service.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ethocaTest.model.dao.ShoppingCartDao;

public interface ShoppingCartDbService extends JpaRepository<ShoppingCartDao, Integer> {
	@Query("SELECT s FROM ShoppingCartDao s WHERE s.id = ?1")
	ShoppingCartDao find(int id);
}
