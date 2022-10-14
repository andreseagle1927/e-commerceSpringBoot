package com.abadia.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Cart {

	@Id
	@JsonProperty()
	@Column()
	private String id; // id = IP
	
	@OneToMany
	@JsonProperty()
	@Column()
	private List<Product> ProductsList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Product> getProductsList() {
		return ProductsList;
	}

	public void setProductsList(List<Product> productsList) {
		ProductsList = productsList;
	}
	
	
	
	
}
