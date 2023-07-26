package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
@Repository
public class EmpDAO {
  @Autowired
  private EmpMapper mapper;
  
  /*@Select("SELECT empno,ename,job,hiredate,sal "
			 +"FROM emp")*/
  public List<EmpVO> empListData()
  {
	  return mapper.empListData();
  }
	  
  /*@Select("SELECT empno,ename,job,hiredate,sal,deptno,comm "
			 +"FROM emp "
			 +"WHERE empno=#{empno}")*/
  public EmpVO empDetailData(int empno)
  {
	  return mapper.empDetailData(empno);
  }
}
