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
