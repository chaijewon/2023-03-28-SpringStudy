package com.sist.web;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   // category.do?cno=1
   @RequestMapping("food/category.do")
   // 4.3 => GET / POST / => (GET,POST)
   public String food_category(String cno,Model model)
   {
	   if(cno==null)
		   cno="1";
	   Map map=new HashMap();
	   map.put("cno", Integer.parseInt(cno));
	   List<CategoryVO> list=dao.categoryListData(map);
	   
	   model.addAttribute("list", list);
	   return "food/category";
   }
}







