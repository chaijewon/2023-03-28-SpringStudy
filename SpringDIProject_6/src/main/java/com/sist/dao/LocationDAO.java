package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class LocationDAO extends SqlSessionDaoSupport{
   /*
    *      <sql id="select-sql">
		     SELECT no,title,address,msg 
		     FROM seoul_location
		   </sql>
		   <select id="locationListData" resultType="LocationVO">
		     <include refid="select-sql"/>
		     ORDER BY no ASC
		   </select>
		   <select id="locationDetailData" resultType="LocationVO" parameterType="int">
		     <include refid="select-sql"/>
		     WHERE no=#{no}
		   </select>
    */
	public List<SeoulLocationVO> locationListData()
	{
		return getSqlSession().selectList("locationListData");
	}
	public SeoulLocationVO locationDetailData(int no)
	{
		return getSqlSession().selectOne("locationDetailData", no);
	}
}
