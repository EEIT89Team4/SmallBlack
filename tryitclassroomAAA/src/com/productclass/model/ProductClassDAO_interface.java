package com.productclass.model;

import java.util.List;
import java.util.Set;

import com.product.model.ProductVO;
import com.stock.model.StockVO;

public interface ProductClassDAO_interface {
	public void insert(ProductClassVO productClassVO);
	public void update(ProductClassVO productClassVO);
	public void delete(Integer class_no);
	public ProductClassVO findByPrimaryKey(Integer class_no);
	public List<ProductClassVO> getAll();
	public Set<ProductVO> getProductsByClass_no(Integer class_no);
}
