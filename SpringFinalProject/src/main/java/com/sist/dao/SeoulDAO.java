package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class SeoulDAO {
   @Autowired
   private SeoulMapper mapper;
   
   public List<SeoulVO> seoulListData(Map map)
   {
	   return mapper.seoulListData(map);
   }
	
   //@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${table_name}")
   public int seoulTotalPage(Map map)
   {
	   return mapper.seoulTotalPage(map);
   }
}
