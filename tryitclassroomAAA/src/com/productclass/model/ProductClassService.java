package com.productclass.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.product.model.ProductDAO;
import com.product.model.ProductVO;
import com.shipments.model.ShipmentsVO;
import com.supplier.model.SupplierVO;

public class ProductClassService {

	private ProductClassDAO_interface dao;

	public ProductClassService() {
		dao = new ProductClassHibernateDAO();
	}

	public List<ProductClassVO> getAll() {
		
		return dao.getAll();
	}
	
	public ProductClassVO addProductClass(String class_name) {

		ProductClassVO productclassVO = new ProductClassVO();

		productclassVO.setClass_name(class_name);
		dao.insert(productclassVO);

		return productclassVO;
	}
	
	

	public ProductClassVO getOneProductClass(Integer class_no) {
		return dao.findByPrimaryKey(class_no);
	}

	public ProductClassVO updateProductClass(Integer class_no,String class_name) {

		ProductClassVO productclassVO = new ProductClassVO();
		
		productclassVO.setClass_no(class_no);
		productclassVO.setClass_name(class_name);
		
		
		ProductClassHibernateDAO productclassdao = new ProductClassHibernateDAO();
		productclassdao.update(productclassVO);

		return productclassdao.getProductClassById(class_no);
	}
}
