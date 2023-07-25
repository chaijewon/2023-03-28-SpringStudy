package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {
  /*
   *   <select id="empListaData" resultType="EmpVO" parameterType="int">
   *     SELECT ~~
   *   </select>
   *   
   *   id => method명 
   *   resultType => 리턴형
   *   parameterType => 매개변수 
   *   
   *   public List<EmpVO> empListData(int empno)
   */
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
		   +"TO_CHAR(sal,'$999,999') as dbsal,deptno,comm "
		   +"FROM emp")
	public List<EmpVO> empListData();
	@Select("SELECT empno,ename,job,mgr,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
		   +"TO_CHAR(sal,'$999,999') as dbsal,NVL(comm,0) as comm,deptno "
		   +"FROM emp "
		   +"WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
	// 검색 
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
			   +"TO_CHAR(sal,'$999,999') as dbsal,deptno,comm "
			   +"FROM emp "
			   +"WHERE ename LIKE '%'||#{ename}||'%'")
    public List<EmpVO> empFindData(String ename);
}







