package com.abadia.first.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "inventory")
public class Inventory {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty()
	@Column(name = "id_in_stock")
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "id_product")
	private Product product;
	
	@ManyToOne()
	@JoinColumn(name = "id_cart")
	private Cart cart;

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
