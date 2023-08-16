package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
   @Select("SELECT COUNT(*) FROM springMember "
		  +"WHERE id=#{id}")
   public int memberIdCheck(String id);
   @Select("SELECT COUNT(*) FROM springMember "
		  +"WHERE email=#{email}")
   public int memberEmailCheck(String email);
   /*
    *   ID       NOT NULL VARCHAR2(1000) 
		PWD      NOT NULL VARCHAR2(1000) 
		NAME     NOT NULL VARCHAR2(51)   
		SEX               VARCHAR2(6)    
		BIRTHDAY NOT NULL VARCHAR2(30)   
		EMAIL             VARCHAR2(100)  
		POST     NOT NULL VARCHAR2(10)   
		ADDR1    NOT NULL VARCHAR2(200)  
		ADDR2             VARCHAR2(200)  
		PHONE             VARCHAR2(30)   
		CONTENT           CLOB           
		ADMIN             CHAR(1)        
		REGDATE           DATE 
    */
   @Insert("INSERT INTO springMember VALUES("
		  +"#{id},#{pwd},#{name},#{sex},#{birthday},#{email},"
		  +"#{post},#{addr1},#{addr2},#{phone},"
		  +"#{content},'n',SYSDATE,'ROLE_USER')")
   public void memberInsert(MemberVO vo);
}
