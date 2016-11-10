package com.productclass.model;

import org.hibernate.*;

import com.product.model.ProductVO;
import com.productclassdetails.model.ProductClassdetailsVO;

import hibernate.util.HibernateUtil;
import java.util.*;

public class ProductClassHibernateDAO implements ProductClassDAO_interface {

	private static final String GET_ALL_STMT = "from ProductClassVO order by class_no";

	@Override
	public void insert(ProductClassVO productClassVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(productClassVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ProductClassVO productClassVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(productClassVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer class_no) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ProductClassVO productClassVO = (ProductClassVO) session.get(ProductClassVO.class, class_no);
			session.delete(productClassVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public ProductClassVO findByPrimaryKey(Integer class_no) {
		ProductClassVO productClassVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			productClassVO = (ProductClassVO) session.get(ProductClassVO.class, class_no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return productClassVO;
	}

	@Override
	public List<ProductClassVO> getAll() {
		List<ProductClassVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	@Override
	public Set<ProductVO> getProductsByClass_no(Integer class_no) {		
		Set<ProductVO> set = findByPrimaryKey(class_no).getProducts();
		return set;
	}
	
	public Set<ProductClassdetailsVO> getClassdetailsByClass_no(Integer class_no) {		
		Set<ProductClassdetailsVO> set = findByPrimaryKey(class_no).getProductClassdetails();
		return set;
	}
	
	public ProductClassVO getProductClassById(Integer class_no) {
		ProductClassVO productclassVO = null;
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			productclassVO = (ProductClassVO) session.get(ProductClassVO.class, class_no);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return productclassVO;
	}
	

	public static void main(String[] args) {
		
		ProductClassHibernateDAO dao = new ProductClassHibernateDAO();	

		//��@�d�� �t���~���
//		ProductClassVO productClassVO1 = dao.findByPrimaryKey(3);
//		System.out.print(productClassVO1.getClass_no() + ",");
//		System.out.print(productClassVO1.getClass_name() + ",");
//			System.out.println("\n------��������~�C��------");
//			Set<ProductVO> set1 = productClassVO1.getProducts();
//			for (ProductVO aProduct : set1) {
//				System.out.print(aProduct.getProduct_name()+",");
//				System.out.println();
//			}
//			System.out.println();

		
		//getAll�򥻬d�� ���t�����Ӷi�f�檺���
//		List<SupplierVO> list2 = dao.getAll();
//		for (SupplierVO aSupplier : list2) {
//			System.out.print(aSupplier.getSupplier_id() + ",");
//			System.out.print(aSupplier.getSupplier_name() + ",");
//			System.out.print(aSupplier.getChargeperson() + ",");
//			System.out.println();
//		}
		
		//getAll�@��h�d�� �t�����Ӷi�f�檺���
//		List<SupplierVO> list3 = dao.getAll();
//		for (SupplierVO aSupplier : list3) {
//			System.out.print(aSupplier.getSupplier_name() + ",");
//			System.out.print(aSupplier.getChargeperson() + ",");
//			System.out.println("\n------�����Ӫ��i�f��------");
//			Set<StockVO> set2 = aSupplier.getStocks();
//			for (StockVO aStock : set2) {
//				System.out.print(aStock.getStock_id() + ",");
//				System.out.print(aStock.getStock_date() + ",");
//				System.out.print(aStock.getAdminster_name());
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		Set<ProductVO> set = dao.getProductsByClass_no(1);
		for (ProductVO aproductVO : set) {
			System.out.println(aproductVO.getProduct_name());
		}
//		
		
	}
}
