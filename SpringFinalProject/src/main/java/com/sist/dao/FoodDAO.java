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
}
