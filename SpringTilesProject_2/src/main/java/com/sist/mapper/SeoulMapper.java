package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.SeoulVO;
public interface SeoulMapper {
	/*
	 *   CREATE OR REPLACE PROCEDURE seoulListData(
		   pNo NUMBER,
		   pStart NUMBER,
		   pEnd NUMBER,
		   pResult OUT SYS_REFCURSOR
		)
		IS
		BEGIN
		   IF pNo=1 THEN
		     OPEN pResult FOR
		       SELECT no,title,poster,msg,address,num
		       FROM (SELECT no,title,poster,msg,address,rownum as num
		       FROM (SELECT no,title,poster,msg,address
		       FROM seoul_location ORDER BY no ASC))
		       WHERE num BETWEEN pStart AND pEnd;
		   ELSIF pNo=2 THEN
		      OPEN pResult FOR
		       SELECT no,title,poster,msg,address,num
		       FROM (SELECT no,title,poster,msg,address,rownum as num
		       FROM (SELECT no,title,poster,msg,address
		       FROM seoul_nature ORDER BY no ASC))
		       WHERE num BETWEEN pStart AND pEnd;
		   ELSIF pNo=3 THEN
		      OPEN pResult FOR
		       SELECT no,title,poster,msg,address,num
		       FROM (SELECT no,title,poster,msg,address,rownum as num
		       FROM (SELECT no,title,poster,msg,address
		       FROM seoul_shop ORDER BY no ASC))
		       WHERE num BETWEEN pStart AND pEnd;
		   END IF;
		END;
		/
	 */
   @Select(value="{CALL seoulListData(#{pNo,mode=IN,javaType=java.lang.Integer},#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
   @Options(statementType = StatementType.CALLABLE)
   public List<SeoulVO> seoulListData(Map map);
   /*
    *   CREATE OR REPLACE PROCEDURE seoulTotalPage(
		   pNo NUMBER,
		   pTotal OUT NUMBER
		)
		IS
		BEGIN
		   IF pNo=1 THEN
		     SELECT CEIL(COUNT(*)/20.0) INTO pTotal
		     FROM seoul_location;
		   ELSIF pNo=2 THEN
		     SELECT CEIL(COUNT(*)/20.0) INTO pTotal
		     FROM seoul_nature;
		   ELSIF pNo=3 THEN
		     SELECT CEIL(COUNT(*)/20.0) INTO pTotal
		     FROM seoul_shop;
		   END IF;
		END;
		/
    */
   @Select(value="{CALL seoulTotalPage(#{pNo,mode=IN,javaType=java.lang.Integer},#{pTotal,mode=OUT,jdbcType=INTEGER})")
   @Options(statementType = StatementType.CALLABLE)
   public Integer seoulTotalPage(Map map);
   
   /*
    *    <select id="seoulDetailData" resultType="com.sist.vo.SeoulVO" parameterType="hashmap">
		   SELECT no,title,poster,msg,address
		   FROM ${table_name}
		   WHERE no=#{no}
		 </select>
    */
   //     resultType id           parameterType
   public SeoulVO seoulDetailData(Map map);
}





