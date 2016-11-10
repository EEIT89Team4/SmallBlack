package com.product.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.supplier.model.SupplierDAO;
import com.supplier.model.SupplierDAO_interface;
import com.supplier.model.SupplierVO;

import hibernate.util.HibernateUtil;

public class ProductService {

	public void insert(ProductVO productVO) {
	 ProductDAO productdao = new ProductDAO();
	 productdao.insert(productVO);
	}

	public void update(ProductVO productVO) {
		 ProductDAO productdao = new ProductDAO();
		 productdao.update(productVO);

	}

	public void delete(Integer product_no) {
		ProductDAO productdao = new ProductDAO();
		 productdao.delete(product_no);

	}

	public ProductVO getProductById(Integer product_no) {
		ProductDAO productdao = new ProductDAO();
		 return productdao.getProductById(product_no);
	}

	public List<ProductVO> getAllProduct() {
		ProductDAO productdao = new ProductDAO();
		 return productdao.getAllProduct();
	}
	
	public ProductVO updateProduct(Integer product_no,Integer class_no, Integer classdetail_no,Integer product_price,String unit,String supplier_name,String product_name,Integer product_quantity,Integer saleaccount_quantity
			,Integer weight,Date deadline,Integer deadlineday,Integer product_alertquantity,String product_description) {

		ProductVO productVO = new ProductVO();
		
		productVO.setProduct_no(product_no);
		productVO.setClass_no(class_no);
		productVO.setClassdetail_no(classdetail_no);
		productVO.setProduct_price(product_price);
		productVO.setUnit(unit);
		productVO.setSupplier_name(supplier_name);
		productVO.setProduct_name(product_name);
		productVO.setProduct_quantity(product_quantity);
		productVO.setSaleaccount_quantity(saleaccount_quantity);
		productVO.setWeight(weight);
		productVO.setDeadline(deadline);
		productVO.setDeadlineday(deadlineday);
		productVO.setProduct_alertquantity(product_alertquantity);
		productVO.setProduct_description(product_description);
		
		
		ProductDAO productdao = new ProductDAO();
		productdao.update(productVO);

		return productdao.getProductById(product_no);
	}
	
	
	public ProductVO insertProduct(Integer class_no, Integer classdetail_no,Integer product_price,String unit,String supplier_name,String product_name,Integer product_quantity
			,Integer saleaccount_quantity,Integer weight,Date deadline,Integer deadlineday,Integer product_alertquantity,String product_description) {

		ProductVO productVO = new ProductVO();
		
		productVO.setClass_no(class_no);
		productVO.setClassdetail_no(classdetail_no);
		productVO.setProduct_price(product_price);
		productVO.setUnit(unit);
		productVO.setSupplier_name(supplier_name);
		productVO.setProduct_name(product_name);
		productVO.setProduct_quantity(product_quantity);
		productVO.setSaleaccount_quantity(saleaccount_quantity);
		productVO.setWeight(weight);
		productVO.setDeadline(deadline);
		productVO.setDeadlineday(deadlineday);
		productVO.setProduct_alertquantity(product_alertquantity);
		productVO.setProduct_description(product_description);
		
		
		ProductDAO productdao = new ProductDAO();
		productdao.insert(productVO);

		return productVO;
	}
	
	
	
	
}
