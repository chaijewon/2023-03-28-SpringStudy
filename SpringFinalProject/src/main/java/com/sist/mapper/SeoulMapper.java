package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.SeoulVO;
public interface SeoulMapper {
  /*
   *      <select id="seoulLocationData" resultType="SeoulVO" parameterType="hashmap">
		    SELECT no,poster,title,num
		    FROM (SELECT no,poster,title,rownum as num 
		    FROM (SELECT no,poster,title 
		    FROM seoul_location ORDER BY no ASC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
   */
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${table_name}")
	public int seoulTotalPage(Map map);
}
