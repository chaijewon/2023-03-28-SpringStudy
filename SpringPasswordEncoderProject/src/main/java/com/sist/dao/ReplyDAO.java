package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class ReplyDAO {
   @Autowired
   private ReplyMapper mapper;
   
   public List<ReplyVO> replyListData(int fno)
   {
	   return mapper.replyListData(fno);
   }
   public void replyInsert(ReplyVO vo)
   {
	   mapper.replyInsert(vo);
   }
   //@Delete("DELETE FROM springTestReply WHERE no=#{no}")
	public void replyDelete(int no)
	{
		mapper.replyDelete(no);
	}
}
