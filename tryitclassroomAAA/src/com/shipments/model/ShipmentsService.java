package com.shipments.model;

import java.util.List;
import java.util.Set;
import com.shipments.model.ShipmentsVO;

public class ShipmentsService {

	private ShipmentsDAO_interface dao;

	public ShipmentsService() {
		dao = new ShipmentsDAO();
	}

	public List<ShipmentsVO> getAll() {
		
		return dao.getAll();
	}

	public ShipmentsVO getOneShipments(Integer shipments_no) {
		return dao.findByPrimaryKey(shipments_no);
	}

//	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
//		return dao.getEmpsByDeptno(deptno);
//	}

	public void deleteShipments(Integer shipments_no) {
		dao.delete(shipments_no);
	}
}
