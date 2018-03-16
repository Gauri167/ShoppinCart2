package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="product")
public class Product {

	@Id
	private String id;
	@Column(name="Name")
	private String name;
	@Column(name="Description")
	private String description;
    @Column(name="CategoryId")
	private String categoryId;
	@Column(name="SupplierId")
	private String supplierId;
	
	@ManyToOne
	@JoinColumn(name="CategoryId",updatable=false,insertable=false,nullable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="SupplierId",updatable=false,insertable=false,nullable=false)
	private Supplier supplier;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
