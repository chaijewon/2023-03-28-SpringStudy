package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  
  public List<CategoryVO> foodCategoryListData(Map map)
  {
	  return mapper.foodCategoryListData(map);
  }
  public CategoryVO foodCategoryInfoData(int cno)
  {
	  return mapper.foodCategoryInfoData(cno);
  }
  // <select id="foodListData" resultType="FoodVO" parameterType="int">
  public List<FoodVO> foodListData(int cno)
  {
	  return mapper.foodListData(cno);
  }
}
