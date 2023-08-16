package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
public interface FoodMapper {
   @Select("SELECT cno,title,poster,subject "
		  +"FROM food_category "
		  +"ORDER BY cno ASC")
   public List<CategoryVO> foodCategoryListData();
   
   @Select("SELECT title,subject FROM food_category "
		  +"WHERE cno=#{cno}")
   public CategoryVO foodCategoryInfoData(int cno);
}
