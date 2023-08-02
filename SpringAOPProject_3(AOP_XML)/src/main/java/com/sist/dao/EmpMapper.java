package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
   @Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
		  +"FROM emp")
   public List<EmpVO> empListData();
   
   @Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
		  +"FROM emp "
		  +"WHERE empno=#{empno}")
   public EmpVO empDetailData(int empno);
   
   @Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
		  +"FROM emp "
		  +"WHERE ename LIKE '%'||#{ename}||'%'")
   public List<EmpVO> empFindData(String ename);
}
