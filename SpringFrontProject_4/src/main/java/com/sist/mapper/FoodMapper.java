package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
public interface FoodMapper {
  @Select({"<script>"
	      +"SELECT cno,title,subject,poster "
		  +"FROM food_category "
	      +"WHERE "
		  +"<if test='cno==1'>"
	      +"cno BETWEEN 1 AND 12"
		  +"</if>"
		  +"<if test='cno==2'>"
	      +"cno BETWEEN 13 AND 18"
		  +"</if>"
		  +"<if test='cno==3'>"
	      +"cno BETWEEN 19 AND 30"
		  +"</if>"
	      +" ORDER BY cno ASC"
		  +"</script>"
		 })
  public List<CategoryVO> foodCategoryListData(Map map);
  @Select("SELECT fno,name,poster,type,phone,address,score "
		 +"FROM food_house "
		 +"WHERE cno=#{cno}")
  public List<FoodVO> foodListData(int cno);
}
