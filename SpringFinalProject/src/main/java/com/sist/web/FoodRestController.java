package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping(value="food/category_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_category() throws Exception
   {
	   List<CategoryVO> list=dao.foodCategoryListData();
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(list);
	   return json;
   }
   @GetMapping(value="food/category_info_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_category_info(int cno) throws Exception
   {
	   CategoryVO vo=dao.foodCategoryInfoData(cno);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
}
