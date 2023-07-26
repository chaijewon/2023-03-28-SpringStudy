package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.EmpVO;
public interface EmpMapper {
  @Select("SELECT empno,ename,job,hiredate,sal "
		 +"FROM emp")
  public List<EmpVO> empListData();
  
  @Select("SELECT empno,ename,job,hiredate,sal,deptno,comm "
		 +"FROM emp "
		 +"WHERE empno=#{empno}")
  public EmpVO empDetailData(int empno);
}
