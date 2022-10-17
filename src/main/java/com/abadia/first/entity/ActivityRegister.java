package com.abadia.first.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "activityregister")
public class ActivityRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty()
	@Column(name = "id")
	private Integer id;

	@JsonProperty()
	@Column(name = "ip")
	private String ip;
	
	@JsonProperty()
	@Column(name = "fecha")
	private String date;
	
	@JsonProperty()
	@Column(name = "productName")
	private String productName;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
