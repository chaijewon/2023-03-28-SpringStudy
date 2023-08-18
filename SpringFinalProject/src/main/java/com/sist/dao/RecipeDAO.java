package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
    @Autowired
    private RecipeMapper mapper;
    
    /*@Select("SELECT no,title,chef,poster,num "
  		  +"FROM (SELECT no,title,chef,poster,rownum as num "
  		  +"FROM (SELECT + INDEX_ASC(recipe recipe_no_pk)no,title,chef,poster "
  		  +"FROM recipe)) "
  		  +"WHERE num BETWEEN #{start} AND #{end}")*/
    public List<RecipeVO> recipeListData(Map map)
    {
    	return mapper.recipeListData(map);
    }
    //@Select("SELECT COUNT(*) FROM recipe")
    public int recipeRowCount()
    {
    	return mapper.recipeRowCount();
    }
    
    /*@Select("SELECT chef,poster,num "
			  +"FROM (SELECT chef,poster,rownum as num "
			  +"FROM (SELECT chef,poster "
			  +"FROM chef)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")*/
    public List<ChefVO> chefListData(Map map)
    {
    	return mapper.chefListData(map);
    }
	   
    //@Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
    public int chefTotalPage()
    {
    	return mapper.chefTotalPage();
    }
    
    //@Select("SELECT * FROM chef WHERE chef=#{chef}")
    public ChefVO chefInfoData(String chef)
    {
    	return mapper.chefInfoData(chef);
    }
    
    public List<RecipeVO> chefFindData(Map map)
    {
    	return mapper.chefFindData(map);
    }
    public int chefFindCount(Map map)
    {
    	return mapper.chefFindCount(map);
    }
}
