package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sist.mapper.CategoryMapper;
// categoryDAO
@Repository
public class CategoryDAO {
   @Autowired
   private CategoryMapper mapper;
   
   /*@Select("SELECT cno,title,subject "
			  +"FROM food_category "
			  +"ORDER BY cno ASC")*/
   public List<CategoryVO> cateListData()
   {
	   return mapper.cateListData();
   }
}
