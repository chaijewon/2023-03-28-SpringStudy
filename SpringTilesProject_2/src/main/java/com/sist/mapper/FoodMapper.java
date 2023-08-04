package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulVO;
public interface FoodMapper {
   @Select("SELECT cno,title,poster FROM food_category ORDER BY cno ASC")
   public List<CategoryVO> foodCategoryData();
   /*@Select("SELECT fno,name,poster,rownum "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM food_house ORDER BY fno ASC) "
		  +"WHERE rownum<=7")
   public List<FoodVO> foodTop7();
   @Select("SELECT no,title,poster,rownum "
		  +"FROM (SELECT no,title,poster "
		  +"FROM seoul_location ORDER BY no ASC) "
		  +"WHERE rownum<=7")
   public List<SeoulVO> seoulTop7();*/
   
   @Select("SELECT title,subject FROM food_category "
		  +"WHERE cno=#{cno}")
   public CategoryVO foodCategoryInfoData(int cno);
   
   @Select("SELECT fno,cno,name,poster,phone,type,score,address "
		  +"FROM food_house "
		  +"WHERE cno=#{cno}")
   public List<FoodVO> foodListData(int cno);// => JDBC
   
   
   @Select("SELECT fno,name,poster,num "
		  +"FROM (SELECT fno,name,poster,rownum as num "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM food_location WHERE address LIKE '%'||#{fd}||'%' ORDER BY fno ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> foodFindData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/20.0) "
		  +"FROM food_location "
		  +"WHERE address LIKE '%'||#{fd}||'%'")
   public int foodFindTotalPage(String fd);
   
}









