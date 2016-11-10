package com.productclassdetails.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.product.model.ProductDAO;
import com.product.model.ProductVO;
import com.productclass.model.ProductClassVO;
import com.shipments.model.ShipmentsVO;

public class ProductClassdetailsService {

	private ProductClassdetailsDAO_interface dao;

	public ProductClassdetailsService() {
		dao = new ProductClassdetailsDAO();
	}

	public List<ProductClassdetailsVO> getAll() {
		
		return dao.getAll();
	}
	

	public ProductClassdetailsVO getOneProductClassdetails(Integer classdetail_no) {
		return dao.findByPrimaryKey(classdetail_no);
	}
	
	
	public ProductClassdetailsVO getProductClassdetailsById(Integer classdetail_no) {
		ProductClassdetailsDAO productclassdetailsdao = new ProductClassdetailsDAO();
		 return productclassdetailsdao.findByPrimaryKey(classdetail_no);
	}

	
//	public static void main(String[] args) {
//		ProductClassdetailsService p = new ProductClassdetailsService();
//		List<ProductClassdetailsVO> jj = p.getAll();
//		for(ProductClassdetailsVO hh :jj){
//		System.out.println(hh.getProductClassVO().getClass_no());
//		
//		
//		}
		
//	}
	
	public ProductClassdetailsVO addProductClassDetail(Integer class_no,String classdetail_name) {
		ProductClassdetailsVO productclassdetailsVO = new ProductClassdetailsVO();
		ProductClassVO productclassVO = new ProductClassVO();
		productclassVO.setClass_no(class_no);
		productclassdetailsVO.setProductClassVO(productclassVO);
		productclassdetailsVO.setClassdetail_name(classdetail_name);
		dao.insert(productclassdetailsVO);
		return productclassdetailsVO;
	}
	
	
	
	
	
	

	public ProductClassdetailsVO updateProductClassdetails(Integer class_no,Integer classdetail_no,String classdetail_name) {

		ProductClassdetailsVO productclassdetailsVO = new ProductClassdetailsVO();
		ProductClassVO productclassVO = new ProductClassVO();
		
		productclassVO.setClass_no(class_no);
		productclassdetailsVO.setProductClassVO(productclassVO);
		
		//productclassdetailsVO.setProductClassVO().setClass_no(class_no);
		productclassdetailsVO.setClassdetail_no(classdetail_no);
		productclassdetailsVO.setClassdetail_name(classdetail_name);
		
		ProductClassdetailsDAO productclassdetailsdao = new ProductClassdetailsDAO();
		productclassdetailsdao.update(productclassdetailsVO);

		return productclassdetailsdao.findByPrimaryKey(classdetail_no);
	}
}
