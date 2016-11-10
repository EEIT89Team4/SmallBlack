package com.product.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;

public class ProductDAO {

	public void insert(ProductVO productVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(productVO);
			tx.commit();
		} catch (RuntimeException ex) {
			tx.rollback();
		}
	}

	public void update(ProductVO productVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(productVO);
			tx.commit();
		} catch (RuntimeException ex) {
			tx.rollback();
		}

	}

	public void delete(Integer product_no) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		ProductVO productVO = null;
		try {
			tx = session.beginTransaction();
			productVO = (ProductVO) session.get(ProductVO.class, product_no);
			session.delete(productVO);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
		}
	}

	public ProductVO getProductById(Integer product_no) {
		ProductVO productVO = null;
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			productVO = (ProductVO) session.get(ProductVO.class, product_no);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return productVO;
	}

	public List<ProductVO> getAllProduct() {
		List<ProductVO> productlist = null;
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from ProductVO order by product_no");
			productlist = query.list();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return productlist;

	}

	public static void main(String args[]) {
		ProductVO productvo = new ProductVO();

		// ���է�� �~��
//		 ProductDAO productdao = new ProductDAO();
//		 productvo=productdao.getProductById(3001);
//		 productvo.setWeight(777);
//		 productdao.update(productvo);
		// �s�W�~��
		// ProductDAO productdao = new ProductDAO();
		// productvo.setClass_no(1);
		// productvo.setClassdetail_no(12);
		// productvo.setProduct_price(10000);
		// productvo.setUnit("��");
		// productvo.setSupplier_name("�굦�|");
		// productvo.setProduct_name("ps4");
		// productvo.setProduct_quantity(15);
		// productvo.setSaleaccount_quantity(8);
		// productvo.setWeight(300);
		// productvo.setDeadline(2017-01-01); //����榡�ݬd
		// productvo.setDeadlineday(3);
		// productdao.insert(productvo);

		// �R������
		 ProductDAO productdao = new ProductDAO();
		 productdao.delete(3001);
		// �d�߳�@���~
//		 ProductDAO productdao = new ProductDAO();
//		 productvo =productdao.getProductById(3053);
//		 System.out.println(productvo.getProduct_name());
//		 System.out.println(productvo.getPictrue());
		// �d�ߥ������~
//		 ProductDAO productdao = new ProductDAO();
//		 List<ProductVO> productlist=productdao.getAllProduct();
//		 for (ProductVO productvo1 :productlist){
//		 System.out.println(productvo1.getProduct_name());
		// }
	}
}
