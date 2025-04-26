package com.product.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_details")
@Data
public class ProductDetails {

	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_long_name")
	private String productLongName;

	@Column(name = "sub_category_id")
	@ManyToOne
	private SubCategories subCategoryId;
	
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "feature")
	private String feature;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "active")
	private boolean active;

	@Column(name = "created_by")
	private Long createdBy;

}
