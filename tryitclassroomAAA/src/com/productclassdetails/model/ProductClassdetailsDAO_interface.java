package com.productclassdetails.model;

import java.util.List;

public interface ProductClassdetailsDAO_interface {
	public void insert(ProductClassdetailsVO productClassdetailsVO);
	public void update(ProductClassdetailsVO productClassdetailsVO);
	public void delete(Integer classdetail_no);
	public ProductClassdetailsVO findByPrimaryKey(Integer classdetail_no);
	public List<ProductClassdetailsVO> getAll();
	
}
