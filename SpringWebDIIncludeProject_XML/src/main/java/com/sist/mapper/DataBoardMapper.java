package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sist.vo.*;

public interface DataBoardMapper {
   @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT /*+ INDEX_DESC(springDataBoard sdb_no_pk)*/no,subject,name,regdate,hit "
		  +"FROM springDataBoard)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<DataBoardVO> databoardListData(Map map);
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM springDataBoard")
   public int databoardTotalPage();
   
   @SelectKey(keyProperty = "no", resultType = int.class , before = true,
		   statement = "SELECT NVL(MAX(no)+1,1) as no FROM springDataBoard")
   @Insert("INSERT INTO springDataBoard(no,name,subject,content,pwd,filename,filesize,filecount) "
		  +"VALUES(#{no},#{name},#{subject},#{content},"
		  +"#{pwd},#{filename},#{filesize},#{filecount})")
   public void databoardInsert(DataBoardVO vo);
   
}
