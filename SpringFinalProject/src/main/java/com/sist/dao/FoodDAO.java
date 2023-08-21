package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.manager.*;
import com.sist.mapper.FoodMapper;
@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
   public List<CategoryVO> foodCategoryListData()
   {
	   return mapper.foodCategoryListData();
   }
   
   /*@Select("SELECT title,subject FROM food_category "
			  +"WHERE cno=#{cno}")*/
   public CategoryVO foodCategoryInfoData(int cno)
   {
	   return mapper.foodCategoryInfoData(cno);
   }
   /*@Select("SELECT fno,name,address,phone,type,poster "
			  +"FROM food_house "
			  +"WHERE cno=#{cno}")*/
   public List<FoodVO> foodListData(int cno){
	   return mapper.foodListData(cno);
   }
   // <select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
   public List<FoodVO> foodFindData(Map map)
   {
	   return mapper.foodFindData(map);
   }
   // <select id="foodFindTotalPage" resultType="int" parameterType="hashmap">
   public int foodFindTotalPage(Map map)
   {
	   return mapper.foodFindTotalPage(map);
   }
   /*@Select("SELECT fno,name,phone,address,type,time,parking,menu,price,score "
			  +"FROM food_location "
			  +"WHERE fno=#{fno}")*/
   public FoodVO foodDetailData(int fno)
   {
	   return mapper.foodDetailData(fno);
   }
   /*@Select("SELECT fno,name,phone,address,type,time,parking,menu,price,score,poster "
			  +"FROM food_house "
			  +"WHERE fno=#{fno}")*/
   public FoodVO foodDetailHouseData(int fno)
   {
	   return mapper.foodDetailHouseData(fno);
   }
}
