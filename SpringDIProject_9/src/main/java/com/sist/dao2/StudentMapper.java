package com.sist.dao2;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
public interface StudentMapper {
  /*
   *      <select id="studentListData" resultType="StudentVO">
		   SELECT * FROM student
		  </select>
   */
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	/*
	 *  <select id="studentDetailData" resultType="StudentVO" parameterType="int">
		    SELECT * FROM student
		    WHERE hakbun=#{hakbun}
		  </select>
	 */
	@Select("SELECT * FROM student " 
		  +"WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	/*
	 *   <select id="studentFindData" resultType="StudentVO" parameterType="string">
		    SELECT * FROM student WHERE name LIKE '%'||#{name}||'%'
		  </select>
	 */
	
	@Select("SELECT * FROM student WHERE name LIKE '%'||#{name}||'%'")
	public List<StudentVO> studentFindData(String name);
	
	/*
	 *  <update id="studentUpdate" parameterType="StudentVO">
		    UPDATE student SET
		    name=#{name},kor=#{kor},eng=#{eng},math=#{math}
		    WHERE hakbun=#{hakbun}
		  </update>
	 */
	@Update("UPDATE student SET " + 
			"name=#{name},kor=#{kor},eng=#{eng},math=#{math} " + 
			"WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
	
	/*
	 *  <delete id="studentDelete" parameterType="int">
		    DELETE FROM student WHERE hakbun=#{hakbun}
		  </delete>
	 */
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	
	/*
	 *   <insert id="studentInsert" parameterType="StudentVO">
		    <selectKey keyProperty="hakbun" order="BEFORE" resultType="int">
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
	@SelectKey(keyProperty = "hakbun" , resultType = int.class, before = true,
			 statement = "SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student")
	@Insert("INSERT INTO student VALUES(#{hakbun}, #{name}, #{kor}, #{eng},#{math})")
	public void studentInsert(StudentVO vo);
}
