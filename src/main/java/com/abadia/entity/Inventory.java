package com.abadia.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "inventory")
public class Inventory {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty()
	@Column(name = "id")
	private Integer id;

	@JsonProperty()
	@Column(name = "inventoryname")
	private String inventoryName;

	@OneToMany
	@JsonProperty()
	@Column(name = "product_id")
	private List<Product> ProductsList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public List<Product> getProductsList() {
		return ProductsList;
	}

	public void setProductsList(List<Product> productsList) {
		ProductsList = productsList;
	}
	
	
}
