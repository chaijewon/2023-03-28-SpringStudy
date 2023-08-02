package com.sist.mapper2;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;
public interface EmpDeptMapper {
  /*
   *   <resultMap type="com.sist.vo.EmpVO" id="empMap">
	     <result column="dname" property="dvo.dname"/>
	     <result column="loc" property="dvo.loc"/>
	   </resultMap>
   */
  @Results({
	  @Result(column = "dname",property = "dvo.dname"),
	  @Result(column = "loc",property = "dvo.loc")
  })
  /*
   *   <select id="empdeptListData" resultMap="empMap">
	     SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,
	            sal,dname,loc
	     FROM emp,dept
	     WHERE emp.deptno=dept.deptno
	     ORDER BY sal DESC
	   </select>
   */
  @Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
		 +"sal,dname,loc "
		 +"FROM emp,dept "
		 +"WHERE emp.deptno=dept.deptno "
		 +"ORDER BY sal DESC")
  public List<EmpVO> empdeptListData();
  
  @Results({
	  @Result(column = "dname",property = "dvo.dname"),
	  @Result(column = "loc",property = "dvo.loc")
  })
  @Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
		 +"sal,dname,loc "
		 +"FROM emp,dept "
		 +"WHERE emp.deptno=dept.deptno "
		 +"AND empno=#{empno}")
  public EmpVO empdeptDetailData(int empno);
}
