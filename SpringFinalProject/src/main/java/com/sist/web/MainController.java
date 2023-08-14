package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MainController {
   //@Autowired
   //private FoodDAO fdao;
   
   @GetMapping("main/main.do")
   public String main_page(Model model)
   {
	   //List<CategoryVO> list=fdao.foodCategoryListData();
	   //model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   return "main/main";
   }
   @GetMapping("chat/chat.do")
   public String chat_chat(Model model)
   {
	   model.addAttribute("main_jsp", "../chat/chat.jsp");
	   return "main/main";
   }
}





