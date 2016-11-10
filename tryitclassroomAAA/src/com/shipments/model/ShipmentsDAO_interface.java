package com.shipments.model;

import java.util.*;
import com.shipments.model.ShipmentsVO;

public interface ShipmentsDAO_interface {
	      public void insert(ShipmentsVO shipmentsVO);
          public void update(ShipmentsVO shipmentsVO);
          public void delete(Integer shipments_no);
          public ShipmentsVO findByPrimaryKey(Integer shipments_no);
	      public List<ShipmentsVO> getAll();
	      //�d�߬Y���������u(�@��h)(�^�� Set)
	     // public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
