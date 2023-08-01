package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
   @Autowired
   private DataBoardMapper mapper;
   
   /*@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			  +"FROM (SELECT + INDEX_DESC(springDataBoard sdb_no_pk)no,subject,name,regdate,hit "
			  +"FROM springDataBoard)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")*/
	   public List<DataBoardVO> databoardListData(Map map)
	   {
		   return mapper.databoardListData(map);
	   }
	   //@Select("SELECT CEIL(COUNT(*)/10.0) FROM springDataBoard")
	   public int databoardTotalPage()
	   {
		   return mapper.databoardTotalPage();
	   }
	   
	   /*@SelectKey(keyProperty = "no", resultType = int.class , before = true,
			   statement = "SELECT NVL(MAX(no)+1,1) as no FROM springDataBoard")
	   @Insert("INSERT INTO springDataBoard(no,name,subject,content,pwd,filename,filesize,filecount) "
			  +"VALUES(#{no},#{name},#{subject},#{content},"
			  +"#{pwd},#{filename},#{filesize},#{filecount})")*/
	   public void databoardInsert(DataBoardVO vo)
	   {
		   mapper.databoardInsert(vo);
	   }
	   
	   /*@Update("UPDATE springDataBoard SET "
				  +"hit=hit+1 "
				  +"WHERE no=#{no}")
	   public void hitIncrement(int no);
	    @Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
				  +"filename,filesize,filecount "
				  +"FROM springDataBoard "
				  +"WHERE no=#{no}")*/
	  public DataBoardVO databoardDetailData(int no)
	  {
		  mapper.hitIncrement(no);
		  return mapper.databoardDetailData(no);
	  }
	  
	  /*@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
			  +"FROM springDataBoard "
			  +"WHERE ${fs} LIKE '%'||#{ss}||'%'")
	   // $=>컬럼명,테이블명  , #=> 일반 데이터 
	   // 'name',subject,content  ''
	   // WHERE name LIKE '%aaa%'
	   // WHERE 'name' LIKE */
	  
	   public List<DataBoardVO> databoardFindData(Map map)
	   {
		   return mapper.databoardFindData(map);
	   }
	   
	   public DataBoardVO databoardUpdateData(int no)
	   {
		   return mapper.databoardDetailData(no);
	   }
	   
	   /*@Select("SELECT pwd FROM springDataBoard "
				  +"WHERE no=#{no}")
		   public String databoardGetPassword(int no);
		   // 수정 
		 @Update("UPDATE springDataBoard SET "
				  +"name=#{name},subject=#{subject},content=#{content} "
				  +"WHERE no=#{no}")*/
	   public boolean databoardUpdate(DataBoardVO vo)
	   {
		   boolean bCheck=false;
		   String db_pwd=mapper.databoardGetPassword(vo.getNo());
		   if(db_pwd.equals(vo.getPwd()))
		   {
			   bCheck=true;
			   mapper.databoardUpdate(vo);
		   }
		   return bCheck;
	   }
	   
	   //@Delete("DELETE FROM springDataBoard WHERE no=#{no}")
	   public boolean databoardDelete(int no,String pwd)
	   {
		   boolean bCheck=false;
		   String db_pwd=mapper.databoardGetPassword(no);
		   if(db_pwd.equals(pwd))
		   {
			   bCheck=true;
			   mapper.databoardDelete(no);
		   }
		   return bCheck;
	   }
}
