package com.productclass.model;

import java.util.HashSet;
import java.util.Set;

import com.product.model.ProductVO;
import com.productclassdetails.model.ProductClassdetailsVO;

public class ProductClassVO implements java.io.Serializable {
	private Integer class_no;
	private String class_name;
	private Set<ProductVO> products = new HashSet<ProductVO>();
	private Set<ProductClassdetailsVO> ProductClassdetails = new HashSet<ProductClassdetailsVO>();
	
	public Integer getClass_no() {
		return class_no;
	}
	
	public void setClass_no(Integer class_no) {
		this.class_no = class_no;
	}
	
	public String getClass_name() {
		return class_name;
	}
	
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public Set<ProductVO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductVO> products) {
		this.products = products;
	}

	public Set<ProductClassdetailsVO> getProductClassdetails() {
		return ProductClassdetails;
	}

	public void setProductClassdetails(Set<ProductClassdetailsVO> productClassdetails) {
		ProductClassdetails = productClassdetails;
	}
	
}
