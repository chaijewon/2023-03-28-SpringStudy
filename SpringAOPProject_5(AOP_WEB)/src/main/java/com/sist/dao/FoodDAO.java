package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
   //@Select("SELECT cno,title,poster FROM food_category ORDER BY cno ASC")
   public List<CategoryVO> foodCategoryData()
   {
	   return mapper.foodCategoryData();
   }
   /*@Select("SELECT fno,name,poster,rownum "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM food_house ORDER BY fno ASC) "
		  +"WHERE rownum<=7")*/
   public List<FoodVO> foodTop7()
   {
	   return mapper.foodTop7();
   }
   /*@Select("SELECT no,title,poster,rownum "
		  +"FROM (SELECT no,title,poster "
		  +"FROM seoul_location ORDER BY no ASC) "
		  +"WHERE rownum<=7")*/
   public List<SeoulVO> seoulTop7()
   {
	   return mapper.seoulTop7();
   }
}
