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
   /*@Select("SELECT fno,cno,name,poster,phone,type,score "
			  +"FROM food_house "
			  +"WHERE cno=#{cno}")*/
   public List<FoodVO> foodListData(int cno)
   {
	   return mapper.foodListData(cno);
   }
   /*@Select("SELECT title,subject FROM food_category "
			  +"WHERE cno=#{cno}")*/
   public CategoryVO foodCategoryInfoData(int cno)
   {
	   return mapper.foodCategoryInfoData(cno);
   }
   
   /*@Select("SELECT fno,name,poster,num "
			  +"FROM (SELECT fno,name,poster,rownum as num "
			  +"FROM (SELECT fno,name,poster "
			  +"FROM food_location WHERE address LIKE '%'||#{fd}||'%' ORDER BY fno ASC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")*/
   public List<FoodVO> foodFindData(Map map)
   {
	   return mapper.foodFindData(map);
   }
   
   /*@Select("SELECT CEIL(COUNT(*)/20.0) "
			  +"FROM food_location "
			  +"WHERE address LIKE '%'||#{fd}||'%'")*/
	public int foodFindTotalPage(String fd)
	{
		return mapper.foodFindTotalPage(fd);
	}
}
