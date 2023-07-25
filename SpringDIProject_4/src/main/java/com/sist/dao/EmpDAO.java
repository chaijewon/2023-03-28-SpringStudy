package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class EmpDAO extends SqlSessionDaoSupport{
	
   public List<EmpVO> empListData()
   {
	   return getSqlSession().selectList("empListData");
   }
   public EmpVO empDetailData(int empno)
   {
	   return getSqlSession().selectOne("empDetailData",empno);
   }
}
