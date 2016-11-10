package com.supplier.model;

import java.util.*;
import com.supplier.model.SupplierVO;

public interface SupplierDAO_interface {
	      public void insert(SupplierVO SupplierVO);
          public void update(SupplierVO SupplierVO);
          public void delete(Integer supplier_id);
          public SupplierVO findByPrimaryKey(Integer supplier_id);
	      public List<SupplierVO> getAll();
	      //�d�߬Y���������u(�@��h)(�^�� Set)
	     // public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
