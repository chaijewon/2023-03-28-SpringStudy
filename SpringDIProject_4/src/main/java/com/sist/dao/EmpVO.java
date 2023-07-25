package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*
 * public List<CategoryVO> foodCategoryListData()
   {
	   List<CategoryVO> list=new ArrayList<CategoryVO>();
	   try
	   {
		   conn=db.getConnection();
		   String sql="SELECT + INDEX_ASC(food_category fc_cno_pk) cno,title,subject,poster "
				     +"FROM food_category";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   CategoryVO vo=new CategoryVO();
			   vo.setCno(rs.getInt(1));
			   vo.setTitle(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setPoster(rs.getString(4));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   db.disConnection(conn, ps);
	   }
	   return list;
   }
   
   public List<CategoryVO> foodCategoryListData()
   {
      return selectList(sql)
   }
 */
@Getter
@Setter
public class EmpVO {
   private int empno,mgr,sal,deptno,comm;
   private String ename,job,dbday;
   private Date hiredate;
}
