package com.ethocaTest.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.ShoppingCart;
import com.ethocaTest.model.dao.LineItemDao;
import com.ethocaTest.model.dao.ProductDao;
import com.ethocaTest.model.dao.ShoppingCartDao;
import com.ethocaTest.service.IShoppingCart;

@Service
public class ShoppingCartService implements IShoppingCart {

	@Autowired
	private ShoppingCartDbService daoCart;
	
	@Autowired
	private LineItemDbService daoItem;
	
	public ShoppingCart find(int id) {
		return daoCart.find(id);
	}

	@Transactional
	public ShoppingCart create(ShoppingCart cart) {
		ShoppingCartDao daoObj = new ShoppingCartDao();
		daoObj.setCreated(cart.getCreated());
		daoCart.save(daoObj);
		return daoObj;
	}

	@Transactional
	public ShoppingCart add(int id, LineItem item) {
		LineItemSaveDao daoObj = new LineItemSaveDao();
		daoObj.setShoppingcartid(id);
		daoObj.setQuentity(item.getQuentity());
		daoObj.setProductid(item.getProduct().getId());
		daoItem.save(daoObj);
		return daoCart.find(id);
	}

	@Transactional
	public ShoppingCart update(int id, LineItem item) {
		LineItemSaveDao daoObj = daoItem.find(id, item.getId());
		daoObj.setQuentity(item.getQuentity());
		daoItem.save(daoObj);
		return daoCart.find(id);
	}

	@Transactional
	public boolean remove(int id, int itemId) {
		daoItem.delete(id,itemId);
		return true;
	}
}