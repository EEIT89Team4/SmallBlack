package com.supplier.model;

import java.util.List;
import java.util.Set;

import com.supplier.model.SupplierVO;

public class SupplierService {

	private SupplierDAO_interface dao;

	public SupplierService() {
		dao = new SupplierDAO();
	}
	
	public SupplierVO addSupplier(String suppliername, String chargepersonname) {

		SupplierVO supplierVO = new SupplierVO();

		supplierVO.setSupplier_name(suppliername);
		supplierVO.setChargeperson(chargepersonname);
		dao.insert(supplierVO);

		return supplierVO;
	}

	//預留給 Struts 2 用的
	public void addSupplier(SupplierVO supplierVO) {
		dao.insert(supplierVO);
	}
	
	public SupplierVO updateSupplier(Integer supplier_id, String supplier_name, String chargeperson) {

		SupplierVO supplierVO = new SupplierVO();

		supplierVO.setSupplier_id(supplier_id);
		supplierVO.setSupplier_name(supplier_name);
		supplierVO.setChargeperson(chargeperson);
		
		dao.update(supplierVO);

		return dao.findByPrimaryKey(supplier_id);
	}
	

	public List<SupplierVO> getAll() {
		
		return dao.getAll();
	}

	public SupplierVO getOneSupplier(Integer supplier_id) {
		return dao.findByPrimaryKey(supplier_id);
	}

//	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
//		return dao.getEmpsByDeptno(deptno);
//	}

	public void deleteSupplier(Integer supplier_id) {
		dao.delete(supplier_id);
	}
}
