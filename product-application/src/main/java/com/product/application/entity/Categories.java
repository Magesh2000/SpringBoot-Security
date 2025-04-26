package com.product.application.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Categories {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column(name = "category")
	private String category;
	
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@OneToMany(mappedBy = "category_id",cascade = CascadeType.ALL)
	private List<SubCategories> subCategoryList;

}
