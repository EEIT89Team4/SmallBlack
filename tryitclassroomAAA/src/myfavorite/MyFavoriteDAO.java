package myfavorite;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.member.model.MemberVO;
import com.product.model.ProductDAO;
import com.product.model.ProductVO;

import hibernate.util.HibernateUtil;

public class MyFavoriteDAO {

	public void insert(MyFavoriteVO myfavoriteVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(myfavoriteVO);
			tx.commit();
		} catch (RuntimeException ex) {
			tx.rollback();
		}
	}

//	public void update(MyFavoriteVO myfavoriteVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.saveOrUpdate(myfavoriteVO);
//			tx.commit();
//		} catch (RuntimeException ex) {
//			tx.rollback();
//		}
//
//	}
//
	public void delete(MyFavoriteVO myfavoriteVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		MyFavoriteVO myfavorite = null;
		try {
			tx = session.beginTransaction();
			myfavorite = (MyFavoriteVO) session.get(MyFavoriteVO.class, myfavoriteVO);
			session.delete(myfavorite);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
		}
	}

	public List<MyFavoriteVO> getMyFavoriteById(MyFavoriteVO myfavoriteVO) {
		MyFavoriteVO myfavorite = null;
		Transaction tx = null;
		List<MyFavoriteVO> list = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			
//			myfavorite = (MyFavoriteVO) session.get(MyFavoriteVO.class, myfavoriteVO);
			Query query=session.createQuery("from MyFavoriteVO where member_no=?");
//			query.setParameter(0, myfavoriteVO.getProductVO().getProduct_no());
			query.setParameter(0, myfavoriteVO.getMemberVO().getMember_no());
			list = query.list();
			
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return list;
	}

//	public List<MyFavoriteVO> getAllMyFavorite() {
//		List<MyFavoriteVO> list = null;
//		Transaction tx = null;
//		try {
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			tx = session.beginTransaction();
//			Query query = session.createQuery("from MyFavoriteVO ");
//			list = query.list();
//		} catch (RuntimeException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}
//		return list;
//
//	}

	public static void main(String args[]) {

		// ���է�� �~��
//		 MyFavoriteDAO myFavoriteDAO = new MyFavoriteDAO();
//		 productvo=productdao.getProductById(3001);
//		 productvo.setWeight(777);
//		 productdao.update(productvo);
		// �s�W�~��
//		MyFavoriteDAO myFavoriteDAO = new MyFavoriteDAO();
//		ProductVO product = new ProductVO();
//		 product.setProduct_no(3001);
//		 MemberVO member = new MemberVO();
//		 member.setMember_no(121);
//		 
//		 MyFavoriteVO myfavoriteVO=new MyFavoriteVO();
//		 myfavoriteVO.setProductVO(product);
//		 myfavoriteVO.setMemberVO(member);
//		 
//		 myFavoriteDAO.insert(myfavoriteVO);


		// �R������
//		 MyFavoriteDAO myFavoriteDAO = new MyFavoriteDAO();
//		 
//		 ProductVO product = new ProductVO();
//		 product.setProduct_no(3001);
//		 MemberVO member = new MemberVO();
//		 member.setMember_no(121);
//		 
//		 MyFavoriteVO myfavoriteVO=new MyFavoriteVO();
//		 myfavoriteVO.setProductVO(product);
//		 myfavoriteVO.setMemberVO(member);
//		 
//		 myFavoriteDAO.delete(myfavoriteVO);
		
		// �d�߳�@���~
		 MyFavoriteDAO myFavoriteDAO = new MyFavoriteDAO();
		 MyFavoriteVO myfavoriteVO=new MyFavoriteVO();
		 
		 MemberVO member = new MemberVO();
		 member.setMember_no(121);

		 myfavoriteVO.setMemberVO(member);

		 List<MyFavoriteVO> list = myFavoriteDAO.getMyFavoriteById(myfavoriteVO);
		 for(MyFavoriteVO myfavorite: list){
		 System.out.println(myfavorite.getProductVO().getProduct_no());
		 System.out.println(myfavorite.getMemberVO().getMember_no());
		 System.out.println(myfavorite.getProductVO().getProduct_name());
		 }

		 
		// �d�ߥ������~
//		 MyFavoriteDAO myFavoriteDAO = new MyFavoriteDAO();
//		 List<MyFavoriteVO> list=myFavoriteDAO.getAllMyFavorite();
//		 for (MyFavoriteVO myfavorite :list){
//		 System.out.println(myfavorite.getProductVO().getProduct_no());
//		 System.out.println(myfavorite.getMemberVO().getMember_no());
//		 System.out.println(myfavorite.getProductVO().getProduct_name());
//		 }
	}
}
