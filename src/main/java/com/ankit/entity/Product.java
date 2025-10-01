package com.ankit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "product")
public class Product {

//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String id;
	private String name;
	private String category;
	private Float price;
	private Integer stock;

	public Product(String name, String category, Float price, Integer stock) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}
}
