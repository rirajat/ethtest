package com.ethocaTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ethocaTest.model.dao.OrdarDao;
import com.ethocaTest.model.dao.ProductDao;
import com.ethocaTest.model.dao.ShoppingCartDao;
import com.ethocaTest.service.imp.LineItemDbService;
import com.ethocaTest.service.imp.LineItemSaveDao;
import com.ethocaTest.service.imp.OrderDbService;
import com.ethocaTest.service.imp.ProductDbService;
import com.ethocaTest.service.imp.ShoppingCartDbService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderTest {
	@LocalServerPort
    int randomServerPort;
	
	@Autowired
	private OrderDbService dao;
	
	@Autowired
	private LineItemDbService daoL;
	@Autowired
	private ProductDbService daoP;
	@Autowired
	private ShoppingCartDbService daoS;
	
	@Before
	public void setUp() {

		ProductDao p =new ProductDao();
	    p.setId(1);
	    p.setName("test");
	    p.setPrice(10);
	    daoP.save(p);
	    
	    OrdarDao o =new OrdarDao();
	    o.setCreated(new Date());
	    dao.save(o);
	    
	    ShoppingCartDao s =new ShoppingCartDao();
	    s.setCreated(new Date());
	    daoS.save(s);
	    
	    LineItemSaveDao lineItem = new LineItemSaveDao();
	    lineItem.setId(1);
	    lineItem.setQuentity(10);
	    lineItem.setOrderid(1);
	    lineItem.setProductid(1);
	    lineItem.setShoppingcartid(1);
	    daoL.save(lineItem);
	    
	    lineItem = new LineItemSaveDao();
	    lineItem.setId(2);
	    lineItem.setQuentity(10);
	    lineItem.setOrderid(1);
	    lineItem.setProductid(1);
	    lineItem.setShoppingcartid(1);
	    daoL.save(lineItem);
	}
	
	@Test
	public void getOrder() throws UnirestException {
		HttpResponse<String> jsonResponse 
	      = Unirest.get("http://localhost:"+this.randomServerPort+"/api/order/1")
	      .header("accept", "application/json")
	      .asString();
		assertNotNull(jsonResponse.getBody());
		assertEquals(200, jsonResponse.getStatus());
	}
}
