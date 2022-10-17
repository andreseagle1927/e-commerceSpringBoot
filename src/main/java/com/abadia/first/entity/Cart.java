package com.abadia.first.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty()
	@Column(name = "id")
	private Integer id; // id = IP


	@JsonProperty()
	@Column(name = "ip")
	private String ip;



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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<Product> getProductsList() {
		return ProductsList;
	}

	public void setProductsList(List<Product> productsList) {
		ProductsList = productsList;
	}
	
	
	
	
}
