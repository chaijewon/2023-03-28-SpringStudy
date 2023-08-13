package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
/*
 *     데이터 저장 => mounted => render() => HTML에 데이터 출력 
 *     ---------------------------------------------------
 *                    | 
 *                  데이터가 변경 : updated => render() => HTML 변경 
 *                                 |
 *                               data:{} => 안에 있는 변수값이 변경시에 호출  
 */
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
	/*@Update("UPDATE springTestReply SET "
			   +"msg=#{msg} "
			   +"WHERE no=#{no}")*/
    public void replyUpdate(ReplyVO vo)
    {
    	mapper.replyUpdate(vo);
    }
}
