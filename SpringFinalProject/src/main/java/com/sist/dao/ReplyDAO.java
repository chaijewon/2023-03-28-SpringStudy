package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class ReplyDAO {
  @Autowired
  private ReplyMapper mapper;
  
  /*@Select("SELECT no,fno,id,name,msg,TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday "
			 +"FROM springReply "
			 +"WHERE fno=#{fno}")*/
  public List<ReplyVO> replyListData(int fno)
  {
	  return mapper.replyListData(fno);
  }
	  
  /*@Insert("INSERT INTO springReply VALUES("
			 +"srp_no_seq.nextval,#{fno},#{id},#{name},"
			 +"#{msg},SYSDATE)")*/
  public void replyInsert(ReplyVO vo)
  {
	  mapper.replyInsert(vo);
  }
  
  /*@Select("SELECT name,msg,rownum "
		  +"FROM springReply "
		  +"WHERE fno=#{fno} AND rownum<=1")*/
   public ReplyVO foodReplyData(int fno)
   {
	   return mapper.foodReplyData(fno);
   }
   
   //@Select("SELECT COUNT(*) FROM WHERE fno=#{fno}")
   public int foodReplyCount(int fno)
   {
	   return mapper.foodReplyCount(fno);
   }
   //@Delete("DELETE FROM springReply WHERE no=#{no}")
   public void replyDelete(int no)
   {
	   mapper.replyDelete(no);
   }
   /*@Update("UPDATE springReply SET "
			 +"msg=#{msg} "
			 +"WHERE no=#{no}")*/
   public void replyUpdate(ReplyVO vo)
   {
	   mapper.replyUpdate(vo);
   }
}
