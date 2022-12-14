package com.cloudstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	
	private String[] shopId;
	private String latString;
	private String longString;
	private String prodName;
	private String category;
	private String image;
	private String mainUnit;
	private String saleUnit;
	private double weight;
	private double price;
	private int increment;

}
