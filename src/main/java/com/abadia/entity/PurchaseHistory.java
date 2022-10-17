package com.abadia.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "purchasehistory")
public class PurchaseHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty()
	@Column(name = "id")
	private Integer id;

	@JsonProperty()
	@Column(name = "ip")
	private String ip;

	@JsonProperty()
	@Column(name = "email")
	private String email;
	
	@JsonProperty()
	@Column(name = "productsname")
	private String ProductsName;  // concatenation of products names

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
