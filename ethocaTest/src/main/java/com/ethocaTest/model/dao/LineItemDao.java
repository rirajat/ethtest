package com.ethocaTest.model.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.Product;


@Entity
@Table(name="lineitem")
public class LineItemDao extends LineItem{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "ProductId", updatable = false, insertable = false)
	private ProductDao product;
	@Column
	private int quentity;
	@Column
	private int shoppingcartid;
	
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
		this.product = (ProductDao)product;
	}
	public void setProductid(int productid) {
		this.product=new ProductDao();
		this.product.setId(productid);
	}
	public int getShoppingcartid() {
		return shoppingcartid;
	}
	public void setShoppingcartid(int shoppingcartid) {
		this.shoppingcartid = shoppingcartid;
	}
	
}
