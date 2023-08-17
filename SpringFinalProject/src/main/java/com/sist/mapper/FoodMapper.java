package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
public interface FoodMapper {
   @Select("SELECT cno,title,poster,subject "
		  +"FROM food_category "
		  +"ORDER BY cno ASC")
   public List<CategoryVO> foodCategoryListData();
   
   @Select("SELECT title,subject FROM food_category "
		  +"WHERE cno=#{cno}")
   public CategoryVO foodCategoryInfoData(int cno);
   
   // <select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
   public List<FoodVO> foodFindData(Map map);
   // <select id="foodFindTotalPage" resultType="int" parameterType="hashmap">
   public int foodFindTotalPage(Map map);
   
   @Select("SELECT fno,name,tel as phone,address,type,time,parking,menu,price,score,poster "
		  +"FROM food_location "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
}
