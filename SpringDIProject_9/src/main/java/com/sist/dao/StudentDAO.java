package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class StudentDAO extends SqlSessionDaoSupport{
   // 목록 읽기
   /*
    *     <select id="studentListData" resultType="StudentVO">
		   SELECT * FROM student
		  </select>
    */
	public List<StudentVO> studentListData()
	{
		return getSqlSession().selectList("studentListData");
	}
   // 상세보기
	/*
	 *   <select id="studentDetailData" resultType="StudentVO" parameterType="int">
		    SELECT * FROM student
		    WHERE hakbun=#{hakbun}
		  </select>
	 */
	public StudentVO studentDetailData(int hakbun)
	{
		return getSqlSession().selectOne("studentDetailData", hakbun);
	}
   // 검색
	/*
	 *   <select id="studentFindData" resultType="StudentVO" parameterType="string">
		    SELECT * FROM student
		    WHERE name LIKE '%'||#{name}||'%'
		  </select>
	 */
	public List<StudentVO> studentFindData(String name)
	{
		return getSqlSession().selectList("studentFindData", name);
	}
   // 추가 
	/*
	 *  <insert id="studentInsert" parameterType="StudentVO">
	    <selectKey keyProperty="hakbun" order="BEFORE">
	      SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
	    </selectKey>
	    INSERT INTO student VALUES(
	      #{hakbun},
	      #{name},
	      #{kor},
	      #{eng},
	      #{math}
	    )
	  </insert>
	 */
	public void studentInsert(StudentVO vo)
	{
		getSqlSession().insert("studentInsert",vo);
	}
   // 수정
	/*
	 *  <update id="studentUpdate" parameterType="StudentVO">
		    UPDATE student SET
		    name=#{name},kor=#{kor},eng=#{eng},math=#{math}
		    WHERE hakbun=#{hakbun}
		  </update>
	 */
	public void studentUpdate(StudentVO vo)
	{
		getSqlSession().update("studentUpdate",vo);
	}
   // 삭제 
	/*
	 *  <delete id="studentDelete" parameterType="int">
		    DELETE FROM student
		    WHERE hakbun=#{hakbun}
		  </delete>
	 */
	public void studentDelete(int hakbun)
	{
		getSqlSession().delete("studentDelete",hakbun);
	}
}
