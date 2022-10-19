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



	
	
	
	
}
