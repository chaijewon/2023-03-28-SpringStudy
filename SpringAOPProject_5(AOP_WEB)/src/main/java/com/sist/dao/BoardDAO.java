package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
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
    *   ▶ 원자성(Atomicity)
		 - 한 트랜잭션 내에서 실행한 작업들은 하나로 간주한다. 즉, 모두 성공 또는 모두 실패. 
		▶ 일관성(Consistency)
		 - 트랜잭션은 일관성 있는 데이타베이스 상태를 유지한다. (data integrity 만족 등.)
		▶ 격리성(Isolation)
		 - 동시에 실행되는 트랜잭션들이 서로 영향을 미치지 않도록 격리해야한다.
		▶ 지속성(Durability)
		 - 트랜잭션을 성공적으로 마치면 결과가 항상 저장되어야 한다.
		 
		스프링에서는 트랜잭션 처리를 지원하는데 그중 어노테이션 방식으로 @Transactional을 선언하여 사용하는 방법이 일반적이며, 
		선언적 트랜잭션이라 부른다.
        클래스, 메서드위에 @Transactional 이 추가되면, 
        이 클래스에 트랜잭션 기능이 적용된 프록시 객체가 생성된다.
        이 프록시 객체는 @Transactional이 포함된 메소드가 호출 될 경우, 
        PlatformTransactionManager를 사용하여 트랜잭션을 시작하고, 
        정상 여부에 따라 Commit 또는 Rollback 한다.
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
   public BoardVO boardUpdateData(int no)
   {
	   return mapper.boardDetailData(no);
   }
   /*@Select("SELECT pwd FROM springReplyBoard "
			  +"WHERE no=#{no}")
   public String boardGetPassword(int no);
   @Update("UPDATE springReplyBoard SET "
			  +"name=#{name},subject=#{subject},content=#{content} "
			  +"WHERE no=#{no}")*/
   public boolean boardUpdate(BoardVO vo)
   {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(vo.getNo());
	   if(db_pwd.equals(vo.getPwd()))
	   {
		   bCheck=true;
		   mapper.boardUpdate(vo);
	   }
	   return bCheck;
   }
   /*@Select("SELECT root,depth FROM springReplyBoard "
			  +"WHERE no=#{no}")
	   public BoardVO boardInfoData(int no);
	   @Update("UPDATE springReplyBoard SET "
			  +"subject='관리자가 삭제한 게시물입니다',content='관리자가 삭제한 게시물입니다' "
			  +"WHERE no=#{no}")
	   public void boardSubjectUpdate(int no); commit
	   @Delete("DELETE FROM springReplyBoard "
			  +"WHERE no=#{no}")
	   public void boardDelete(int no); commit
	   @Update("UPDATE springReplyBoard SET "
			  +"depth=depth-1 "
			  +"WHERE no=#{no}")
	   public void boardDepthDecrement(int no);*/ 
   /*
    *   1. 트랜잭션 
    *      = 여러개의 SQL문장(DML=INSERT,UPDATE,DELETE)을 하나의 그룹으로 묶어서 처리하는 단위 
    *      = 물리적으로는 여러개의 SQL문장 수행 => 논리적으로 하나의 작업으로 인식 
    *      = 일괄처리 
    *   2. TransactionManager를 등록 : XML 
    *       <tx:annotation-driven/>
		    <bean id="transactionManager"
		       class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
		       p:dataSource-ref="ds"
		    />    
		3. 전파
		   Propagation.REQUIRED : 기본형 
		      트랜잭션을 사용중이중이면 => 다음에 다시 재사용이 가능해게 만든다 
		      => 시작할때만 한번 생성 
		      public void delete()
		      {
		         try
		         {
		            conn.setAutoCommit(false) ==> @Around
		            ----------------
		              개발자 소스
		              boardDelete
		            ----------------
		            conn.commit()
		         }catch(Exception ex)
		         {
		            conn.rollback() ==> @AfterThrowing
		         }
		         finally
		         {
		            conn.setAutoCommit(true)  ==> @After
		         } 
		      }
		   Propagation.REQUIRED_NEW : 무조건 새롭게 생성 
		   Propagation.NAVER : 트랜잭션을 무조건 설정 
		   
    */
   @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
   public boolean boardDelete(int no,String pwd)
   {
	   boolean bCheck=false;
	   // 비밀번호 읽기
	   String db_pwd=mapper.boardGetPassword(no);
	   if(db_pwd.equals(pwd))
	   {
		   bCheck=true;
		   // 삭제할 수 있는 게시물인지 확인 => depth
		   BoardVO vo=mapper.boardInfoData(no);
		   if(vo.getDepth()==0)
		   {
			   mapper.boardDelete(no);
		   }
		   else
		   {
			   mapper.boardSubjectUpdate(no);
		   }
		   mapper.boardDepthDecrement(vo.getRoot());
	   }
	   else
	   {
		   bCheck=false;
	   }
	   return bCheck;
   }
   public List<BoardVO> boardFindData(Map map)
   {
	   return mapper.boardFindData(map);
   }
}
