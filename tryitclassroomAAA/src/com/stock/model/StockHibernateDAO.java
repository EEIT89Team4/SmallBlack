package com.stock.model;

import org.hibernate.*;

import com.supplier.model.SupplierVO;

import hibernate.util.HibernateUtil;
import java.util.*;


public class StockHibernateDAO implements StockDAO_interface {

	private static final String GET_ALL_STMT = "from StockVO order by stock_id";

	@Override
	public void insert(StockVO stockVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stockVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(StockVO stockVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stockVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer stock_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete StockVO where stock_id=?");
//			query.setParameter(0, stock_id);
//			System.out.println("刪除的筆數=" + query.executeUpdate());

//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			StockVO stockVO = new StockVO();
			stockVO.setStock_id(stock_id);
			session.delete(stockVO);

//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方stock.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//		    StockVO stockVO = (StockVO) session.get(StockVO.class, stock_id);
//		    session.delete(stockVO);

		    session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	
	@Override
	public StockVO findByPrimaryKey(Integer stock_id) {
		StockVO stockVo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			stockVo = (StockVO) session.get(StockVO.class, stock_id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return stockVo;
	}

	@Override
	public List<StockVO> getAll() {
		List<StockVO> list = null;
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
		
		StockHibernateDAO dao = new StockHibernateDAO();
		
		//getAll多對一查詢 含供應商資料
		List<StockVO> list = dao.getAll();
		for (StockVO aStock : list) {
			System.out.print(aStock.getStock_id() + ",");
			System.out.print(aStock.getStock_date() + ",");
			System.out.println(aStock.getAdminster_name() + ",");
			// 以下三行寫法為在多方顯示一方資料
			System.out.println("--------------------------");
			System.out.print("廠商資料:(");
			System.out.print(aStock.getSupplierVO().getSupplier_id() + ",");
			System.out.print(aStock.getSupplierVO().getSupplier_name() + ",");
			System.out.print(aStock.getSupplierVO().getChargeperson());
			System.out.print(")");
			System.out.println();
			System.out.println();
		}	
	}
}
