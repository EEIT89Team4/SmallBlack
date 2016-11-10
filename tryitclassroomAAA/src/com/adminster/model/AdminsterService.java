package com.adminster.model;

import java.util.List;
import java.util.Set;
import com.shipments.model.ShipmentsVO;

public class AdminsterService {

	private AdminsterDAO_interface dao;

	public AdminsterService() {
		dao = new AdminsterDAO();
	}

	public List<AdminsterVO> getAll() {
		
		return dao.getAll();
	}

	public AdminsterVO getOneAdminster(String adminster_id) {
		return dao.findByPrimaryKey(adminster_id);
	}

//	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
//		return dao.getEmpsByDeptno(deptno);
//	}

	public void deleteAdminster(String adminster_id) {
		dao.delete(adminster_id);
	}
	
	public AdminsterVO checkIDPassword(String adminster_id, String adminster_password) {
		// 將 MemberDAO new為物件，放入變數dao內
		AdminsterDAO dao = new AdminsterDAO();
		// 透過變數dao，呼叫它的select()方法，要傳入參數 id。將傳回值放入變數
        // MemberBean mb 內。
		AdminsterVO adminsterVO = dao.findByPrimaryKey(adminster_id);
        // 如果mb不等於 null 而且參數 password等於mb內的password) {
        if ( adminsterVO != null && adminster_password.equals(adminsterVO.getAdminster_password())) {
        	// 傳回 mb物件，同時結束本方法
        	 return adminsterVO;
        }
        // 傳回null物件
		return null;
	}
	
	
	
}
