package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Controller
@RequestMapping("food/")
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @RequestMapping("food_find")
   public String food_find(String page,String fd,Model model)
   {
	   if(fd==null)
		   fd="마포";
	   
	   if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize;
		List<FoodEntity> list=dao.foodFindData(fd, start);
		int totalpage=dao.foodFindTotalPage(fd);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("fd", fd);
	   model.addAttribute("main_html", "food/food_find");
	   return "main";
   }
}
