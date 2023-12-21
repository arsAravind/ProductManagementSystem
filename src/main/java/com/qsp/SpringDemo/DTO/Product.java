package com.qsp.SpringDemo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_Id")
	private int productId;
	@Column(name = "Product_Name")
	private String productName;
	@Column(name = "Product_Type")
	private String productType;
	@Column(name = "Product_Price")
	private String productPrice;

}
