package com.sist.dao2;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper2.EmpDeptMapper;
import com.sist.vo.*;
@Repository
public class EmpDAO {
	 // 스프링으로부터 자동 주입을 받는다 \
	 @Autowired
	 private EmpDeptMapper mapper;
	 /*@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
			 +"sal,dname,loc "
			 +"FROM emp,dept "
			 +"WHERE emp.deptno=dept.deptno "
			 +"ORDER BY sal DESC")*/
	  public List<EmpVO> empdeptListData()
	  {
		  return mapper.empdeptListData();
	  }
	  
	  /*@Results({
		  @Result(column = "dname",property = "dvo.dname"),
		  @Result(column = "loc",property = "dvo.loc")
	  })
	  @Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
			 +"sal,dname,loc "
			 +"FROM emp,dept "
			 +"WHERE emp.deptno=dept.deptno "
			 +"AND empno=#{empno}")*/
	  public EmpVO empdeptDetailData(int empno)
	  {
		  return mapper.empdeptDetailData(empno);
	  }
}
