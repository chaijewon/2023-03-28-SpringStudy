package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class AspectDAO {
  @Autowired
  private AspectMapper mapper;
  
  /*@Select("SELECT name,type,rownum "
			 +"FROM (SELECT name,type FROM food_house ORDER BY fno ASC) "
			 +"WHERE rownum<=7")*/
  public List<FoodVO> foodTop7Data()
  {
	  return mapper.foodTop7Data();
  }
	  
  /*@Select("SELECT title,rownum "
			 +"FROM (SELECT title FROM seoul_location ORDER BY no ASC) "
			 +"WHERE rownum<=7")*/
  public List<String> seoulTop7Data()
  {
	  return mapper.seoulTop7Data();
  }
	   
  /*@Select("SELECT tile,rownum "
			 +"FROM (SELECT title FROM recipe ORDER BY no ASC) "
			 +"WHERE rownum<=7")*/
  public List<String> recipeTop7Data()
  {
	  return mapper.recipeTop7Data();
  }
}
