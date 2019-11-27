package com.ethocaTest.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethocaTest.exception.DataFormatException;
import com.ethocaTest.exception.OperationNotAllowedException;
import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.ShoppingCart;
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
		if (cart.getCreated() == null) {
			throw new DataFormatException();
		}
		daoObj.setCreated(cart.getCreated());
		daoCart.save(daoObj);
		return daoObj;
	}

	@Transactional
	public ShoppingCart add(int id, LineItem item) {
		ShoppingCartDao cart = daoCart.find(id);
		if (item.getProduct() == null || cart == null || item.getQuentity() < 0) {
			throw new DataFormatException();
		}
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
		ShoppingCartDao cart = daoCart.find(id);
		if (cart == null || item.getQuentity() < 0) {
			throw new DataFormatException();
		}

		daoObj.setQuentity(item.getQuentity());
		daoItem.save(daoObj);
		return daoCart.find(id);
	}

	@Transactional
	public void remove(int id, int itemId) {
		LineItemSaveDao item = daoItem.find(id, itemId);
		if (item != null) {
			daoItem.delete(id, itemId);
		} else {
			throw new OperationNotAllowedException();
		}
	}
}
