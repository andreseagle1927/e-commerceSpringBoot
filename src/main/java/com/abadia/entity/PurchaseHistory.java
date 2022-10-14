package com.abadia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class PurchaseHistory {

	@Id
	@JsonProperty()
	@Column()
	private String id; // id = IP
	
	@JsonProperty()
	@Column()
	private String email;
	
	@JsonProperty()
	@Column()
	private String ProductsName;  // concatenation of products names

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductsName() {
		return ProductsName;
	}

	public void setProductsName(String productsName) {
		ProductsName = productsName;
	}
	
	
	
}
