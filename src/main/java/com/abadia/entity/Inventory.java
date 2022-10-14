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
public class Inventory {


	@Id
	@JsonProperty()
	@Column()
	private String name;
	
	@OneToMany
	@JsonProperty()
	@Column()
	private List<Product> ProductsList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductsList() {
		return ProductsList;
	}

	public void setProductsList(List<Product> productsList) {
		ProductsList = productsList;
	}
	
	
}
