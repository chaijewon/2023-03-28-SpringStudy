package com.sist.dao;

import org.junit.Test;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class FoodCategoryDAO extends SqlSessionDaoSupport{
  /*
   *   <select id="categoryListData" resultType="CategoryVO">
		    SELECT cno,title,subject
		    FROM food_category
		  </select>
   */
	
	public List<CategoryVO> categoryListData()
	{
		return getSqlSession().selectList("categoryListData");
	}
}
