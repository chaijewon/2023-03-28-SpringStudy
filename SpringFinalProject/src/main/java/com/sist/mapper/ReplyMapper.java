package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.ReplyVO;
public interface ReplyMapper {
  @Select("SELECT COUNT(*) FROM springReply WHERE fno=#{fno}")
  public int foodReplyCount(int fno);
  
  @Select("SELECT name,msg,rownum "
			  +"FROM springReply "
			  +"WHERE fno=#{fno} AND rownum<=1")
  public ReplyVO foodReplyData(int fno);
  
  @Select("SELECT /*+ INDEX_DESC(springReply srp_no_pk)*/no,fno,id,name,msg,TO_CHAR(regdate,'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\" mi\"분\" ss\"초\"') as dbday "
		 +"FROM springReply "
		 +"WHERE fno=#{fno}")
		 
  public List<ReplyVO> replyListData(int fno);
  
  @Insert("INSERT INTO springReply VALUES("
		 +"srp_no_seq.nextval,#{fno},#{id},#{name},"
		 +"#{msg},SYSDATE)")
  public void replyInsert(ReplyVO vo);
  // 수정 
  @Update("UPDATE springReply SET "
		 +"msg=#{msg} "
		 +"WHERE no=#{no}")
  public void replyUpdate(ReplyVO vo);
  // 삭제 
  @Delete("DELETE FROM springReply WHERE no=#{no}")
  public void replyDelete(int no);
}
