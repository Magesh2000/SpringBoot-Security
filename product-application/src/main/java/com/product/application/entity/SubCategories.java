package com.product.application.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sub_categories")
@Data
public class SubCategories {

	@Id
	@Column(name = "sub_category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subCategoryId;

	@Column(name = "sub_category")
	private String subCategory;

	@Column(name = "category_id")
	@ManyToOne
	private Categories categoryId;

	@Column(name = "active")
	private boolean active;

	@Column(name = "created_by")
	private Long createdBy;
	
	@OneToMany(mappedBy = "sub_category_id",cascade = CascadeType.ALL)
	private List<ProductDetails> productDetailList;

}
