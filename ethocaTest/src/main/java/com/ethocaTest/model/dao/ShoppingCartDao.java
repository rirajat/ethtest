package com.ethocaTest.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ethocaTest.model.LineItem;
import com.ethocaTest.model.ShoppingCart;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCartDao extends ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ShoppingCartId")
	private List<LineItemDao> items;

	@Column
	private Date created;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LineItem> getItems() {
		return new ArrayList<LineItem>(items);
	}

	public void setItems(List<LineItem> items) {
		this.items = new ArrayList<LineItemDao>();
		for (int i = 0; i < items.size(); i++) {
			this.items.add((LineItemDao) items.get(i));
		}
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
