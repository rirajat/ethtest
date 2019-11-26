package com.ethocaTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.dao.LineItemDao;
import com.ethocaTest.model.dao.ProductDao;
import com.ethocaTest.model.dao.ShoppingCartDao;
import com.ethocaTest.model.webRequest.ShoppingCartReq;
import com.ethocaTest.service.imp.LineItemDbService;
import com.ethocaTest.service.imp.LineItemSaveDao;
import com.ethocaTest.service.imp.ProductDbService;
import com.ethocaTest.service.imp.ShoppingCartDbService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ShoppingTest {
	@LocalServerPort
    int randomServerPort;
	
	@Autowired
	private ShoppingCartDbService dao;
	
	@Autowired
	private LineItemDbService daoL;
	@Autowired
	private ProductDbService daoP;
	
	@Before
	public void setUp() {

		ProductDao p =new ProductDao();
	    p.setId(1);
	    p.setName("test");
	    p.setPrice(10);
	    daoP.save(p);
	    
	    ShoppingCartDao s =new ShoppingCartDao();
	    s.setCreated(new Date());
	    dao.save(s);
	    
	    s =new ShoppingCartDao();
	    s.setCreated(new Date());
	    dao.save(s);
	    
	    LineItemSaveDao lineItem = new LineItemSaveDao();
	    lineItem.setId(1);
	    lineItem.setQuentity(10);
	    lineItem.setShoppingcartid(2);
	    lineItem.setProductid(1);
	    daoL.save(lineItem);
	    
	    lineItem = new LineItemSaveDao();
	    lineItem.setId(2);
	    lineItem.setQuentity(10);
	    lineItem.setShoppingcartid(2);
	    lineItem.setProductid(1);
	    daoL.save(lineItem);
	}
	
	@Test
	public void getShopping() throws UnirestException {
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.get("http://localhost:"+this.randomServerPort+"/api/shopping/1")
	      .header("accept", "application/json")
	      .asJson();
		assertNotNull(jsonResponse.getBody());
		assertEquals(200, jsonResponse.getStatus());
	}
	
	@Test
	public void getShopping_NoData() throws UnirestException {
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.get("http://localhost:"+this.randomServerPort+"/api/shopping/100")
	      .header("accept", "application/json")
	      .asJson();
		JSONObject body = jsonResponse.getBody().getObject();
		
		assertEquals(0, body.length());
		assertEquals(200, jsonResponse.getStatus());
	}
	
	@Test
	public void postShopping() throws UnirestException {
		
		String req = "{\"created\": \"2019-02-02T05:00:00.000+0000\"}";
		
		HttpResponse<String> jsonResponse 
	      = Unirest.post("http://localhost:"+this.randomServerPort+"/api/shopping/")
	      .header("Content-Type", "application/json")
	      .body(req)
	      .asString();

		assertEquals(201, jsonResponse.getStatus());
		assertNotNull(jsonResponse.getBody());
	}
	
	@Test
	public void addLineItem() throws UnirestException {
		
		String req = "{\r\n" + 
				"            \"productid\": 1,\r\n" + 
				"            \"quentity\": 10\r\n" + 
				"        }";
		
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.put("http://localhost:"+this.randomServerPort+"/api/shopping/1/item")
	      .header("Content-Type", "application/json")
	      .body(req)
	      .asJson();

		assertEquals(200, jsonResponse.getStatus());
	}
	
	@Test
	public void addLineItemWithNoCart() throws UnirestException {
		
		String req = "{\r\n" + 
				"            \"productid\": 1,\r\n" + 
				"            \"quentity\": 10\r\n" + 
				"        }";
		
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.put("http://localhost:"+this.randomServerPort+"/api/shopping/40/item")
	      .header("Content-Type", "application/json")
	      .body(req)
	      .asJson();

		assertEquals(400, jsonResponse.getStatus());
	}
	
	@Test
	public void updateLineItem() throws UnirestException {
		
		String req = "{\r\n" + 
				"            \"quentity\": 400\r\n" + 
				"        }";
		
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.patch("http://localhost:"+this.randomServerPort+"/api/shopping/2/item/1")
	      .header("Content-Type", "application/json")
	      .body(req)
	      .asJson();

		assertEquals(200, jsonResponse.getStatus());
	}
	
	@Test
	public void updateLineItemWithInProperQuentity() throws UnirestException {
		
		String req = "{\r\n" + 
				"            \"quentity\": -200\r\n" + 
				"        }";
		
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.patch("http://localhost:"+this.randomServerPort+"/api/shopping/2/item/1")
	      .header("Content-Type", "application/json")
	      .body(req)
	      .asJson();

		assertEquals(400, jsonResponse.getStatus());
	}
	
	@Test
	public void deleteLineItem() throws UnirestException {
		
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.delete("http://localhost:"+this.randomServerPort+"/api/shopping/2/item/2")
	      .header("Content-Type", "application/json")
	      .asJson();

		assertEquals(200, jsonResponse.getStatus());
	}
	
	@Test
	public void submitOrder() throws UnirestException {
		
		HttpResponse<String> jsonResponse 
	      = Unirest.post("http://localhost:"+this.randomServerPort+"/api/shopping/2/submit")
	      .header("Content-Type", "application/json")
	      .asString();

		assertEquals(201, jsonResponse.getStatus());
		assertNotNull(jsonResponse.getBody());
	}
	
	@Test
	public void badRequest() throws UnirestException {
		
		String req = "{\r\n" +  
				"            \"quentity\": 10\r\n" + 
				"        }";
		
		HttpResponse<JsonNode> jsonResponse 
	      = Unirest.put("http://localhost:"+this.randomServerPort+"/api/shopping/1/item")
	      .header("Content-Type", "application/json")
	      .body(req)
	      .asJson();

		assertEquals(400, jsonResponse.getStatus());
	}
}
