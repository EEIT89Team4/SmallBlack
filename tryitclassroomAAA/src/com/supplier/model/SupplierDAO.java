package com.supplier.model;

/*
 Hibernate is providing a factory.getCurrentSession() method for retrieving the current session. A
 new session is opened for the first time of calling this method, and closed when the transaction is
 finished, no matter commit or rollback. But what does it mean by the ¨current session〃? We need to
 tell Hibernate that it should be the session bound with the current thread.

 <hibernate-configuration>
 <session-factory>
 ...
 <property name="current_session_context_class">thread</property>
 ...
 </session-factory>
 </hibernate-configuration>

 */


import org.hibernate.*;
import hibernate.util.HibernateUtil;
import java.util.*;

//import com.emp.model.EmpVO;
import com.supplier.model.SupplierVO;

public class SupplierDAO implements SupplierDAO_interface {
	/* 猔種:
       A. ヘ玡琌˙代刚Hibernate膀セ
       B. ヘ玡﹟ぃHibernate┮
    */
	private static final String GET_ALL_STMT = "from SupplierVO order by supplier_id";
//	private static final String GET_ALL_STMT = "select shipments_no,order_no,adminster_id,receipt_name,receipt_phone,receipt_address,receiptime from shipments";
	//private static final String DELETE_Orderlist = "delete from orderlistVO where order_no = ?";
	//private static final String DELETE_Shipments = "delete from ShipmentsVO where shipments_no = ?";	
	//private static final String GET_Shipments_ByShipmentsno_STMT = "from EmpVO as empvo where empvo.deptno=? order by empvo.empno";

	@Override
	public void insert(SupplierVO supplierVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(supplierVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(SupplierVO supplierVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(supplierVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer supplier_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			SupplierVO suppliervo = (SupplierVO) session.get(SupplierVO.class, supplier_id);
			session.delete(suppliervo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public SupplierVO findByPrimaryKey(Integer supplier_id) {
		SupplierVO supplierVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			supplierVO = (SupplierVO) session.get(SupplierVO.class, supplier_id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return supplierVO;
	}

	@Override
	public List<SupplierVO> getAll() {
		List<SupplierVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
//			Query query = session.createSQLQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
//	@Override
//	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {		
//		Set<EmpVO> set = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery(GET_Emps_ByDeptno_STMT);
//			query.setParameter(0, deptno);
//			List list = query.list();
//			set = new HashSet<EmpVO>(list);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return set;
//	}

	public static void main(String[] args) {

		SupplierDAO dao1 = new SupplierDAO();
		 //ShipmentsDAO aa = new ShipmentsDAO();
		 
		// 穝糤
//		DeptVO deptVO1 = new DeptVO();
//		deptVO1.setDname("籹硑场");
//		deptVO1.setLoc("い瓣﹁");
//		dao.insert(deptVO1);

		// э
//		DeptVO deptVO2 = new DeptVO();
//		deptVO2.setDeptno(10);
//		deptVO2.setDname("癩叭场2");
//		deptVO2.setLoc("籓芖2");
//		dao.update(deptVO2);

		// 埃
//		dao.delete(30);

		// 琩高
//		DeptVO deptVO3 = dao.findByPrimaryKey(10);
//		System.out.print(deptVO3.getDeptno() + ",");
//		System.out.print(deptVO3.getDname() + ",");
//		System.out.println(deptVO3.getLoc());
//		System.out.println("---------------------");

		// 琩高场
		List<SupplierVO> list = dao1.getAll();
		for (SupplierVO aShipments : list) {
			System.out.print(aShipments.getSupplier_id() + ",");
			System.out.print(aShipments.getSupplier_name() + ",");
			System.out.print(aShipments.getChargeperson() + ",");
			System.out.println();
		}
		
		// 琩高琘场
//		Set<EmpVO> set = dao.getEmpsByDeptno(10);
//		for (EmpVO aEmp : set) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
//			System.out.println();
//		}
	}
}
