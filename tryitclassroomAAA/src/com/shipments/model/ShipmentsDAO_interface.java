package com.shipments.model;

import java.util.*;
import com.shipments.model.ShipmentsVO;

public interface ShipmentsDAO_interface {
	      public void insert(ShipmentsVO shipmentsVO);
          public void update(ShipmentsVO shipmentsVO);
          public void delete(Integer shipments_no);
          public ShipmentsVO findByPrimaryKey(Integer shipments_no);
	      public List<ShipmentsVO> getAll();
	      //查詢某部門的員工(一對多)(回傳 Set)
	     // public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
