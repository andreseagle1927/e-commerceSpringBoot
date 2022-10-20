package com.abadia.first.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@JsonProperty()
	@Column(name = "id_cart")
	private Integer id; // id = IP


	@JsonProperty()
	@Column(name = "ip")
	private String ip;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Inventory> productos;
	
	public void addToCart(Inventory inventory) {
		productos.add(inventory);
	}





	


	public void setProductos(List<Inventory> productos) {
		this.productos = productos;
	}


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

	
	
}
