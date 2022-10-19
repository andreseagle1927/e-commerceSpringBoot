package com.abadia.first.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Table(name = "product_exist")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty()
	@Column(name = "id_product")
	private Integer id;
	
	@JsonProperty()
	@Column(name = "name")
	private String name;
	
	@JsonProperty()
	@Column(name = "type")
	private String type;

	@JsonProperty()
	@Column(name = "price")
	private float price;

	// bring all of this product in the stock
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}




}
