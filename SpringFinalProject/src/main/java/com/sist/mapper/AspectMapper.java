package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;
public interface AspectMapper {
  @Select("SELECT name,type,rownum "
		 +"FROM (SELECT name,type FROM food_house ORDER BY fno ASC) "
		 +"WHERE rownum<=7")
  public List<FoodVO> foodTop7Data();
  
  @Select("SELECT title,rownum "
		 +"FROM (SELECT title FROM seoul_location ORDER BY no ASC) "
		 +"WHERE rownum<=7")
  public List<String> seoulTop7Data();
  
  @Select("SELECT title,rownum "
		 +"FROM (SELECT title FROM recipe ORDER BY no ASC) "
		 +"WHERE rownum<=7")
  public List<String> recipeTop7Data();
}
