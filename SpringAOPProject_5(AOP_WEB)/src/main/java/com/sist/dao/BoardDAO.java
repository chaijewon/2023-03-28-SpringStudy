package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   //목록 
   /*@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT no,subject,name,regdate,hit "
		  +"FROM springReplyBoard ORDER BY group_id DESC,group_step ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")*/
   public List<BoardVO> boardListData(Map map)
   {
	   return mapper.boardListData(map);
   }
   //@Select("SELECT CEIL(COUNT(*)/10.0) FROM springReplyBoard")
   public int boardTotalPage()
   {
	   return mapper.boardTotalPage();
   }
   //추가 
   /*@Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id) "
		  +"VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
		  +"(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))")*/
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   //상세보기 
   /*@Update("UPDATE springReplyBoard SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
   public void hitIncrement(int no);
   @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
		  +"FROM springReplyBoard "
		  +"WHERE no=#{no}")*/
   public BoardVO boardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetailData(no);
   }
   //답변 ======== 트랙잭션 (스프링 : AOP)
   /*@Select("SELECT group_id,group_step,group_tab "
		  +"FROM springReplyBoard "
		  +"WHERE no=#{no}")
   public BoardVO boardParentInfoData(int no);
   
   @Update("UPDATE springReplyBoard SET "
		  +"group_step=group_step+1 "
		  +"WHERE group_id=#{group_id} AND group_step>#{group_step}")
   public void boardGroupStepIncrement(BoardVO vo);
   @Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab,root)) "
		  +"VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
		  +"#{group_id},#{group_step},#{group_tab},#{root})")
   public void boardReplyInsert(BoardVO vo);
   
   @Update("UPDATE springReplyBoard SET "
		  +"depth=depth+1 "
		  +"WHERE no=#{no}")
   public void boardDepthIncrement(int no);*/
   /*
    *   여러 작업을 진행하다가 문제가 생겼을 경우 이전 상태로 롤백하기 위해 사용
    */
   @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
   public void boardReplyInsert(int root,BoardVO vo)
   {
	   BoardVO pvo=mapper.boardParentInfoData(root);
	   mapper.boardGroupStepIncrement(pvo);
	   vo.setGroup_id(pvo.getGroup_id());
	   vo.setGroup_step(pvo.getGroup_step()+1);
	   vo.setGroup_tab(pvo.getGroup_tab()+1);
	   vo.setRoot(root);
	   mapper.boardReplyInsert(vo);
	   mapper.boardDepthIncrement(root);
   }
}
