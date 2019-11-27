package com.ethocaTest.service.imp;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethocaTest.exception.OperationNotAllowedException;
import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.Order;
import com.ethocaTest.model.ShoppingCart;
import com.ethocaTest.model.dao.LineItemDao;
import com.ethocaTest.model.dao.OrdarDao;
import com.ethocaTest.model.dao.ShoppingCartDao;
import com.ethocaTest.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderDbService daoOrder;
	
	@Autowired
	private LineItemDbService daoItem;
	
	@Autowired
	private ShoppingCartDbService daoCart;
	
	@Transactional
	public Order save(int cartId) {
		ShoppingCartDao cart = daoCart.find(cartId);
		if (cart == null || cart.getItems().size() == 0) {
			throw new OperationNotAllowedException();
		}
		
		OrdarDao order = new OrdarDao();
		order.setCreated(new Date());
		daoOrder.save(order);
		
		for(LineItem item : cart.getItems()) {
			LineItemSaveDao saveItem = daoItem.getOne(item.getId());
			saveItem.setOrderid(order.getId());
			daoItem.save(saveItem);
		}
		
		OrdarDao o = daoOrder.find(order.getId());
		return o;
	}

	public Order find(int id) {
		Order o = daoOrder.find(id);
		return o;
	}

}
