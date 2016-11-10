package com.supplier.model;

import java.util.*;
import com.supplier.model.SupplierVO;

public interface SupplierDAO_interface {
	      public void insert(SupplierVO SupplierVO);
          public void update(SupplierVO SupplierVO);
          public void delete(Integer supplier_id);
          public SupplierVO findByPrimaryKey(Integer supplier_id);
	      public List<SupplierVO> getAll();
	      //查詢某部門的員工(一對多)(回傳 Set)
	     // public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
