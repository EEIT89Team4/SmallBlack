package com.productclassdetails.model;

import org.hibernate.*;

import com.supplier.model.SupplierVO;

import hibernate.util.HibernateUtil;
import java.util.*;


public class ProductClassdetailsDAO implements ProductClassdetailsDAO_interface {

	private static final String GET_ALL_STMT = "from ProductClassdetailsVO order by classdetail_no";

	@Override
	public void insert(ProductClassdetailsVO productClassdetailsVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(productClassdetailsVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ProductClassdetailsVO productClassdetailsVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(productClassdetailsVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer classdetail_no) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

//        �i���ɦh��(�y)�i�ĥ�HQL�R���j
			Query query = session.createQuery("delete ProductClassdetailsVO where classdetail_no=?");
			query.setParameter(0, classdetail_no);
			System.out.println("�R��������=" + query.executeUpdate());

//        �i�Φ��ɦh��(�])�i�ĥΥh�����p���Y��A�A�R�����覡�j
//			ProductClassdetailsVO productClassdetailsVO = new ProductClassdetailsVO();
//			productClassdetailsVO.setClassdetail_no(classdetail_no);
//			session.delete(productClassdetailsVO);

//        �i���ɦh�褣�i(���y)�ĥ�cascade�p�ŧR���j
//        �i�h��stock.hbm.xml�p�G�]�� cascade="all"�� cascade="delete"�N�|�R���Ҧ��������-�]�A���ݳ����P�P�������䥦���u�N�|�@�ֳQ�R���j
//		    ProductClassdetailsVO productClassdetailsVO = (ProductClassdetailsVO) session.get(ProductClassdetailsVO.class, classdetail_no);
//		    session.delete(productClassdetailsVO);

		    session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	
	@Override
	public ProductClassdetailsVO findByPrimaryKey(Integer classdetail_no) {
		ProductClassdetailsVO productClassdetailsVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			productClassdetailsVO = (ProductClassdetailsVO) session.get(ProductClassdetailsVO.class, classdetail_no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return productClassdetailsVO;
	}

	@Override
	public List<ProductClassdetailsVO> getAll() {
		List<ProductClassdetailsVO> list = null;
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

	public static void main(String[] args) {
		
		ProductClassdetailsDAO dao = new ProductClassdetailsDAO();
		
		//getAll�h��@�d�� �t�`�������
//		List<ProductClassdetailsVO> list = dao.getAll();
//		for (ProductClassdetailsVO aPCD : list) {
//			System.out.print(aPCD.getClassdetail_no() + ",");
//			System.out.print(aPCD.getClassdetail_name() + ",");
//			// �H�U�T��g�k���b�h����ܤ@����
//			System.out.println("--------------------------");
//			System.out.print("�`������:(");
//			System.out.print(aPCD.getProductClassVO().getClass_name() + ",");
//			System.out.print(")");
//			System.out.println();
//			System.out.println();
//		}	
	}
}
