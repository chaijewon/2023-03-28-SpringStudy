package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;
public interface RecipeMapper {
   @Select("SELECT no,title,chef,poster,num "
		  +"FROM (SELECT no,title,chef,poster,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title,chef,poster "
		  +"FROM recipe)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(Map map);
   
   @Select("SELECT COUNT(*) FROM recipe")
   public int recipeRowCount();
   
   @Select("SELECT chef,poster,num "
			  +"FROM (SELECT chef,poster,rownum as num "
			  +"FROM (SELECT chef,poster "
			  +"FROM chef)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<ChefVO> chefListData(Map map);
	   
   @Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
   public int chefTotalPage();
   
   @Select("SELECT * FROM chef WHERE chef=#{chef}")
   public ChefVO chefInfoData(String chef);
   
   /*
    *  <select id="chefFindData" resultType="RecipeVO" parameterType="hashmap">
	    SELECT no,poster,title,num 
	    FROM (SELECT no,poster,title,rownum as num 
	    FROM (SELECT no,poster,title 
	    FROM recipe WHERE chef=#{chef} AND title LIKE '%'||#{fd}||'%'))
	    WHERE num BETWEEN #{start} AND #{end}
    </select>
	  <select id="chefFindCount" resultType="int" parameterType="hashmap">
	    SELECT COUNT(*) 
	    FROM recipe WHERE chef=#{chef} AND title LIKE '%'||#{fd}||'%'
	  </select>
    */
   public List<RecipeVO> chefFindData(Map map);
   public int chefFindCount(Map map);
   
}
