package com.adminster.model;

import java.util.*;
import com.shipments.model.ShipmentsVO;

public interface AdminsterDAO_interface {
	      public void insert(AdminsterVO adminsterVO);
          public void update(AdminsterVO adminsterVO);
          public void delete(String adminster_id);
          public AdminsterVO findByPrimaryKey(String adminster_id);
	      public List<AdminsterVO> getAll();
	     // public Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
