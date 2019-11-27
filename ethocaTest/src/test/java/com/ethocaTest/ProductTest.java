package com.ethocaTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ethocaTest.model.dao.ProductDao;
import com.ethocaTest.service.imp.ProductDbService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {
	@LocalServerPort
	int randomServerPort;

	@Autowired
	private ProductDbService dao;

	@Before
	public void setUp() {

		ProductDao p = new ProductDao();
		p.setId(1);
		p.setName("test");
		p.setPrice(10);
		dao.save(p);

	}

	@Test
	public void getAllProducts() throws UnirestException {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:" + this.randomServerPort + "/api/product")
				.header("accept", "application/json").asJson();
		assertNotNull(jsonResponse.getBody());
		assertEquals(200, jsonResponse.getStatus());
	}
}
