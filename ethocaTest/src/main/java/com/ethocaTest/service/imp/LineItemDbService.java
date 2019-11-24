package com.ethocaTest.service.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface LineItemDbService extends JpaRepository<LineItemSaveDao, Integer>{
	@Transactional
	@Modifying
	@Query("DELETE FROM LineItemSaveDao l WHERE l.id=?2 and l.shoppingcartid=?1")
	void delete(int id, int itemid);
	
	@Query("SELECT l FROM LineItemSaveDao l WHERE l.id=?2 and l.shoppingcartid=?1")
	LineItemSaveDao find(int id,int itemid);
}
