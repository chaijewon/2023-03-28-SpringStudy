package com.sist.main;
import java.util.*;

import lombok.Setter;

import java.sql.*;
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   private String driver;
   @Setter
   private String url;
   @Setter
   private String username;
   @Setter
   private String password;
   
   public EmpDAO(String driver)
   {
	   try
	   {
		   Class.forName(driver);
	   }catch(Exception ex){}
   }
   
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(url,username,password);
	   }catch(Exception ex){}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   
   public List<EmpVO> empListData()
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT empno,ename,job,hiredate,sal "
				     +"FROM emp";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setHiredate(rs.getDate(4));
			   vo.setSal(rs.getInt(5));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   // ====> properties 
   /*
    *     스프링에 클래스 등록 => 스프링이 관리 
    *                        ==========
    *                        ------------------------------
    *                        1. 객체 생성  
    *                        2. 객체의 멤버변수에 대한 초기값 주입 
    *                        3. 객체 해제 
    *                        ------------------------------ DI
    *                          = 일반 멤버변수 
    *                          = 객체 주소 (ref)
    *       
    *       <bean id="b" class="B" p:a-ref="a">
    *       <bean id="a" class="A">
    *       
    *       A a=new A()
    *       B b=new B()
    *       b.setA(a)
    *       
    */
}
