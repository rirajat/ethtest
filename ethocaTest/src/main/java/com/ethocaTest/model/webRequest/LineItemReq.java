package com.ethocaTest.model.webRequest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.Product;
import com.ethocaTest.model.dao.ProductDao;

public class LineItemReq extends LineItem{

	private int id;
	private int productid;
	private ProductReq product;
	private int quentity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuentity() {
		return quentity;
	}
	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}
	@Override
	public void setProduct(Product product) {
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
		this.product=new ProductReq();
		this.product.setId(productid);
	}

}
