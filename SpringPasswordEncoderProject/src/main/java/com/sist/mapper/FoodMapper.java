package com.sist.mapper;
import java.util.*;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
public interface FoodMapper { 
  // <select id="foodCategoryListData" resultType="CategoryVO" parameterType="hashmap">
  public List<CategoryVO> foodCategoryListData(Map map);
  /*
   *  <select id="foodCategoryInfoData" resultType="CategoryVO" 
     parameterType="int">
   */
  public CategoryVO foodCategoryInfoData(int cno);
  // <select id="foodListData" resultType="FoodVO" parameterType="int">
  public List<FoodVO> foodListData(int cno);
}
