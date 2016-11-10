package com.adminster.model;

/*
 Hibernate is providing a factory.getCurrentSession() method for retrieving the current session. A
 new session is opened for the first time of calling this method, and closed when the transaction is
 finished, no matter commit or rollback. But what does it mean by the ��current session��? We need to
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
import com.shipments.model.ShipmentsVO;

public class AdminsterDAO implements AdminsterDAO_interface {

	private static final String GET_ALL_STMT = "from AdminsterVO order by adminster_id";
//	private static final String GET_ALL_STMT = "select shipments_no,order_no,adminster_id,receipt_name,receipt_phone,receipt_address,receiptime from shipments";
	//private static final String DELETE_Orderlist = "delete from orderlistVO where order_no = ?";
	//private static final String DELETE_Shipments = "delete from ShipmentsVO where shipments_no = ?";	
	//private static final String GET_Shipments_ByShipmentsno_STMT = "from EmpVO as empvo where empvo.deptno=? order by empvo.empno";

	@Override
	public void insert(AdminsterVO adminsterVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adminsterVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(AdminsterVO adminsterVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adminsterVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(String adminster_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			AdminsterVO adminstervo = (AdminsterVO) session.get(AdminsterVO.class, adminster_id);
			session.delete(adminstervo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public AdminsterVO findByPrimaryKey(String adminster_id) {
		AdminsterVO adminsterVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			adminsterVO = (AdminsterVO) session.get(AdminsterVO.class, adminster_id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return adminsterVO;
	}

	@Override
	public List<AdminsterVO> getAll() {
		List<AdminsterVO> list = null;
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

		AdminsterDAO dao1 = new AdminsterDAO();
		 //ShipmentsDAO aa = new ShipmentsDAO();
		 
		// �s�W
//		DeptVO deptVO1 = new DeptVO();
//		deptVO1.setDname("�s�y��");
//		deptVO1.setLoc("���ꦿ��");
//		dao.insert(deptVO1);

		// �ק�
//		DeptVO deptVO2 = new DeptVO();
//		deptVO2.setDeptno(10);
//		deptVO2.setDname("�]�ȳ�2");
//		deptVO2.setLoc("�O�W�x�_2");
//		dao.update(deptVO2);

		// �R��
//		dao.delete(30);

		// �d��
//		DeptVO deptVO3 = dao.findByPrimaryKey(10);
//		System.out.print(deptVO3.getDeptno() + ",");
//		System.out.print(deptVO3.getDname() + ",");
//		System.out.println(deptVO3.getLoc());
//		System.out.println("---------------------");

		// �d�߳���
		List<AdminsterVO> list = dao1.getAll();
		for (AdminsterVO aadminster : list) {
			System.out.print(aadminster.getAdminster_id() + ",");
			System.out.print(aadminster.getAdminster_password() + ",");
			System.out.print(aadminster.getAdminster_name() + ",");
			System.out.print(aadminster.getJob_title() + ",");
			System.out.println();
		}
		
		// �d�߬Y���������u
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
