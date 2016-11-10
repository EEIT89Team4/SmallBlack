package com.productclassdetails.model;

import com.productclass.model.ProductClassVO;

public class ProductClassdetailsVO {
	private Integer classdetail_no;
	private ProductClassVO productClassVO;
	private String classdetail_name;
//	private int class_no;
	
	public Integer getClassdetail_no() {
		return classdetail_no;
	}
	
	public void setClassdetail_no(Integer classdetail_no) {
		this.classdetail_no = classdetail_no;
	}
	
	public ProductClassVO getProductClassVO() {
		return productClassVO;
	}
	
	public void setProductClassVO(ProductClassVO productClassVO) {
		this.productClassVO = productClassVO;
	}
	
	public String getClassdetail_name() {
		return classdetail_name;
	}
	
	public void setClassdetail_name(String classdetail_name) {
		this.classdetail_name = classdetail_name;
	}

//	
//	public int getClass_no() {
//		return class_no;
//	}
//	public void setClass_no(int class_no) {
//		this.class_no = class_no;
//	}
	
	
	
}
