package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;
public interface FoodMapper {
   @Select("SELECT fno,name FROM food_house WHERE cno=#{cno}")
   public List<FoodVO> foodCategoryListData(int cno);
   @Select("SELECT fno,name,phone,address,parking,time,NVL(menu,'없음') as menu,price,score,type "
		  +"FROM food_house "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
}
